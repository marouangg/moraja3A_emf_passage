package com.example.moraja3a_emf_passage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class edite_Activity extends AppCompatActivity {

    MyDatabase db ;
    ArrayList<Societe>ls= new ArrayList<>();
    ArrayAdapter ad;

    Spinner sp ;
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite);
        db=new MyDatabase(this);

        e1=findViewById(R.id.txt_edit_nom);
        e2=findViewById(R.id.txt_edit_secteur);
        e3=findViewById(R.id.txt_edit_nb);
        sp=findViewById(R.id.cb_societe);
        getAll_soc();
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               Societe s = ls.get(position);
               e1.setText(s.getNom());
               e2.setText(s.getSecteur_act());
               e3.setText(String.valueOf(s.getNb_employe()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    void getAll_soc(){
        ls=MyDatabase.getAllSociete(db.getReadableDatabase());

        ArrayList<Integer> ids = new ArrayList<>();

        for (Societe s : ls)
            ids.add(s.getId());

        ad=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,ids);

        sp.setAdapter(ad);
    }
    public void Supprimer(View view) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Message de confermation");
        b.setMessage("Are you sure you want to deleted from the database");

        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Societe s = ls.get(sp.getSelectedItemPosition());
                MyDatabase.DeleteSociete(db.getWritableDatabase(),s.getId());
                getAll_soc();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getAll_soc();
            }
        });
        b.show();
    }

    public void Modiffier(View view) {

        AlertDialog.Builder b = new AlertDialog.Builder(edite_Activity.this);
        b.setTitle("Message confirmation");
        b.setMessage("are you sure you want to update the database ????");

        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Societe s = ls.get(sp.getSelectedItemPosition());
                s.setNom(e1.getText().toString());
                s.setSecteur_act(e2.getText().toString());
                s.setNb_employe(Double.parseDouble(e3.getText().toString()));

                MyDatabase.UpdateSociete(db.getWritableDatabase(),s);

                getAll_soc();;
            }
        });

        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             getAll_soc();
            }
        });

        b.show();
    }
}