package com.example.aula1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtValor1, edtValor2, edtResposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtValor1 = (EditText) findViewById(R.id.editTextV1);
        edtValor2 = (EditText) findViewById(R.id.editTextV2);
        edtResposta = (EditText) findViewById(R.id.editTextSoma);
    }
    public void somar(View v){
        double valor1, valor2, soma;
        valor1 = Double.parseDouble(edtValor1.getText().toString());
        valor2 = Double.parseDouble(edtValor2.getText().toString());

        soma = valor1 + valor2;

        edtResposta.setText(String.valueOf(soma));
    }

    public void subtrair(View v){
        double valor1, valor2, subtracao;
        valor1 = Double.parseDouble(edtValor1.getText().toString());
        valor2 = Double.parseDouble(edtValor2.getText().toString());

        subtracao = valor1 - valor2;

        edtResposta.setText(String.valueOf(subtracao));
    }

    public void multiplicar(View v){
        double valor1, valor2, multiplicacao;
        valor1 = Double.parseDouble(edtValor1.getText().toString());
        valor2 = Double.parseDouble(edtValor2.getText().toString());

        multiplicacao = valor1 * valor2;

        edtResposta.setText(String.valueOf(multiplicacao));
    }

    public void dividir(View v){
        double valor1, valor2, divisao;
        valor1 = Double.parseDouble(edtValor1.getText().toString());
        valor2 = Double.parseDouble(edtValor2.getText().toString());

        if (valor2 != 0) {
            divisao = valor1 / valor2;
            edtResposta.setText(String.valueOf(divisao));
        } else {
            edtResposta.setText("Erro: Divisão por zero");
        }
    }

    public void exponenciar(View v){
        double valor1, valor2, exponenciacao;
        valor1 = Double.parseDouble(edtValor1.getText().toString());
        valor2 = Double.parseDouble(edtValor2.getText().toString());

        exponenciacao = Math.pow(valor1, valor2);

        edtResposta.setText(String.valueOf(exponenciacao));
    }

    public void radiciar(View v){
        double valor1, valor2, radiciacao;
        valor1 = Double.parseDouble(edtValor1.getText().toString());
        valor2 = Double.parseDouble(edtValor2.getText().toString());

        if (valor2 != 0) {
            radiciacao = Math.pow(valor1, 1.0 / valor2);
            edtResposta.setText(String.valueOf(radiciacao));
        } else {
            edtResposta.setText("Erro: Índice de raiz não pode ser zero");
        }
    }

    public void areaTriangulo(View v){
        double base, altura, area;
        base = Double.parseDouble(edtValor1.getText().toString());
        altura = Double.parseDouble(edtValor2.getText().toString());

        area = (base * altura) / 2;

        edtResposta.setText(String.valueOf(area));
    }

    public void areaRetangulo(View v){
        double comprimento, largura, area;
        comprimento = Double.parseDouble(edtValor1.getText().toString());
        largura = Double.parseDouble(edtValor2.getText().toString());

        area = comprimento * largura;

        edtResposta.setText(String.valueOf(area));
    }
}