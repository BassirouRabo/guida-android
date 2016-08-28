package net.apkode.guida.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.loopj.android.http.JsonHttpResponseHandler;

import net.apkode.guida.R;
import net.apkode.guida.adapter.MaisonAdapter;
import net.apkode.guida.api.ApiRestClient;
import net.apkode.guida.model.Maison;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MaisonsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Maison> maisons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maisons);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getDataFromApi();
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    public void getDataFromApi() {
        ApiRestClient.get("maisons", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                ProgressBar loading = (ProgressBar) findViewById(R.id.loading);
                loading.setVisibility(View.GONE);
                super.onSuccess(statusCode, headers, response);

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        maisons.add(new Maison(
                                jsonObject.getString("ville"),
                                jsonObject.getString("quartier"),
                                jsonObject.getString("type"),
                                jsonObject.getString("prix"),
                                jsonObject.getString("description"),
                                jsonObject.getString("image"),
                                jsonObject.getDouble("latitude"),
                                jsonObject.getDouble("longitude"),
                                jsonObject.getLong("telephone")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setAdapter(new MaisonAdapter(maisons));
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_maisons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(), PresentationActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
