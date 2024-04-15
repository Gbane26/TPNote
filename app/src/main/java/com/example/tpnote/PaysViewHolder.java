package com.example.tpnote;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tpnote.databinding.PaysBinding;



public class PaysViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final PaysBinding ui;
    private PaysAdapter.OnItemClickListener listener;

    public void setOnItemClickListener(PaysAdapter.OnItemClickListener l) {
        this.listener = l;
    }
    public PaysViewHolder(PaysBinding ui) {
        super(ui.getRoot());
        this.ui = ui;
        itemView.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        listener.onItemClick(getAdapterPosition());
    }

    public void setPays(Pays pays) {
        ui.nom.setText(pays.getNom());
        ui.superficie.setText(Integer.toString(pays.getSuperficie()));
        ui.imageView.setImageResource(pays.getImage());

    }

}