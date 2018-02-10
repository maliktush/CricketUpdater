package com.tusharmalik.cricketupdater;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tusharmalik.cricketupdater.Models.CricAdapter;
import com.tusharmalik.cricketupdater.db.CricketDatabaseHelper;
import com.tusharmalik.cricketupdater.db.CricketTable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnadd;
    RecyclerView List;
    CricAdapter cricadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CricketDatabaseHelper myDbHelper = new CricketDatabaseHelper(this);
        final SQLiteDatabase writeDb = myDbHelper.getWritableDatabase();
        SQLiteDatabase readDb = myDbHelper.getReadableDatabase();

        ArrayList<Crics> Cric = CricketTable.getAllCrics(readDb);

        List = (RecyclerView) findViewById(R.id.List);
        cricadapter = new CricAdapter(new ArrayList<Crics>());

        List.setLayoutManager(new LinearLayoutManager(this));
        List.setAdapter(cricadapter);

        btnadd=findViewById(R.id.add);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddNewMatch.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "ADD YOUR NEW MATCH HERE", Toast.LENGTH_LONG).show();
            }
        });
    }
}
