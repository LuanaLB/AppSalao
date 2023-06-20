package com.cleitonalvesgloria.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.cleitonalvesgloria.projetofinal.databinding.ActivityMainBinding;
import com.cleitonalvesgloria.projetofinal.view.Home;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = binding.ediNome.getText().toString();
                String senha = binding.editSenha.getText().toString();

                if (nome.isEmpty()) {
                    mensagem(view, "Coloque o seu nome!");
                } else if (senha.isEmpty()) {
                    mensagem(view, "Preencha a senha!");
                } else if (senha.length() <= 5) {
                    mensagem(view, "A senha precisa ter pelo menos 6 caracteres");
                } else {
                    navergarPraHome(nome);
                }
            }
        });
    }

    private void mensagem(View view, String mensagem) {
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"));
        snackbar.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    private void navergarPraHome(String nome) {
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("nome", nome);
        startActivity(intent);
    }
}