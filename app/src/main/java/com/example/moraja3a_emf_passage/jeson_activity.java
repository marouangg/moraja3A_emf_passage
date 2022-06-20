package com.example.moraja3a_emf_passage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class jeson_activity extends AppCompatActivity {

    ListView lv ;
    ArrayList<String> ls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeson);

        lv=findViewById(R.id.lv);
////////////////////////////////////////////////////
        /*public String loadJSonFromRaw(int resId){
        try {
            InputStream in = getResources().openRawResource(resId);
            byte[] data = new byte[0];
            data = new byte[in.available()];
            in.read(data);
            in.close();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
////////////////////////////////////////////////////////
 try {
            JSONObject obj = new JSONObject(r);

            Toast.makeText(this, "Nom : "+ obj.getString("nom"), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Prenom : "+ obj.getString("prenom"), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Age : "+ obj.getInt("age"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }



        String j = getLoadjson(R.raw.personne);

        try {
            JSONObject obj = new JSONObject(j);
        } catch (JSONException e) {
            e.printStackTrace();
        }

///////////////////////////////////////////////////////////////////////////////////
        String r = getloadjson(R.raw.filier);
        try {
            JSONArray arr = new JSONArray(r);
            for (int i=0;i<arr.length();i++){
                JSONObject obj = arr.getJSONObject(i);
                ls.add(obj.getString("nom"));

            }
            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ls);
            lv.setAdapter(ad);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
*/

    }

/*
/////////////////////////////////////////////////////////////////////////
    public  String getLoadjson(int resId){

        String res ="";
        InputStream i = getResources().openRawResource(resId);
        try {
            int t = i.available();
            byte[] data = new byte[t];
            i.read(data);
            res=new String(data);
            i.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
    ///////////////////////////////////////////////////////////////////////


    public String getloadjson(int resID){
        String res ="";
        InputStream i = getResources().openRawResource(resID);
        try {
            int t = i.available();
            byte[] d = new byte[t];

            i.read();
            res=new String(d);
            i.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////

    public String loadjeson(int resid){
        String res ="";

        InputStream i = getResources().openRawResource(resid);
        try {
            int t = i.available();
            byte[] d = new byte[t];

            i.read();
            res=new String(d);
            i.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    void getAllEmploye(){
        ArrayList<Employe> lse = new ArrayList<>();
        String r = loadjeson(R.raw.employe);
        JSONArray ar = null;
        try {
            ar = new JSONArray(r);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i =0;i<ar.length();i++){
            JSONObject jo = ar.getJSONObject(i);
            Employe e = new Employe();
            e.setNom(jo.getString("nom"));
            e.setMatricule(jo.getString("matricule"));

            lse.add(e);
        }
    }
    /////////////////////////////////////////////////////////////////////
*/
}