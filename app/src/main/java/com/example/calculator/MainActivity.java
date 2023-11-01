package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import com.example.calculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private  double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,
            btn_add,btn_sub,btn_equal,btn_mul,btn_divide,btn_allclear,btn_back,
            btn_percent,btn_clear,btn_dot;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.#######");
        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_add = findViewById(R.id.btn_plus);
        btn_sub = findViewById(R.id.btn_minus);
        btn_mul = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_devide);
        btn_percent = findViewById(R.id.btn_persent);
        btn_clear = findViewById(R.id.btn_AllClr);
        btn_allclear = findViewById(R.id.btn_AC);
        btn_back = findViewById(R.id.btn_delete);
        btn_equal = findViewById(R.id.btn_equal);
        btn_dot = findViewById(R.id.btn_dot);

        btn_0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+"9");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputDisplay.setText(inputDisplay.getText()+".");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculation();
                currentSymbol = ADDITION;
                outputDisplay.setText(decimalFormat.format(firstValue)+"+");
                inputDisplay.setText(null);
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculation();
                currentSymbol = SUBSTRACTION;
                outputDisplay.setText(decimalFormat.format(firstValue)+"-");
                inputDisplay.setText(null);
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculation();
                currentSymbol = MULTIPLICATION;
                outputDisplay.setText(decimalFormat.format(firstValue)+"*");
                inputDisplay.setText(null);
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculation();
                currentSymbol = DIVISION;
                outputDisplay.setText(decimalFormat.format(firstValue)+"/");
                inputDisplay.setText(null);
            }
        });
        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculation();
                currentSymbol = PERCENT;
                outputDisplay.setText(decimalFormat.format(firstValue)+"%");
                inputDisplay.setText(null);
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                allCalculation();
                outputDisplay.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputDisplay.getText().length()>0){
                    CharSequence currentText = inputDisplay.getText();
                    inputDisplay.setText(currentText.subSequence(0,currentText.length()-1));
                }
                else{
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputDisplay.setText("");
                    outputDisplay.setText("");
                }
            }
        });
        btn_allclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
    private void allCalculation(){
        if(!Double.isNaN(firstValue)){
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);
            try {
                if (currentSymbol == ADDITION)
                    firstValue = this.firstValue + secondValue;
                else if (currentSymbol == SUBSTRACTION)
                    firstValue = this.firstValue - secondValue;
                else if (currentSymbol == MULTIPLICATION)
                    firstValue = this.firstValue * secondValue;
                else if (currentSymbol == DIVISION)
                    firstValue = this.firstValue / secondValue;
                else if (currentSymbol == PERCENT)
                    firstValue = this.firstValue % secondValue;
            }catch (ArithmeticException e){

                outputDisplay.setText("Error");
            }
        }
        else{
            try{
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            }catch (Exception e){

            }
        }
    }
}