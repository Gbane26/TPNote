package com.example.tpnote;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpnote.databinding.PaysBinding;

import java.util.List;

public class PaysAdapter extends RecyclerView.Adapter<PaysViewHolder>{

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.listener = l;
    }

    private final List<Pays> liste;

    PaysAdapter(List<Pays> liste) {
        this.liste = liste;
    }

    @NonNull
    @Override
    public PaysViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PaysBinding binding = PaysBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PaysViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PaysViewHolder holder, int position) {
        Pays pays = liste.get(position);
        holder.setPays(pays);
        holder.setOnItemClickListener(this.listener);

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }
}
