package nnk.com.alumniconnect;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.Spinner;
import android.widget.TextView;



public class Search extends AppCompatActivity {
    EditText editText16;
    TextView tvs;
    Spinner sp1;
    String str1, values="";
    Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        sp1 = (Spinner)findViewById(R.id.sp1);
        editText16=(EditText)findViewById(R.id.editText16);
        button5=(Button)findViewById(R.id.button5);
        String items2[] = {"Name","Company","Location","Domain"};
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,items2);
        sp1.setAdapter(aa);

    }
    public void search(View v) {

      AlumniDatabase ed=new AlumniDatabase(this);
        SQLiteDatabase db = ed.getWritableDatabase();

        str1 = editText16.getText().toString();

         values = "Detail = ";
        // Select All Query
        String selectQuery = "SELECT  idno,name,email,linkedurl FROM Alumni";


        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst())  {
            do {
                int idsc = cursor.getInt(0);
                String namesc = cursor.getString(1);
                String emailsc= cursor.getString(2);
                String linksc= cursor.getString(3);

                values= values+"\n"+idsc+"\n"+namesc+"\n"+emailsc+"\n"+linksc+"";

            } while (cursor.moveToNext());
        }
        tvs.setText(values);
        	}





    public void display5(View v)
    {
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);
    }

}
