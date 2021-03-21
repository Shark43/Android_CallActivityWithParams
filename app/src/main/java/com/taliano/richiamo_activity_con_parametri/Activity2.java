package com.taliano.richiamo_activity_con_parametri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = this.getIntent();
        if (intent == null){
            alert("Errore apertura activity: parametri mancanti");
            this.finish();
        } else {
            if(intent.hasExtra("par1")){
                TextView txt = findViewById(R.id.textView);
                txt.setText(intent.getStringExtra("par1"));
            }
            if(intent.hasExtra("par2")){
                TextView txt = findViewById(R.id.textView2);
                txt.setText(Integer.toString(intent.getIntExtra("par2", 0)));
            }
            if(intent.hasExtra("par3")){
                TextView txt = findViewById(R.id.textView3);
                txt.setText(Float.toString(intent.getFloatExtra("par3", 0f)));
            }
            if(intent.hasExtra("par4")){
                TextView txt = findViewById(R.id.textView4);
                txt.setText(Arrays.toString(intent.getIntArrayExtra("par4")));
            }
        }

        Button button = findViewById(R.id.buttonOpen2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent();
                intentBack.putExtra("par5", "Questa è la risposta del Activity 2");
                Activity2.this.setResult(RESULT_OK, intentBack);
                Activity2.this.finish();
            }
        });
    }

    private void alert(String s) {
        Toast t = Toast.makeText(Activity2.this, s, Toast.LENGTH_SHORT);
        t.show();
    }
}
