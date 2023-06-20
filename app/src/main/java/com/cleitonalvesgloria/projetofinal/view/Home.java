package com.cleitonalvesgloria.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.cleitonalvesgloria.projetofinal.R;
import com.cleitonalvesgloria.projetofinal.adapter.AdapterServicos;
import com.cleitonalvesgloria.projetofinal.databinding.ActivityHomeBinding;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cleitonalvesgloria.projetofinal.model.Servicos;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private AdapterServicos adapterServicos;
    private List<Servicos> listaServicos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        String nome = getIntent().getExtras().getString("nome");
        binding.txtNomeUsuario.setText("Bem-vindo, " + nome);

        RecyclerView recyclerViewServicos = binding.recyclerViewServicos;
        recyclerViewServicos.setLayoutManager(new GridLayoutManager(this, 2));
        adapterServicos = new AdapterServicos(this, listaServicos);
        recyclerViewServicos.setHasFixedSize(true);
        recyclerViewServicos.setAdapter(adapterServicos);
        getServicos();

        binding.btAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Agendamento.class);
                intent.putExtra("nome", nome);
                startActivity(intent);
            }
        });
    }

    private void getServicos() {
        Servicos servico1 = new Servicos(R.drawable.cilios, "Cilios");
        listaServicos.add(servico1);

        Servicos servico2 = new Servicos(R.drawable.rosto, "Limpeza de pele");
        listaServicos.add(servico2);

        Servicos servico3 = new Servicos(R.drawable.sombrancelha, "Sobrancelha");
        listaServicos.add(servico3);

        Servicos servico4 = new Servicos(R.drawable.rosto, "Pele");
        listaServicos.add(servico4);
    }
}


/*class Home: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBindig
private lateinit var adapterServicos: AdapterServicos
private lateinit var listaServicos: MutableList<Servicos> = mutableListOf()


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        binding =ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome - intent.extras?.getString("nome")

        binding.txtNomeUusuario.text = "Bem-vindo(a), $nome"
        val recyclerViewServices = binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        adapterServicos = AdapterServicos(this, listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = adapterServicos
        getServicos()

        binding.btAgendar.setOnclickListener{
            val intent = Intent(this,Agendamento::class.java)
        intent.putExtra("nome",nome)
        startActivity(intent)
        }
        }

        private fun getServicos(){
        val servico1 = Servicos(R.drawable.img1, "Cilios")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.img2, "Limpeza de pele")
        listaServicos.add(servico1)

        val servico3 = Servicos(R.drawable.img3, "Sombrancelha")
        listaServicos.add(servico1)

        val servico4 = Servicos(R.drawable.img4, "Pele")
        listaServicos.add(servico1)
        }
        }*/