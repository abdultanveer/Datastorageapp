package com.example.datastorageapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public  static  String FILE_NAME = "b17android";
   public static int MODE = Activity.MODE_PRIVATE;
   public  static  String KEY1 = "key1";
    public  static  String KEY2 = "key2";

    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //save data in shared preferences
        savePreferences();
    }

    private void savePreferences() {
        //create a file
        SharedPreferences preferences = getSharedPreferences(FILE_NAME,MODE);
        //open the file
       SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        editor.putString(KEY1,s1);
        editor.putString(KEY2,s2);

        //save the file
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //restoredata into edittexts
        restorePreferences();
    }

    private void restorePreferences() {
        //open the file
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME,MODE);
        //read from the file
        String s1 =  sharedPreferences.getString(KEY1,"");
        String s2 =  sharedPreferences.getString(KEY2,"");

        //put the data into edittexts
        et1.setText(s1);
        et2.setText(s2);
    }
}
