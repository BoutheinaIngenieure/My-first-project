package com.example.myfirstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Accueil extends AppCompatActivity {
    static ArrayList<Contact> data=new ArrayList<Contact>();
    private TextView tvusername;
    private Button btnajout;
    private Button btnaffiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        tvusername=findViewById(R.id.tvuser_acc);
        btnajout=findViewById(R.id.btajout_acc);
        btnaffiche=findViewById(R.id.btnaff_acc);
        Intent x=this.getIntent();
        Bundle b=x.getExtras();
        String  u=b.getString("USER");
        tvusername.setText("Accueil de \n Mlle."+u);

        btnaffiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Accueil.this,Affichage.class);
                startActivity(i);
            }
        });

        btnajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Accueil.this,Ajout.class);
                startActivity(i);
            }

        });
    }
 boolean permission_write=false;
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();

        if(ContextCompat.checkSelfPermission(Accueil.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED) {
            permission_write = true;

        } else{
            permission_write=false;
            ActivityCompat.requestPermissions(Accueil.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }
        //import des fichier
        String dir= Environment.getExternalStorageDirectory().getPath();
        File f=new File(dir, "fichier.txt");
        if(f.exists()){
            try {
                data.clear();
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                String ligne=null;
                while ((ligne=br.readLine())!=null) {

                    String[] t = ligne.split("#");
                    Contact c = new Contact(t[0], t[1], t[2]);
                    data.add(c);
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    @Override
    protected void onStop() {
        Toast.makeText(this, "stoped", Toast.LENGTH_SHORT).show();
        if(permission_write==true){
            save_data();
        }
        super.onStop();
    }

    private void save_data() {

        String dir= Environment.getExternalStorageDirectory().getPath();

        File f=new File(dir,"fichier.txt");
        try {
            FileWriter fw=new FileWriter(f,false);
            BufferedWriter bw=new BufferedWriter(fw);
            for(int i=0;i< data.size();i++){
                bw.write(data.get(i).nom+"#"+data.get(i).prenom+"#"+data.get(i).num+"\n");
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void onDestroy() {

        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
     if(requestCode==1){
         if(grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED)
         {
             permission_write=true;
         }
         else
             {
             permission_write=false;

         }
     }
    }

}