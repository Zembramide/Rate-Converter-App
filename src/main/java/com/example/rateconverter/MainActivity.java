package com.example.rateconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private EditText mymoney;
    private EditText myquantity;
    private Button cnfm;
    private Button rupee;
    private Button quantity;
    private Button ans;
    private Button ans2;
    private Button clear_all;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.rate1);
        num2 = (EditText)findViewById(R.id.rate2);
        mymoney = (EditText)findViewById(R.id.your_money);
        myquantity = (EditText)findViewById(R.id.your_quantity);
        cnfm = (Button)findViewById(R.id.confirm);
        rupee = (Button)findViewById(R.id.button1);
        quantity = (Button)findViewById(R.id.button2);
        ans = (Button)findViewById(R.id.finalbutton);
        ans2 = (Button)findViewById(R.id.button);
        clear_all = (Button)findViewById(R.id.clear_button);
        result = (TextView)findViewById(R.id.answer);

        cnfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num1.length()==0){
                    num1.setError("Enter Valid Input");
                }
                else if (num2.length()==0){
                    num2.setError("Enter Valid Input");
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Rate Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rupee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mymoney.setVisibility(View.VISIBLE);
                myquantity.setVisibility(View.INVISIBLE);
                ans2.setVisibility(View.INVISIBLE);
                ans.setVisibility(View.VISIBLE);
            }
        });

        quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myquantity.setVisibility(View.VISIBLE);
                mymoney.setVisibility(View.INVISIBLE);
                ans.setVisibility(View.INVISIBLE);
                ans2.setVisibility(View.VISIBLE);
            }
        });

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mymoney.getText().toString().equals("0")) {
                    mymoney.setError("Enter Valid Input");
                }
                else if (mymoney.length()==0){
                    mymoney.setError("Enter Valid Input");
                }
                else{
                    double numb1 = Double.parseDouble(num1.getText().toString());
                    double numb2 = Double.parseDouble(num2.getText().toString());
                    double numb3 = Double.parseDouble(mymoney.getText().toString());
                    double sum = (numb2*numb3)/numb1;
                    result.setText(String.format("%.2f", sum));
                }

            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myquantity.getText().toString().equals("0")) {
                    myquantity.setError("Enter Valid Input");
                }
                else if (myquantity.length()==0){
                    myquantity.setError("Enter Valid Input");
                }
                else {
                    double numb1 = Double.parseDouble(num1.getText().toString());
                    double numb2 = Double.parseDouble(num2.getText().toString());
                    double numb3 = Double.parseDouble(myquantity.getText().toString());
                    double sum = (numb1*numb3)/numb2;
                    result.setText(String.format("%.2f", sum));
                }

            }
        });

        clear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.getText().clear();
                num2.getText().clear();
                mymoney.getText().clear();
                myquantity.getText().clear();
                result.setText("Answer");
            }
        });


    }
}