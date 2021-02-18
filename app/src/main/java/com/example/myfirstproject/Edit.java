package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Edit extends AppCompatActivity {

    EditText ednumero,ednom, edprenom;
    TextView edtest;

    private Button btnval;
    private Button btnqte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ednumero=findViewById(R.id.edpw_edit);
        ednom=findViewById(R.id.ednom_edit);
        edprenom=findViewById(R.id.edprenom_edit);

        Intent x=this.getIntent();
        Contact contact = (Contact) x.getSerializableExtra("info");
        Bundle b=x.getExtras();
        final int indice=b.getInt("position");
        /*Modifier donner*/
        ednom.setText(contact.getNom());
        edprenom.setText(contact.getPrenom());
        ednumero.setText(contact.getNum());
        btnval=findViewById(R.id.btval_edit);
        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=ednom.getText().toString();
                String num=ednumero.getText().toString();
                String p=edprenom.getText().toString();
                Contact c=new Contact(n,p,num);
                Accueil.data.set(indice,c);

               Affichage.lv_affiche.invalidateViews();
                Edit.this.finish();
               /* Intent i=new Intent(Edit.this,Affichage.class);
                startActivity(i);*/


            }
        });
        btnqte=findViewById(R.id.btqte_edit);
        btnqte.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Edit.this.finish();
            }
        });
    }

}