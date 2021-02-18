package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ajout extends AppCompatActivity {

    EditText ednumero,ednom, edprenom;
    private Button btnval;
    private Button btnqte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        ednumero=findViewById(R.id.edpw_ajout);
        ednom=findViewById(R.id.ednom_ajout);
        edprenom=findViewById(R.id.edprenom_ajout);
        btnval=findViewById(R.id.btval_ajout);
        btnqte=findViewById(R.id.btqte_ajout);
        //couteur d'action
        btnqte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ajout.this.finish();
                //ou bien directement finish();
            }
        });
        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=ednom.getText().toString();
                String num=ednumero.getText().toString()    ;
                String p=edprenom.getText().toString();
                Contact c=new Contact(n,num,p);
                Accueil.data.add(c);
                Ajout.this.finish();

            }
        });

    }
}