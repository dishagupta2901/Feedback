package com.example.feedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button submit;
    TextView name,phone;
    TextView DateField;
    TextView TimeField;
    DatabaseReference reference;
    FeedbackMember member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseApp.initializeApp(MainActivity.this);


        submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        DateField = findViewById(R.id.date);
        TimeField = findViewById(R.id.time);
        member = new FeedbackMember();
        reference= FirebaseDatabase.getInstance().getReference().child("FeedbackMember");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime()).trim();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                String time = "Time-"+ format.format(calendar.getTime()).trim();

                DateField.setText(currentDate);
                TimeField.setText(time);

                Log.i("Date",currentDate+" "+time);


                String Name = name.getText().toString().trim();
                Long Phone = Long.parseLong(phone.getText().toString().trim());

                //String id = reference.push().getKey();
                member = new FeedbackMember(Name,currentDate,time,Phone);
                //member.setDate(currentDate);
                //member.setTime(time);
                reference.push().setValue(member);

                Toast.makeText(MainActivity.this,"Submitted Successfully..",Toast.LENGTH_SHORT).show();



            }
        });
    }




    }
