package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CrimeAdapter crimeAdapter;
    private CrimeDatabase crimeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ایجاد یا باز کردن پایگاه داده
        crimeDatabase = Room.databaseBuilder(getApplicationContext(),
                        CrimeDatabase.class, "crime-database.db")
                .allowMainThreadQueries() // فقط برای تست، در عمل باید از background thread استفاده کنید
                .build();

        // دسترسی به Dao و گرفتن داده‌ها
        List<Crime> crimeList = crimeDatabase.crimeDao().getAllCrimes();

        // تنظیم RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        crimeAdapter = new CrimeAdapter(crimeList);
        recyclerView.setAdapter(crimeAdapter);

        // اگر داده‌ای وجود ندارد، داده‌های اولیه اضافه کنید
        if (crimeList.isEmpty()) {
            addInitialData();
        }
    }

    private void addInitialData() {
        Crime crime1 = new Crime(UUID.randomUUID(), "Crime 1", new Date(), false);
        Crime crime2 = new Crime(UUID.randomUUID(), "Crime 2", new Date(), true);

        crimeDatabase.crimeDao().insertCrime(crime1);
        crimeDatabase.crimeDao().insertCrime(crime2);

        // داده‌های جدید را به روز کنید
        crimeAdapter.setCrimeList(crimeDatabase.crimeDao().getAllCrimes());
    }
}
