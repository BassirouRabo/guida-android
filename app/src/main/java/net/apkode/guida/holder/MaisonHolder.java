package net.apkode.guida.holder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import net.apkode.guida.R;
import net.apkode.guida.activity.MaisonActivity;
import net.apkode.guida.model.Maison;
import java.io.Serializable;


public class MaisonHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imageView;
    private TextView txtQuartier;
    private TextView txtPrix;


    public MaisonHolder(View itemView) {
        super(itemView);

        imageView = (ImageView)itemView.findViewById(R.id.imageView);
        txtQuartier = (TextView)itemView.findViewById(R.id.txtQuartier);
        txtPrix = (TextView)itemView.findViewById(R.id.txtPrix);

        itemView.setOnClickListener(this);
    }

    public void bind(Maison maison) {

        txtQuartier.setText(maison.getQuartier());
        txtPrix.setText(maison.getPrix());

        Picasso.with(imageView.getContext())
                .load(maison.getImage())
                .fit().centerCrop()
                .into(imageView);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext().getApplicationContext(), MaisonActivity.class);
        intent.putExtra("Maison", (Serializable) v.getTag());
        v.getContext().startActivity(intent);
    }
}
