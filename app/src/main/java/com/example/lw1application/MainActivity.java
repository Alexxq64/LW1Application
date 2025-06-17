package com.example.lw1application;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnConvert;
    private EditText editDecNumber;
    private EditText editBinNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvert = findViewById(R.id.btnConvert);
        editDecNumber = findViewById(R.id.editTextDecimal);
        editBinNumber = findViewById(R.id.editTextBinary);

        btnConvert.setOnClickListener(v -> convertNumbers());
    }

    private void convertNumbers() {
        if (editDecNumber.hasFocus()) {
            convertDecimalToBinary();
        } else if (editBinNumber.hasFocus()) {
            convertBinaryToDecimal();
        }
    }

    private void convertDecimalToBinary() {
        String decStr = editDecNumber.getText().toString().trim();
        if (!decStr.isEmpty()) {
            try {
                int decimal = Integer.parseInt(decStr);
                String binary = Integer.toBinaryString(decimal);
                editBinNumber.setText(binary);
            } catch (NumberFormatException e) {
                editBinNumber.setText("Ошибка");
            }
        } else {
            editBinNumber.setText("");
        }
    }

    private void convertBinaryToDecimal() {
        String binStr = editBinNumber.getText().toString().trim();
        if (!binStr.isEmpty()) {
            try {
                int decimal = Integer.parseInt(binStr, 2);
                editDecNumber.setText(String.valueOf(decimal));
            } catch (NumberFormatException e) {
                editDecNumber.setText("Ошибка");
            }
        } else {
            editDecNumber.setText("");
        }
    }
}