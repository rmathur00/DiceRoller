package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView rollNum, textMessage, Score, Ques;
    EditText usernumber;
    int count = 0;
   static ArrayList<String> question = new ArrayList<>();
    public static final String Extra_message = "Not working";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollNum = findViewById(R.id.number);
        usernumber = findViewById(R.id.userNum);
        textMessage = findViewById(R.id.message);
        Score = findViewById(R.id.score);
        Ques = findViewById(R.id.ques);


        question.add("If you could go anywhere in the world, where would you go?");
        question.add("If you were stranded on a desert island, what three things would you want to take with you?");
        question.add("If you could eat only one food for the rest of your life, what would that be?");
        question.add("If you won a million dollars, what is the first thing you would buy?");
        question.add("If you could spend the day with one fictional character, who would it be?");
        question.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public int roll_the_dice(int n){
        Random r = new Random();
        int number = r.nextInt(n);
        return number;
    }

    public void rollButtonclicked(View view){
        // Genereates random number
        rollNum.setText(Integer.toString(roll_the_dice(7-1)+1));

        if (usernumber.getText().toString().equals(rollNum.getText().toString())){
            textMessage.setText("Congratulation!!! ^_^");
            count++;
            Score.setText("Score: " + count);
        }else{
            textMessage.setText("Not equal ~_~");
        }

    }

    public void icebreaker(View view){

        int num = roll_the_dice(question.size());
        Ques.setText(question.get(num));

    }

    public void changeactivity(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void finish(View view){
        Intent i = new Intent(this, FInishactivity.class);
        String message = Score.getText().toString();
        i.putExtra(Extra_message,message);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
