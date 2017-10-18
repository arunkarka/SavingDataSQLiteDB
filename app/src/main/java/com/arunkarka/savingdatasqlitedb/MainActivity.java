package com.arunkarka.savingdatasqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static boolean dbExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDB = (Button) findViewById(R.id.create_db);
        createDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDatabase();
            }
        });

        Button deleteDB = (Button) findViewById(R.id.delete_db);
        deleteDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDatabase();
            }
        });
    }

    private void createDatabase() {
        if (dbExists) {
            Toast.makeText(this, "Student DB was already created.", Toast.LENGTH_SHORT).show();
        } else {
            FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
            dbExists = true;
            Toast.makeText(this, "Student DB created", Toast.LENGTH_SHORT).show();
        }
    }
    private void deleteDatabase() {
        if (dbExists) {
            dbExists = false;
            Toast.makeText(this, "Student DB deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "DB doesn't exist", Toast.LENGTH_SHORT).show();
        }

    }
}
