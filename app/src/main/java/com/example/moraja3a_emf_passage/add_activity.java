package com.example.moraja3a_emf_passage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class add_activity extends AppCompatActivity {

    MyDatabase db;
    EditText e1,e3,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db=new MyDatabase(this);
        e1=findViewById(R.id.txt_nom);
        e2=findViewById(R.id.txt_secteur);
        e3=findViewById(R.id.txt_nbEmploye);
    }

    public void annuler(View view) {

        finish();
    }

    public void Enregister(View view) {

        if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty() || e3.getText().toString().isEmpty())
        {
            AlertDialog.Builder d = new AlertDialog.Builder(add_activity.this);
            d.setTitle("message error");
            d.setMessage("remplire tous les champs");
            d.show();
            e1.requestFocus();
        }

        Societe s = new Societe();

        s.setNom(e1.getText().toString());
        s.setSecteur_act(e2.getText().toString());
        s.setNb_employe(Double.parseDouble(e3.getText().toString()));

        if(MyDatabase.AddSociete(db.getWritableDatabase(),s)==-1)
            Toast.makeText(this, "add eroor", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this, "add sucsufly", Toast.LENGTH_SHORT).show();
    }
}