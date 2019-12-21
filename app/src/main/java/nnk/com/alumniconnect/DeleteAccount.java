package nnk.com.alumniconnect;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DeleteAccount extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);
    }
    public void delete(View v)
    {
        AlumniDatabase ed = new AlumniDatabase(this);
        SQLiteDatabase db = ed.getWritableDatabase();

        db.delete("Alumni", "idno", null);
        Toast.makeText(this, "Account deleted", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);


    }
    public void display9(View v)
    {
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);
    }
}
