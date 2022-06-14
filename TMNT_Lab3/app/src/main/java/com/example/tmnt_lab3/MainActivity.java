package com.example.tmnt_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String Id_name=preferences.getString("turtle_id", "");
        int id=0;
        if(!Id_name.equalsIgnoreCase(""))
        {
            id=Integer.parseInt(Id_name);

        }
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner) findViewById(R.id.tmnt);
        if(id!=0){
            spin.setSelection(id);}
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> spin, View v, int i, long id) {
                TextView result = (TextView) findViewById(R.id.turtle_result);
                result.setText("You chose " + spin.getSelectedItem());
                ImageView img = (ImageView) findViewById(R.id.turtle);
                if (id == 0) {
                    img.setImageResource(R.drawable.tmntleo);
                    img.setTag("0");
                } else if (id == 1) {
                    img.setImageResource(R.drawable.tmntmike);
                    img.setTag("1");
                } else if (id == 2) {
                    img.setImageResource(R.drawable.tmntdon);
                    img.setTag("2");
                } else {
                    img.setImageResource(R.drawable.tmntraph);
                    img.setTag("3");
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void Click_Image(View view) {
        ImageView img = (ImageView) findViewById(R.id.turtle);
        String imageid = (String) img.getTag();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("turtle_id", ((String.valueOf(imageid))));
        startActivity(intent);

    }

    @Override
    protected void onStop() {
        ImageView img = (ImageView) findViewById(R.id.turtle);
        String imageid = (String) img.getTag();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("turtle_id",String.valueOf(imageid));
        editor.apply();
        super.onStop();
    }
    @Override
    protected void onPause() {
        ImageView img = (ImageView) findViewById(R.id.turtle);
        String imageid = (String) img.getTag();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("turtle_id",String.valueOf(imageid));
        editor.apply();
        super.onPause();
    }
}