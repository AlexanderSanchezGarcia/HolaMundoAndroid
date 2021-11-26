package miguelalexander.sanchez.holamundoandroid.Logica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import miguelalexander.sanchez.holamundoandroid.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonSuma;
    private Button buttonResta;
    private Button buttonMulti;
    private Button buttonDivision;
    private Button buttonRad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSuma = findViewById(R.id.buttonSuma);
        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirSuma();
            }
        });
        buttonResta = findViewById(R.id.buttonResta);
        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirResta();
            }
        });
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMulti();
            }
        });
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDivision();
            }
        });
        buttonRad = findViewById(R.id.buttonRad);
        buttonRad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirRadianes();
            }
        });
    }

    protected void onStart() {
        super.onStart();

    }

    private void abrirSuma() {
        Intent intent = new Intent(this, SumaActivity.class);
        startActivity(intent);
    }
    private void abrirResta() {
        Intent intent = new Intent(this, RestaActivity.class);
        startActivity(intent);
    }
    private void abrirMulti() {
        Intent intent = new Intent(this, MultiActivity.class);
        startActivity(intent);
    }
    private void abrirDivision() {
        Intent intent = new Intent(this, DivisionActivity.class);
        startActivity(intent);
    }
    private void abrirRadianes() {
        Intent intent = new Intent(this, RadianesActivity.class);
        startActivity(intent);
    }
}