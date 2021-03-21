package com.taliano.richiamo_activity_con_parametri;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int CODICE_RICHIESTA = 330;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonOpen2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("par1", "Salve a tutti");
                intent.putExtra("par2", 13);
                intent.putExtra("par3", 1.3f);
                intent.putExtra("par4", new int[] { 1, 2, 3, 4, 5 });
                startActivityForResult(intent, CODICE_RICHIESTA);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode){
            case CODICE_RICHIESTA:
                if(resultCode == RESULT_OK && intent != null && intent.hasExtra("par5")){
                    alert(intent.getStringExtra("par5"));
                }
                break;
        }
    }

    private void alert(String s) {
        Toast t = Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT);
        t.show();
    }
}
