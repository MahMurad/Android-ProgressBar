package com.example.app132progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        progressBar =(ProgressBar) findViewById(R.id.splashscreen_progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doDelay();
                changeIntent();
            }
        });
        thread.start();
    }
    public void doDelay(){
        for(i=20;i<=100;i+=20){
            try{
                Thread.sleep(1000);
                progressBar.setProgress(i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void changeIntent(){
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
