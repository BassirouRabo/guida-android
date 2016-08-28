package net.apkode.guida;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.apkode.guida.activity.MaisonsActivity;

public class Launch extends AppCompatActivity {
    private static final int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        new BackgroundTask().execute();
    }

    private class BackgroundTask extends AsyncTask {
        Intent intent;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            intent = new Intent(Launch.this, MaisonsActivity.class);
        }

        @Override
        protected Object doInBackground(Object[] params) {
            try {
                Thread.sleep(SPLASH_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            startActivity(intent);
            finish();
        }
    }

}
