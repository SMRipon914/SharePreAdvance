package com.example.sp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1,textView2;
    EditText editText1,editText2;
    String value1,value2;
    Button save,load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharePre.init(this);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        editText1=findViewById(R.id.name);
        editText2=findViewById(R.id.pass);
        save=findViewById(R.id.save);
        load=findViewById(R.id.load);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.save){
            SharePre.Write("name",editText1.getText().toString());
            SharePre.Write("pass",editText2.getText().toString());
            Toast.makeText(getApplicationContext(),"data is saved",Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.load){

          String v1=SharePre.Read("name","");
          String v2= SharePre.Read("pass","");
           if (v1.equals(editText1.getText().toString()) && v2.equals(editText2.getText().toString())){
               Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
           }else {
              editText1.setError("Invlied nane or password");
              editText2.setError("Invlied nane or password");
              editText1.requestFocus();
              editText2.requestFocus();

           }
        }


    }
}
