package com.example.myfirstproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Affichage extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {

    private EditText edrech;
    public static ListView lv_affiche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Affichage.this.setContentView(R.layout.activity_affichage);

        edrech=Affichage.this.findViewById(R.id.edrech_affihe);
       /**********--compts rendu--**************/
       edrech.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });


        lv_affiche=Affichage.this.findViewById(R.id.lv_affiche);

       MonAdapter adapter=new MonAdapter(Affichage.this,Accueil.data);

        lv_affiche.setAdapter(adapter);
        lv_affiche.setOnItemClickListener(this);
        /*ArrayAdapter adapter=new ArrayAdapter(Affichage.this,android.R.layout.simple_list_item_1,
                Accueil.data);
                lv_affiche.setOnItemClickListener(this);
                lv_affiche.setAdapter(adapter);
       */
    }
    int pos;
    @Override
    public void onItemClick(AdapterView<?> lv_affiche, View view, int i, long l) {

        AlertDialog.Builder alert=new AlertDialog.Builder(Affichage.this);
        pos=i;
        alert.setTitle("Action!");
        alert.setMessage("Choisir une action");
        alert.setPositiveButton("supprimer",this);
        alert.setNegativeButton("Modifier",this);
        alert.setNeutralButton("Supprimer tous",this);

        alert.show();
    }



    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if(which==dialogInterface.BUTTON_POSITIVE){
            Accueil.data.remove(pos);
            lv_affiche.invalidateViews();
        }
        if(which==dialogInterface.BUTTON_NEGATIVE){

            Intent i=new Intent(Affichage.this,Edit.class);
             Contact item = (Contact) lv_affiche.getItemAtPosition(pos);

             i.putExtra("info",item);
             i.putExtra("position",pos);
             Log.d("donne ",item.toString());
             startActivity(i);

        }
        if(which==dialogInterface.BUTTON_NEUTRAL){
            Accueil.data.clear();
            lv_affiche.invalidateViews();
        }


    }
}