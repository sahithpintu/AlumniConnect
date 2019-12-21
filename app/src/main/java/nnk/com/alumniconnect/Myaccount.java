package nnk.com.alumniconnect;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Myaccount extends Activity {

    int idno,phone,yp;
    String name,pass,email,quali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
        Intent i1 = getIntent();
        Bundle b = i1.getExtras();
        idno = b.getInt("k1");
        pass = b.getString("k2");



    }
    public void viewEmployee(View v)
    {
        String message = "USER-ID = "+idno+"\n\nPASSWORD = "+pass+"\n\nQUALIFICATION = BTECH\n\nCOLLEGE = VNRVJIET";
        AlertDialog ad = new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.stat_notify_voicemail)
                .setTitle("ALUMNI VNRVJIET " +idno)
                .setMessage(message)
                .setIcon(R.drawable.gd)
                .setCancelable(false)
                .setNeutralButton("Close", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })

                .create();
        ad.show();

    }

    public void display7(View v)
    {
        Intent i=new Intent(this,Registerpage.class);
        startActivity(i);
        finish();
    }
    public void display8(View v)
    {
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);

    }
    public void update(View v)
    {
        AlumniDatabase ed = new AlumniDatabase(this);
        SQLiteDatabase db = ed.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("des","pgstudent");
        db.update("Alumni", cv, "idno="+idno, null);

        Toast.makeText(this," Updated To PG Student",Toast.LENGTH_SHORT).show();
    }

}
