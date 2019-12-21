package nnk.com.alumniconnect;

/**
 * Created by Welcome on 10/29/2016.
 */
import android.content.ContentValues;

import android.content.Context;

import android.database.Cursor;

import android.database.SQLException;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import android.widget.Toast;


import java.util.jar.Attributes;


/**
 * Created by muhammed on 11/20/15.
 */


public class Qdb
{

    DBinfo  dBinfo;

    public Qdb(Context context)

    {


        dBinfo = new DBinfo(context);

    }
    public long dataInsert(String fullname)
    {


        SQLiteDatabase sqLiteDatabase = dBinfo.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBinfo.names,fullname);



        long id = sqLiteDatabase.insert(DBinfo.tableName,null,contentValues);

        return id;

    }


    public String viewData()
    {

        SQLiteDatabase sqLiteDatabase = dBinfo.getWritableDatabase();


        String [] columns = {DBinfo.UID,DBinfo.names};


        Cursor cursor = sqLiteDatabase.query(DBinfo.tableName,columns,null,null,null,null,null);


        StringBuffer stringBuffer= new StringBuffer();

        while (cursor.moveToNext())

        {


            int uid = cursor.getInt(0);
            String namee = cursor.getString(1);




            stringBuffer.append(uid +". "+namee+"\n");

        }

        return stringBuffer.toString();

    }







    static class DBinfo extends SQLiteOpenHelper
    {



        private static final String dataBase_Name = "querydb";

        private static final String tableName = "QUERY";

        private static final int dataBase_Version = 6;

        private static final String UID = "id";

        private static final String names = "Name";



        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+tableName;

        private static final String CREATE_TABLE = "CREATE TABLE "+tableName+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+names+" VARCHAR(255));";

        private Context context;



        public DBinfo(Context context)
        {

            super(context, dataBase_Name, null, dataBase_Version);

            this.context = context;

            Toast.makeText(context,"this Constructor",Toast.LENGTH_LONG).show();

        }


        @Override

        public void onCreate(SQLiteDatabase db)
        {


            try
            {

                db.execSQL(CREATE_TABLE);

                Toast.makeText(context,"onCreate Method",Toast.LENGTH_LONG).show();

            }
            catch (SQLException e)
            {

                Toast.makeText(context,"due to: "+e,Toast.LENGTH_LONG).show();

            }



        }


        @Override

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {



            try
            {

                Toast.makeText(context,"onUpgrade Method",Toast.LENGTH_LONG).show();

                db.execSQL(DROP_TABLE);

                onCreate(db);

            }
            catch (SQLException e)
            {
                Toast.makeText(context,"due to: "+e,Toast.LENGTH_LONG).show();

            }



        }

    }








}
