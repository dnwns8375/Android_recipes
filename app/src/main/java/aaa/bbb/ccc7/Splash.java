package aaa.bbb.ccc7;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timer = waiting();
        timer.start();
    }

    @NonNull
    private Thread waiting() {
        return new Thread() {
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
    }
}
