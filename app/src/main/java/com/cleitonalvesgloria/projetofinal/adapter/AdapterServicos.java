package com.cleitonalvesgloria.projetofinal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cleitonalvesgloria.projetofinal.databinding.ServicosItemBinding;
import com.cleitonalvesgloria.projetofinal.model.Servicos;

import java.util.List;

public class AdapterServicos extends RecyclerView.Adapter<AdapterServicos.ServicosViewHolder> {
    private Context context;
    private List<Servicos> listaServicos;

    public AdapterServicos(Context context, List<Servicos> listaServicos) {
        this.context = context;
        this.listaServicos = listaServicos;
    }

    @NonNull
    @Override
    public ServicosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServicosItemBinding binding = ServicosItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ServicosViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicosViewHolder holder, int position) {
        holder.imgServico.setImageResource(listaServicos.get(position).getImg());
        holder.txtServico.setText(listaServicos.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return listaServicos.size();
    }

    public class ServicosViewHolder extends RecyclerView.ViewHolder {
        ImageView imgServico;
        TextView txtServico;

        public ServicosViewHolder(ServicosItemBinding binding) {
            super(binding.getRoot());
            imgServico = binding.imgServico;
            txtServico = binding.txtServico;
        }
    }
}