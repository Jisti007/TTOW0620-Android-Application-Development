/*
* http://student.labranet.jamk.fi/~mapas/s2017/TTOW0620/
* Tehtävänantona: tee jotain siistiä dialogeilla/menuilla ja notifikaatioilla
* */

package com.dontgodont.jisti007.luento3_teht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listView);

        final String[] items = new String[] {
                "Eka", "Toka", "Kolmas", "Neljäs", "Viides"
        };

        final ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<items.length;i++) {
            list.add(items[i]);
        }

        ListAdapterArray adapter = new ListAdapterArray(this, list);

        listview.setAdapter(adapter);

        //TODO: lisää items stringin alle details teksti

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = list.get(position);
            //tähän että toastaisi titlen
                Toast toasti = Toast.makeText(getApplicationContext(), items[position], Toast.LENGTH_SHORT);
            }
        });


    }
}
