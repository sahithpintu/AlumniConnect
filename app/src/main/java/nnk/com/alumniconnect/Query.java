package nnk.com.alumniconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Query extends AppCompatActivity {

    Qdb dataBase;
    EditText fullname;
    TextView textView28;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        fullname = (EditText)findViewById(R.id.fullName);
        textView28 = (TextView)findViewById(R.id.textView28);
        dataBase = new Qdb(this);


    }
    public void save1(View view)
    {


        String full_name = fullname.getText().toString();



        long id = dataBase.dataInsert(full_name);


        if
                (id<0)
        {


            Toast.makeText(this, "Error ! not inserted", Toast.LENGTH_LONG).show();


        }
        else
        {


            Toast.makeText(this,"Successfully inserted",Toast.LENGTH_LONG).show();

        }


    }
    public void dataView(View view)
    {


        String data = dataBase.viewData();

        textView28.setMovementMethod(new ScrollingMovementMethod());
        textView28.setText(data);



    }
    public void display6(View v)
    {
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);
    }
}
