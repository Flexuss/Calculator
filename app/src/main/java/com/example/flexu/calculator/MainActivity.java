package com.example.flexu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eigth;
    private Button btn_nine;
    private Button btn_zero;
    private Button btn_del;
    private Button btn_clean;
    private Button btn_plus;
    private Button btn_minus;
    private Button btn_umnoj;
    private Button btn_delit;
    private Button btn_dot;
    private Button btn_ravno;
    private TextView tv;
    private boolean chek=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_clean= (Button) findViewById(R.id.btn_clean);
        btn_del= (Button) findViewById(R.id.btn_delete);
        btn_delit= (Button) findViewById(R.id.btn_delit);
        btn_nine= (Button) findViewById(R.id.btn_nine);
        btn_eigth= (Button) findViewById(R.id.btn_eigth);
        btn_seven= (Button) findViewById(R.id.btn_seven);
        btn_six= (Button) findViewById(R.id.btn_six);
        btn_five= (Button) findViewById(R.id.btn_five);
        btn_four= (Button) findViewById(R.id.btn_four);
        btn_three= (Button) findViewById(R.id.btn_three);
        btn_two= (Button) findViewById(R.id.btn_two);
        btn_zero= (Button) findViewById(R.id.btn_zero);
        btn_one= (Button) findViewById(R.id.btn_one);
        btn_dot= (Button) findViewById(R.id.btn_dot);
        btn_minus= (Button) findViewById(R.id.btn_minus);
        btn_plus= (Button) findViewById(R.id.btn_plus);
        btn_ravno= (Button) findViewById(R.id.btn_ravno);
        btn_umnoj= (Button) findViewById(R.id.btn_umnoj);
        tv= (TextView) findViewById(R.id.tv);
        btn_clean.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eigth.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_ravno.setOnClickListener(this);
        btn_umnoj.setOnClickListener(this);
        btn_delit.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_dot.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clean: tv.setText(""); chek=false; break;
            case R.id.btn_one: tv.setText(tv.getText()+"1"); break;
            case R.id.btn_two: tv.setText(tv.getText()+"2"); break;
            case R.id.btn_three: tv.setText(tv.getText()+"3"); break;
            case R.id.btn_four: tv.setText(tv.getText()+"4"); break;
            case R.id.btn_five: tv.setText(tv.getText()+"5"); break;
            case R.id.btn_six: tv.setText(tv.getText()+"6"); break;
            case R.id.btn_seven: tv.setText(tv.getText()+"7"); break;
            case R.id.btn_eigth: tv.setText(tv.getText()+"8"); break;
            case R.id.btn_nine: tv.setText(tv.getText()+"9"); break;
            case R.id.btn_zero: tv.setText(tv.getText()+"0"); break;
            case R.id.btn_delete:
                Pattern pattern= Pattern.compile("^.*[+-/*]$");
                Matcher matcher=pattern.matcher(tv.getText());
                if(matcher.matches()){
                    chek=false;
                }
                if(tv.length()>0){
                    tv.setText(tv.getText().subSequence(0,tv.length()-1));
                } break;
            case R.id.btn_plus:  if(!chek){
                chek=true;
                tv.setText(tv.getText()+"+");
            } else {
                calculating(tv.getText(),"+");
            } break;
            case R.id.btn_minus: if(!chek){
                chek=true;
                tv.setText(tv.getText()+"-");
            } else {
                calculating(tv.getText(),"-");
            } break;
            case R.id.btn_umnoj:  if(!chek){
                chek=true;
                tv.setText(tv.getText()+"*");
            } else {
                calculating(tv.getText(),"*");
            } break;
            case R.id.btn_delit:  if(!chek){
                chek=true;
                tv.setText(tv.getText()+"/");
            } else {
                calculating(tv.getText(),"/");
            } break;
            case R.id.btn_ravno:  if(!chek){
                tv.setText(tv.getText());
            } else {
                calculating(tv.getText(),"=");
                chek=false;
            } break;
            case R.id.btn_dot:
                Pattern pattern1= Pattern.compile("()|(//d[*/+-])");
                Matcher matcher1=pattern1.matcher(tv.getText());
                if(matcher1.matches()){
                    tv.setText(tv.getText()+"0.");
                }else
                tv.setText(tv.getText()+"."); break;
        }
    }
    private void calculating(CharSequence a,String b){
        String string=a.toString();
        if(string.contains("+")){
            int pos=string.indexOf("+");
            double x1=0;
            if(pos!=0) {
                x1 = Double.parseDouble(string.substring(0, pos));
            }
            double x2=0;
            if((pos+1)!=string.length()) {
                x2 = Double.parseDouble(string.substring(pos + 1, string.length()));
            }
            Double answer=x1+x2;
            tv.setText(answer.toString());
            if(b!="="){
                tv.setText(tv.getText()+b);
            }
        }
        if(string.contains("-")){
            int pos=string.indexOf("-");
            double x1=0;
            if(pos!=0) {
                x1 = Double.parseDouble(string.substring(0, pos));
            }
            double x2=0;
            if((pos+1)!=string.length()) {
                x2 = Double.parseDouble(string.substring(pos + 1, string.length()));
            }
            Double answer=x1-x2;
            tv.setText(answer.toString());
            if(b!="="){
                tv.setText(tv.getText()+b);
            }
        }if(string.contains("*")){
            int pos=string.indexOf("*");
            double x1=0;
            if(pos!=0) {
                x1 = Double.parseDouble(string.substring(0, pos));
            }
            double x2=0;
            if((pos+1)!=string.length()) {
                x2 = Double.parseDouble(string.substring(pos + 1, string.length()));
            }
            Double answer=x1*x2;
            tv.setText(answer.toString());
            if(b!="="){
                tv.setText(tv.getText()+b);
            }
        }if(string.contains("/")){
            int pos=string.indexOf("/");
            double x1=0;
            if(pos!=0) {
                x1 = Double.parseDouble(string.substring(0, pos));
            }
            double x2=0;
            if((pos+1)!=string.length()) {
                x2 = Double.parseDouble(string.substring(pos + 1, string.length()));
            }
            Double answer = 0.0;
            if(x2!=0) {
                answer = x1 / x2;
                tv.setText(answer.toString());
                if(b!="="){
                    tv.setText(tv.getText()+b);
                }
            }else {
                tv.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "Деление на ноль!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
