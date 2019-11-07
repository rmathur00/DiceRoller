package com.example.diceroller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.webapi.SlackWebApiClient;

public class FInishactivity extends AppCompatActivity {
    final String slacktoken = "xoxp-763082602722-776958805776-827687664166-c76843b23990d98b3df4d872eaa4a7b3";
    SlackWebApiClient mWebApiClient;

    private class SlackAPITask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... voids) {
            Intent i = getIntent();
            String message = i.getStringExtra(MainActivity.Extra_message);
            mWebApiClient.postMessage("CP33A29PV", "Your Score: " + message);
            return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mWebApiClient = SlackClientFactory.createWebApiClient(slacktoken);

    }

    public void share(View view) {
        try {
            enableStrictMode();
            Intent i = getIntent();
            String message = i.getStringExtra(MainActivity.Extra_message);
            Toast.makeText(FInishactivity.this,"Your score " + message + " is shared",Toast.LENGTH_SHORT).show();
            new SlackAPITask().execute();
        } catch (Exception ex) {
            Toast.makeText(FInishactivity.this, "error server not responding" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("MyActivity:Error", "Error on button click, see the logs", ex);
        }

    }

    private void enableStrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void back(View view) {
        Intent returnBtn = new Intent(this, MainActivity.class);
        startActivity(returnBtn);

    }
}
