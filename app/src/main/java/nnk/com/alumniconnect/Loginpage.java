package nnk.com.alumniconnect;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage extends Activity {

    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
    }
    public void display2(View v)
    {
        Intent i=new Intent(this,Registerpage.class);
        startActivity(i);
    }
    public void display3(View v)
    {
        Intent i=new Intent(this,ForgotpassActivity.class);
        startActivity(i);
    }
    public void display4(View v)
    {
        int idno = Integer.parseInt(et1.getText().toString().trim());
        String pass = et2.getText().toString().trim();

        try
        {
            AlumniDatabase ed = new AlumniDatabase(this);
            SQLiteDatabase db = ed.getWritableDatabase();
            String qry = "select pass from Alumni where idno = "+idno+"";

            Cursor c = db.rawQuery(qry,null);
            c.moveToFirst();
            String password=c.getString(0);
            if (password.equals(pass))
            {
                    Toast.makeText(this,"Valid User",Toast.LENGTH_SHORT).show();



                Intent i = new Intent(this,Myaccount.class);
                i.putExtra("k1",idno);
                i.putExtra("k2",pass);
                startActivity(i);




            }
            else
            {
                Toast.makeText(Loginpage.this, "Invalid User", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            Log.e("Exception ", "" + e);
        }


    }
}
