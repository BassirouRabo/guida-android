package net.apkode.guida.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.apkode.guida.R;
import net.apkode.guida.model.Maison;

import java.io.Serializable;

public class MaisonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maison);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Maison maison = (Maison) getIntent().getSerializableExtra("Maison");

     //   TextView txtVille = (TextView) findViewById(R.id.txtVille);
        TextView txtQuartier = (TextView) findViewById(R.id.txtQuartier);
      //  TextView txtType = (TextView) findViewById(R.id.txtType);
        TextView txtPrix = (TextView) findViewById(R.id.txtPrix);
        TextView txtDescription = (TextView) findViewById(R.id.txtDescription);

        ImageView imageView = (ImageView) findViewById(R.id.imageCover);

        Picasso.with(imageView.getContext())
                .load(maison.getImage())
                .fit().centerCrop()
                .into(imageView);

      //  txtVille.setText(maison.getVille());
        txtQuartier.setText(maison.getQuartier());
     //   txtType.setText(maison.getType());
        txtPrix.setText(maison.getPrix());
        txtDescription.setText(maison.getDescription());


        FloatingActionButton fabDirection = (FloatingActionButton)findViewById(R.id.fabDirection);
        FloatingActionButton fabCall = (FloatingActionButton)findViewById(R.id.fabCall);

        fabDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("Maison", maison);
                startActivity(intent);
            }
        });

        fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = maison.getTelephone().toString();
                Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
                try {
                    startActivity(in);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "Erreur réseau Veuillez réessayer", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
