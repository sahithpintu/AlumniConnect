package nnk.com.alumniconnect;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Welcome on 9/30/2016.
 */
public class AlumniDatabase extends SQLiteOpenHelper {

    Context context;
    String qry = "create table Alumni(sq TEXT,name TEXT,idno INTEGER,email TEXT,phone INTEGER,gender TEXT,pass TEXT,linkedurl TEXT,sa TEXT,quali TEXT,yj INTEGER,des TEXT,com TEXT,domain TEXT,yp INTEGER)";
    public AlumniDatabase(Context c)
    {
        super(c,"ALUMNICONNECT",null,1);
        context = c;
    }
    public void onCreate(SQLiteDatabase db) {
        try
        {

            db.execSQL(qry);

            Toast.makeText(context, "Table Created", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Log.e("Table Creation",""+e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
