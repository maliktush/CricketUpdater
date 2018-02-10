package com.tusharmalik.cricketupdater;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tusharmalik.cricketupdater.db.CricketDatabaseHelper;
import com.tusharmalik.cricketupdater.db.CricketTable;

public class AddNewMatch extends AppCompatActivity {
    EditText etID,etTeam1,etTeam2,etDate,etTime,etType;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_match);
        btnAdd=findViewById(R.id.btnAdd);

        etTeam1=findViewById(R.id.etTeam1);
        etTeam2=findViewById(R.id.etTeam1);
        etDate=findViewById(R.id.etDate);
        etTime=findViewById(R.id.etTime);
        etType=findViewById(R.id.etType);
        CricketDatabaseHelper myDbHelper = new CricketDatabaseHelper(this);
        final SQLiteDatabase writeDb = myDbHelper.getWritableDatabase();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(     !etTeam1.getText().toString().isEmpty()&&
                        !etTeam2.getText().toString().isEmpty()&&!etDate.getText().toString().isEmpty()&&
                        !etTime.getText().toString().isEmpty()&&!etType.getText().toString().isEmpty()){
                    CricketTable.addCrics(new Crics(0,
                                    etTeam1.getText().toString(),
                                    etTeam2.getText().toString(),
                                    etDate.getText().toString(),
                                    etTime.getText().toString(),
                                    etType.getText().toString()),
                             writeDb);
                    Intent i = new Intent(AddNewMatch.this,MainActivity.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(AddNewMatch.this, "One more more of the above fields are empty..." +
                            "Please fill them first", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
}
