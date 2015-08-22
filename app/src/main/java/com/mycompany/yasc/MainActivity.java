package com.mycompany.yasc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends AppCompatActivity {

    private void setValues(EditText input, EditText output, double factor) {
        String sValue = input.getText().toString().replace(',', '.');
        if (sValue.isEmpty()) {
            output.setText("");
        } else {
            double value = Double.valueOf(sValue) * factor;
            output.setText(String.format("%.2f", value));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextGlucoseMmol = (EditText) findViewById(R.id.glucose_mmol);
        final EditText editTextGlucoseDl = (EditText) findViewById(R.id.glucose_mg);
        final EditText editTextCholesterolMmol = (EditText) findViewById(R.id.cholesterol_mmol);
        final EditText editTextCholesterolDl = (EditText) findViewById(R.id.cholesterol_mg);
        final EditText editTextTriglyceridesMmol = (EditText) findViewById(R.id.triglycerides_mmol);
        final EditText editTextTriglyceridesDl = (EditText) findViewById(R.id.triglycerides_mg);
        final EditText editTextHemoglobinMmol = (EditText) findViewById(R.id.hemoglobin_mmol);
        final EditText editTextHemoglobinDl = (EditText) findViewById(R.id.hemoglobin_mg);
        final EditText editTextCreatinineMmol = (EditText) findViewById(R.id.creatinine_mmol);
        final EditText editTextCreatinineDl = (EditText) findViewById(R.id.creatinine_mg);
        editTextGlucoseMmol.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextGlucoseMmol, editTextGlucoseDl, 18.0);
                }
                return false;
            }
        });

        editTextGlucoseDl.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextGlucoseDl, editTextGlucoseMmol, 1.0 / 18.0);
                }
                return false;
            }
        });

        editTextCholesterolMmol.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCholesterolMmol, editTextCholesterolDl, 38.5);
                }
                return false;
            }
        });

        editTextCholesterolDl.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCholesterolDl, editTextCholesterolMmol, 1.0 / 38.5);
                }
                return false;
            }
        });

        editTextTriglyceridesMmol.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextTriglyceridesMmol, editTextTriglyceridesDl, 88.5);
                }
                return false;
            }
        });

        editTextTriglyceridesDl.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextTriglyceridesDl, editTextTriglyceridesMmol, 1.0 / 88.5);
                }
                return false;
            }
        });

        editTextHemoglobinMmol.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextHemoglobinMmol, editTextHemoglobinDl, 1.6129);
                }
                return false;
            }
        });

        editTextHemoglobinDl.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextHemoglobinDl, editTextHemoglobinMmol, 0.62);
                }
                return false;
            }
        });

        editTextCreatinineMmol.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCreatinineMmol, editTextCreatinineDl, 88.0);
                }
                return false;
            }
        });

        editTextCreatinineDl.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCreatinineDl, editTextCreatinineMmol, 1.0/88.0);
                }
                return false;
            }
        });

        // Clear button.
        Button btnClick = (Button) findViewById(R.id.btnClear);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextGlucoseMmol.setText("");
                editTextGlucoseDl.setText("");
                editTextCholesterolDl.setText("");
                editTextCholesterolMmol.setText("");
                editTextHemoglobinDl.setText("");
                editTextHemoglobinMmol.setText("");
                editTextTriglyceridesDl.setText("");
                editTextTriglyceridesMmol.setText("");
                editTextCreatinineMmol.setText("");
                editTextCreatinineDl.setText("");
            }
        });

    }
}
