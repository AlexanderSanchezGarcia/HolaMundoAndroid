package miguelalexander.sanchez.holamundoandroid.Logica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import miguelalexander.sanchez.holamundoandroid.R;

public class MultiActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private EditText editTextXM;
    private EditText editTextYM;
    private EditText editTextTotalM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        editTextXM = findViewById(R.id.editTextNumberXM);
        editTextYM = findViewById(R.id.editTextNumberYM);
        editTextTotalM = findViewById(R.id.editTextNumberTotalM);
        editTextXM.setOnFocusChangeListener(this);
        editTextYM.setOnFocusChangeListener(this);
        editTextTotalM.setEnabled(false);
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(!hasFocus) {
            realizaOperacion();
        }
    }

    private void realizaOperacion() {
        int total = 0;
        if(editTextXM.getText().toString() != null) {
            if(isEntero(editTextXM.getText().toString())) {
                total += getEntero(editTextXM.getText().toString());
            }
        }
        if(editTextYM.getText().toString() != null) {
            if(isEntero(editTextYM.getText().toString())) {
                total = (total) * (getEntero(editTextYM.getText().toString()));
            }
        }
        editTextTotalM.setText(String.format("%d", total), TextView.BufferType.SPANNABLE);
        editTextTotalM.setEnabled(false);
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
