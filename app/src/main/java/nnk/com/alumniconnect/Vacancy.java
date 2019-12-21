package nnk.com.alumniconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Vacancy extends Activity {

    Vdb dataBase1;
    EditText fullname1;
    TextView textViewv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancy);
        fullname1 = (EditText)findViewById(R.id.fullName1);
        textViewv = (TextView)findViewById(R.id.textViewv);
        dataBase1 = new Vdb(this);

    }
    public void save2(View view)
    {


        String full_name1 = fullname1.getText().toString();



        long id = dataBase1.dataInsert1(full_name1);


        if
                (id<0)
        {


            Toast.makeText(this, "Error ! not inserted", Toast.LENGTH_LONG).show();


        }
        else
        {


            Toast.makeText(this,"Successfully inserted",Toast.LENGTH_LONG).show();
            fullname1.setText(" ");

        }


    }
    public void dataView1(View view)
    {


        String data = dataBase1.viewData1();

        textViewv.setMovementMethod(new ScrollingMovementMethod());

        textViewv.setText(data);




    }
    public void displayvacancy(View v)
    {
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);
    }
}
