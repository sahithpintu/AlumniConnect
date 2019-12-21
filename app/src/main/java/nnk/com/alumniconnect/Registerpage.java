package nnk.com.alumniconnect;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registerpage extends Activity {


    EditText editText3,editText4,editText5,editText6,editText7,editText8,editText9,editText10,editText11,editText12,editText13,editText18,editText19,editText20,editText21;
String name,email,linkedurl,quali;
    int idno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4= (EditText)findViewById(R.id.editText4);
        editText5= (EditText)findViewById(R.id.editText5);
        editText6= (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        editText8= (EditText)findViewById(R.id.editText8);
        editText9= (EditText)findViewById(R.id.editText9);
        editText10= (EditText)findViewById(R.id.editText10);
        editText11 = (EditText)findViewById(R.id.editText11);
        editText12= (EditText)findViewById(R.id.editText12);
        editText13= (EditText)findViewById(R.id.editText13);
        editText18= (EditText)findViewById(R.id.editText18);
        editText19= (EditText)findViewById(R.id.editText19);
        editText20= (EditText)findViewById(R.id.editText20);
        editText21= (EditText)findViewById(R.id.editText21);

    }

    public void register(View v)
    {
        String sq = editText20.getText().toString().trim();
         name = editText3.getText().toString().trim();
          idno = Integer.parseInt(editText4.getText().toString().trim());
         email = editText5.getText().toString().trim();
        int phone = Integer.parseInt(editText6.getText().toString().trim());
        String gender = editText7.getText().toString().trim();
        String pass = editText8.getText().toString().trim();
         linkedurl = editText9.getText().toString().trim();
        String sa = editText21.getText().toString().trim();
         quali = editText19.getText().toString().trim();
        int yj = Integer.parseInt(editText10.getText().toString().trim());
        String des = editText18.getText().toString().trim();
        String com = editText11.getText().toString().trim();
        String domain = editText12.getText().toString().trim();
        int yp = Integer.parseInt(editText13.getText().toString().trim());
        AlumniDatabase ed = new AlumniDatabase(this);
        try
        {
            SQLiteDatabase db = ed.getWritableDatabase();
            String qry = "insert into Alumni values('"+sq+"','"+name+"',"+idno+",'"+email+"',"+phone+",'"+gender+"','"+pass+"','"+linkedurl+"','"+sa+"','"+quali+"',"+yj+",'"+des+"','"+com+"','"+domain+"',"+yp+")";
            db.execSQL(qry);
            Toast.makeText(Registerpage.this, "Alumni Data Inserted", Toast.LENGTH_SHORT).show();
            editText20.setText("");
            editText3.setText("");
            editText4.setText("");
            editText5.setText("");
            editText6.setText("");
            editText7.setText("");
            editText8.setText("");
            editText9.setText("");
            editText21.setText("");
            editText19.setText("");
            editText10.setText("");
            editText18.setText("");
            editText11.setText("");
            editText12.setText("");
            editText13.setText("");

        }catch (Exception e)
        {
            Log.e("Data Insertion", "" + e);
        }

    }
    public void moveBack(View v)
    {
        finish();
        Intent i = new Intent(this,Loginpage.class);
        startActivity(i);
    }

}
