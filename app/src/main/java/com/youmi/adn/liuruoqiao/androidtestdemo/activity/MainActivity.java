package com.youmi.adn.liuruoqiao.androidtestdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.youmi.adn.liuruoqiao.androidtestdemo.R;
import com.youmi.adn.liuruoqiao.androidtestdemo.utils.Calculator;
import com.youmi.adn.liuruoqiao.androidtestdemo.utils.HttpRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button tran;
    private TextView result;
    private TextView tran_result;
    private EditText num1;
    private EditText num2;
    private EditText num3;
    private static final String TAG="MainActivity";
    private Calculator mCalculator;
    private HttpRequest mHttpRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        tran.setOnClickListener(this);
    }

    private void init() {
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.subtract);
        mul=(Button)findViewById(R.id.multiply);
        div=(Button)findViewById(R.id.divide);
        tran=(Button)findViewById(R.id.tran);
        result=(TextView)findViewById(R.id.result);
        tran_result=(TextView)findViewById(R.id.tran_result);
        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        num3=(EditText)findViewById(R.id.num3);
        mCalculator = new Calculator();
        mHttpRequest=new HttpRequest();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add:
                result.setText(String.format(getResources().getString(R.string.result_text),mCalculator.add(Double.parseDouble(num1.getText().toString()),Double.parseDouble(num2.getText().toString()))));
                break;
            case R.id.subtract:
                result.setText(String.format(getResources().getString(R.string.result_text),mCalculator.sub(Double.parseDouble(num1.getText().toString()),Double.parseDouble(num2.getText().toString()))));
                break;
            case R.id.multiply:
                result.setText(String.format(getResources().getString(R.string.result_text),mCalculator.mul(Double.parseDouble(num1.getText().toString()),Double.parseDouble(num2.getText().toString()))));
                break;
            case R.id.divide:
                result.setText(String.format(getResources().getString(R.string.result_text),mCalculator.div(Double.parseDouble(num1.getText().toString()),Double.parseDouble(num2.getText().toString()))));
                break;
            case R.id.tran:
                tran_result.setText(String.format(getResources().getString(R.string.tranresult_text),mCalculator.tran(Double.parseDouble(num3.getText().toString()),mHttpRequest.getExchangeRate())));
                break;
            default:
                Log.i(TAG,"default output");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
