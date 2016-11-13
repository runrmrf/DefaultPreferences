package com.mancng.defaultpreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String chosenLanguage;

    public void showAlert() {

        final SharedPreferences sharedPreferences = this.getSharedPreferences("com.mancng.defaultpreferences", Context.MODE_PRIVATE);

            new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Set Default Language")
                .setMessage("Please select a language")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Log.i("Button Tapped", "English");
                        sharedPreferences.edit().putString("Language", "English").apply();
                        Toast.makeText(getApplicationContext(), "Chosen Language: English", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Log.i("Button Tapped", "Spanish");
                        sharedPreferences.edit().putString("Language", "Spanish").apply();
                        Toast.makeText(getApplicationContext(), "Chosen Language: Spanish", Toast.LENGTH_SHORT).show();

                    }
                })
                .show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SharedPreferences sharedPreferences = this.getSharedPreferences("com.mancng.defaultpreferences", Context.MODE_PRIVATE);

        chosenLanguage = sharedPreferences.getString("Language", "");

        if (chosenLanguage == "") {

            showAlert();

        } else {

            Toast.makeText(getApplicationContext(), "Chosen Language: " + chosenLanguage, Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.changeLanguage) {

            showAlert();

            return true;

        }

        return super.onOptionsItemSelected(item);

    }

}
