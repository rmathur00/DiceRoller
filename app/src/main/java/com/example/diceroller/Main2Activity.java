package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.diceroller.MainActivity.question;

public class Main2Activity extends AppCompatActivity {
    EditText element;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        element = findViewById(R.id.Element);

    }

    public void save(View view){
        Toast.makeText(Main2Activity.this,"Icebreaker Added",Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this,MainActivity.class);
        question.add(element.getText().toString());
        startActivity(intent1);

    }

    public void changeactivity(View view){
        Intent intent2 = new Intent(this,MainActivity.class);
        startActivity(intent2);
    }
}
