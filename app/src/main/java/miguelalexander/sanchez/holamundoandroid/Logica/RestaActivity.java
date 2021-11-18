package miguelalexander.sanchez.holamundoandroid.Logica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import miguelalexander.sanchez.holamundoandroid.R;

public class RestaActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private EditText editTextXR;
    private EditText editTextYR;
    private EditText editTextTotalR;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resta);
        editTextXR = findViewById(R.id.editTextNumberXR);
        editTextYR = findViewById(R.id.editTextNumberYR);
        editTextTotalR = findViewById(R.id.editTextNumberTotalR);
        editTextXR.setOnFocusChangeListener(this);
        editTextYR.setOnFocusChangeListener(this);
        editTextTotalR.setEnabled(false);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(!hasFocus) {
            realizaOperacion();
        }
    }

    private void realizaOperacion() {
        int total = 0;
        if(editTextXR.getText().toString() != null) {
            if(isEntero(editTextXR.getText().toString())) {
                total += getEntero(editTextXR.getText().toString());
            }
        }
        if(editTextYR.getText().toString() != null) {
            if(isEntero(editTextYR.getText().toString())) {
                total -= getEntero(editTextYR.getText().toString());
            }
        }
        editTextTotalR.setText(String.format("%d", total), TextView.BufferType.SPANNABLE);
        editTextTotalR.setEnabled(false);
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