package com.example.aula3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edtValor1, edtValor2, edtResposta;
    Spinner spinnerOperacao, spinnerDecimais;
    int decimais = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor1 = findViewById(R.id.editTextV1);
        edtValor2 = findViewById(R.id.editTextV2);
        edtResposta = findViewById(R.id.editTextSoma);
        spinnerOperacao = findViewById(R.id.spinnerOperacao);
        spinnerDecimais = findViewById(R.id.spinnerDecimais);

        List<String> decimaisList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            decimaisList.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, decimaisList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDecimais.setAdapter(adapter);
        spinnerDecimais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                decimais = position + 1;
                calcular();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerOperacao.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        calcular();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void calcular(){
        if(edtValor1.getText().toString().isEmpty()) return;
        double v1 = Double.parseDouble(edtValor1.getText().toString());
        double v2 = 0;
        if(!edtValor2.getText().toString().isEmpty()){
            v2 = Double.parseDouble(edtValor2.getText().toString());
        }
        Calculadora calc = new Calculadora(v1, v2);
        double resultado = 0;
        int pos = spinnerOperacao.getSelectedItemPosition();
        switch(pos){
            case 0: resultado = calc.somar(); break;
            case 1: resultado = calc.subtrair(); break;
            case 2: resultado = calc.multiplicar(); break;
            case 3: resultado = calc.dividir(); break;
            case 4: resultado = calc.exponenciar(); break;
            case 5: resultado = calc.radiciar(); break;
        }
        edtResposta.setText(calc.formatar(resultado, decimais));
    }
}