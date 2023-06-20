package com.cleitonalvesgloria.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import com.cleitonalvesgloria.projetofinal.databinding.ActivityAgendamentoBinding;
import com.google.android.material.snackbar.Snackbar;
import java.util.Calendar;

public class Agendamento extends AppCompatActivity {
        private ActivityAgendamentoBinding binding;
        private Calendar calendar = Calendar.getInstance();
        private String data = "";
        private String hora = "";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                binding = ActivityAgendamentoBinding.inflate(getLayoutInflater());
                setContentView(binding.getRoot());

                getSupportActionBar().hide();
                String nome = getIntent().getExtras().getString("nome").toString();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        binding.datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, monthOfYear);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                String dia = Integer.toString(dayOfMonth);
                                String mes;

                                if (dayOfMonth < 10) {
                                        dia = "0" + dayOfMonth;
                                }
                                if (monthOfYear < 10) {
                                        mes = Integer.toString(monthOfYear + 1);
                                } else {
                                        mes = Integer.toString(monthOfYear + 1);
                                }

                                data = dia + " / " + mes + " / " + year;
                        });
                }

                binding.timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
                        String minuto;

                        if (minute < 10) {
                                minuto = "0" + minute;
                        } else {
                                minuto = Integer.toString(minute);
                        }

                        hora = hourOfDay + ":" + minuto;
                });

                binding.timePicker.setIs24HourView(true);
                binding.btAgendar.setOnClickListener(view -> {
                        View designer1 = binding.desig1;
                        View designer2 = binding.desig2;
                        View designer3 = binding.desig3;

                        if (hora.isEmpty()) {
                                mensagem(view, "Preencha o horário!", "#FF0000");
                        } else if (hora.compareTo("8:00") < 0 || hora.compareTo("19:00") > 0) {
                                mensagem(view, "Agendamento realizado com sucesso!", "#FF0000");
                        } else if (data.isEmpty()) {
                                mensagem(view, "Coloque uma data!", "#FF0000");
                        } else if (designer1.onCheckIsTextEditor() && !data.isEmpty() && !hora.isEmpty()) {
                                mensagem(view, "Agendamento realizado com sucesso!", "#FF03DAC5");
                        } else if (designer2.onCheckIsTextEditor() && !data.isEmpty() && !hora.isEmpty()) {
                                mensagem(view, "Agendamento realizado com sucesso!", "#FF03DAC5");
                        } else if (designer3.onCheckIsTextEditor() && !data.isEmpty() && !hora.isEmpty()) {
                                mensagem(view, "Agendamento realizado com sucesso!", "#FF03DAC5");
                        } else {
                                mensagem(view, "Escolha uma designer!", "#FF0000");
                        }
                });
        }

        private void mensagem(View view, String mensagem, String cor) {
                Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.parseColor(cor));
                snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                snackbar.show();
        }
}
