package com.example.encriptades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button btnVolver, btnSalir, btnEncriptar, btnDesencriptar;
    TextView tvInfoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnEncriptar = (Button) findViewById(R.id.btnEncriptar);
        btnDesencriptar = (Button) findViewById(R.id.btnDesencriptar);
        tvInfoEnviar = (TextView) findViewById(R.id.tvRespuesta);
        Bundle bundle = getIntent().getExtras();


        String dato = bundle.get("informacion").toString();
        String dato2 = bundle.get("llave").toString();
        String dato3 = bundle.get("parametro").toString();
        tvInfoEnviar.setText(dato + dato2 + dato3);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver1 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(volver1);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEncriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Encriptar = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(Encriptar);
            }
        });

        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Desencriptar = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(Desencriptar);
            }
        });

    }

}