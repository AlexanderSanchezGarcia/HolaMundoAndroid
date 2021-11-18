package miguelalexander.sanchez.holamundoandroid.Logica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import miguelalexander.sanchez.holamundoandroid.R;

public class DivisionActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private EditText editTextXD;
    private EditText editTextYD;
    private EditText editTextTotalD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        editTextXD = findViewById(R.id.editTextNumberXD);
        editTextYD = findViewById(R.id.editTextNumberYD);
        editTextTotalD = findViewById(R.id.editTextNumberTotalD);
        editTextXD.setOnFocusChangeListener(this);
        editTextYD.setOnFocusChangeListener(this);
        editTextTotalD.setEnabled(false);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(!hasFocus) {
            realizaOperacion();
        }
    }

    private void realizaOperacion() {
        int total = 0;
        if(editTextXD.getText().toString() != null) {
            if(isEntero(editTextXD.getText().toString())) {
                total += getEntero(editTextXD.getText().toString());
            }
        }
        if(editTextYD.getText().toString() != null) {
            if(isEntero(editTextYD.getText().toString())) {
                total = (total) / (getEntero(editTextYD.getText().toString()));
            }
        }
        editTextTotalD.setText(String.format("%d", total), TextView.BufferType.SPANNABLE);
        editTextTotalD.setEnabled(false);
    }

    private int getEntero(String entero) {
        try {
            return Integer.parseInt(entero);
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private boolean isEntero(String entero) {
        try {
            if(entero == null || entero.length() == 0) {
                return false;
            }
            Integer.parseInt(entero);
            return true;
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }
}