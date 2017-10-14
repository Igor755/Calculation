package com.sonikpalms.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    final int menu_reset = 1;
    final int menu_quit = 2;


    Button but1;
    Button but2;
    Button but3;
    Button but4;

    EditText edit1;
    EditText edit2;

    TextView result1;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but3 = (Button) findViewById(R.id.but3);
        but4 = (Button) findViewById(R.id.but4);

        edit1 = (EditText) findViewById(R.id.editText1);
        edit2 = (EditText) findViewById(R.id.editText2);
        result1 = (TextView) findViewById(R.id.result);


        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if (TextUtils.isEmpty(edit1.getText().toString())
                || (TextUtils.isEmpty(edit2.getText().toString()))) {

            return;
        }
        num1 = Float.parseFloat(edit1.getText().toString());
        num2 = Float.parseFloat(edit2.getText().toString());

        switch (view.getId()) {
            case R.id.but1:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.but2:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.but3:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.but4:
                oper = "/";
                if (num2 == 0){
                    Toast toast = Toast.makeText(getApplicationContext(),"Dont delete on ZERO",Toast.LENGTH_SHORT);
                    toast.show();
                }else if (num2 > 0 ) {
                    result = num1 / num2;
                }
                break;
            default:
                break;
        }

        if((oper == "/")||(num2 == 0)){
            result1.setText("0");

        }else
            result1.setText(num1 + " " + oper + " " + num2 + "=" + result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,menu_reset,0,"Reset");
        menu.add(0,menu_quit,0,"Quit");


        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case menu_reset:
                edit1.setText("");
                edit2.setText("");
                result1.setText("");
                break;
            case  menu_quit:
                finish();
                break;

        }


        return super.onOptionsItemSelected(item);
    }

}
