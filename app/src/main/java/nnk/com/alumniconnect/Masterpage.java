package nnk.com.alumniconnect;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Masterpage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterpage);
    }
    public void display(View v)
    {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        Uri u = Uri.parse("http://www.vnrvjiet.ac.in");
        i.setData(u);
        startActivity(i);
    }
    public void display1(View v)
    {
      Intent i=new Intent(this,Loginpage.class);
        startActivity(i);
    }
}
