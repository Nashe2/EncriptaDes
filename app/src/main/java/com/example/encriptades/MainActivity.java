package com.example.encriptades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente;
    Button btnEncriptar;
    Button btnDesencriptar;
    EditText etInfoEnviar;
    EditText etLlaveEnviar;
    String parametro = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSiguiente = (Button) findViewById(R.id.btnEncriptar);

        btnEncriptar = (Button) findViewById(R.id.btnEncriptar);
        btnDesencriptar = (Button) findViewById(R.id.btnDesencriptar);
        etInfoEnviar = (EditText) findViewById(R.id.etInfoEnviar);
        etLlaveEnviar = (EditText) findViewById(R.id.etLlaveEnviar);

        btnEncriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parametro = "0";
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("informacion", etInfoEnviar.getText().toString());
                intent.putExtra("Llave", etLlaveEnviar.getText().toString());
                intent.putExtra("parametro", parametro);

                startActivity(intent);
            }
        });

        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parametro = "1";
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                intent1.putExtra("informacion", etInfoEnviar.getText().toString());
                intent1.putExtra("Llave", etLlaveEnviar.getText().toString());
                intent1.putExtra("parametro", parametro);

                startActivity(intent1);
            }
        });

    }

    public static String encripta(String mensaje, String llave, int n) {
        String caracteres = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ,. /*-':{@|?}~¿¡!;_+<>%&$#()[=]"
                + "abcdefghijklmnñopqrstuvwxyz0123456789áéíóú";
        String mensajeLLave = "";
        String mensaje2 = "";
        String resultado = "";
        int veces = mensaje.length() / llave.length();
        for (int i = 0; i <= veces; i++) {
            mensaje2 += llave;
        }
        mensaje2 = mensaje2.substring(0, mensaje.length());
        String textoEncriptado = "";
        if (n == 0) {
            for (int i = 0; i < mensaje.length(); i++) {
                String caracterM = mensaje.substring(i, i + 1);
                int posicionM = caracteres.indexOf(caracterM);
                String caracterLL = mensaje2.substring(i, i + 1);
                int posicionLL = caracteres.indexOf(caracterLL);
                int res = (posicionM + posicionLL) % caracteres.length();
                String caracterE = caracteres.substring(res, res + 1);
                textoEncriptado += caracterE;

            }
            resultado = textoEncriptado;

        } else if (n == 1) {
            textoEncriptado = mensaje;
            String desencriptado = "";
            for (int i = 0; i < textoEncriptado.length(); i++) {
                String caracterM = textoEncriptado.substring(i, i + 1);
                int posicionM = caracteres.indexOf(caracterM);
                String caracterLL = mensaje2.substring(i, i + 1);
                int posicionLL = caracteres.indexOf(caracterLL);
                int suma = posicionM - posicionLL;
                int res = 0;
                if (suma < 0) {
                    res = suma + caracteres.length();
                } else {
                    res = posicionM - posicionLL;
                }
                String caracterE = caracteres.substring(res, res + 1);

                desencriptado += caracterE;
            }
            resultado = desencriptado;

        }
        return resultado;
    }
}
