package net.apkode.guida.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.apkode.guida.R;
import net.apkode.guida.holder.MaisonHolder;
import net.apkode.guida.model.Maison;
import java.util.List;


public class MaisonAdapter extends RecyclerView.Adapter<MaisonHolder>{
    List<Maison> list;

    public MaisonAdapter(List<Maison> list) {
        this.list = list;
    }

    @Override
    public MaisonHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_liste_maison, viewGroup, false);
        return new MaisonHolder(view);
    }

    @Override
    public void onBindViewHolder(MaisonHolder maisonHolder, int position) {
        Maison maison = list.get(position);
        maisonHolder.bind(maison);
        maisonHolder.itemView.setTag(maison);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

