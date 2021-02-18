package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //déclaration des composant;
    EditText edmp,ednom;
    private Button btnval;
    private Button btnqte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Récupération des composant

        edmp=findViewById(R.id.edmp_auth);
        ednom=findViewById(R.id.ednom_auth);
        btnval=findViewById(R.id.btnval_auth);
        btnqte=findViewById(R.id.btnqte_auth);
    //couteur d'action
        btnqte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
                //ou bien directement finish();
            }
        });
        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=ednom.getText().toString();
                String mp=edmp.getText().toString()    ;
            if(nom.equalsIgnoreCase("boutheina")&& mp.equals(("000")))
            {
                Intent i=new Intent(MainActivity.this,Accueil.class);
                i.putExtra("USER",nom);
                startActivity(i);

            }else {
                Toast.makeText(MainActivity.this, "valeur non valide", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}