package com.example.moraja3a_emf_passage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class list_tous_Activity extends AppCompatActivity {


    MyDatabase db ;
    ArrayList<Societe> ls = new ArrayList<>();
    ListView lv;
    BaseAdapter bs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tous);

        db=new MyDatabase(this);

        lv=findViewById(R.id.list_view_s);
        ls=MyDatabase.getAllSociete(db.getReadableDatabase());

        bs=new Basesocite(ls);
        lv.setAdapter(bs);
    }

    public class Basesocite extends BaseAdapter{

        ArrayList<Societe> list_s = new ArrayList<>();
        public Basesocite(ArrayList<Societe> ss){
            this.list_s=ss;
        }
        @Override
        public int getCount() {
            return list_s.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater li = getLayoutInflater();
            View v = li.inflate(R.layout.grid,null);
            TextView t1,t2;
            t1=v.findViewById(R.id.txt_nom_s);
            t2=v.findViewById(R.id.txt_nom_nb);

            t1.setText(list_s.get(position).getNom());
            t2.setText(String.valueOf(list_s.get(position).getNb_employe()));
            return v;
        }

    }
}