/*
* http://student.labranet.jamk.fi/~mapas/s2017/TTOW0620/
* Tehtävänantona: tee jotain siistiä dialogeilla/menuilla ja notifikaatioilla
* */

package com.dontgodont.jisti007.luento3_teht;

import android.app.Activity;
import android.app.Fragment;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.visibility;

public class MainActivity extends AppCompatActivity {

    public int notification_id = 0;

    public ArrayList<String> items = new ArrayList<String>();
   // public ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();


     //public String[] items = new String[] {"Testinootti", "Toinen nootti"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.listView);

      //  final ArrayList<String> list = new ArrayList<>();


        //array init
        items.add("Add a note to the status bar by tapping");

        //arraylist
        for (int i=0; i<items.size()-1;i++) {

            items.get(i);
        }
/*
        //  vanha string
        for (int i=0; i<items.length;i++) {

            list.add(items[i]);
        }*/

        final ListAdapterArray adapter = new ListAdapterArray(this, items);

        listview.setAdapter(adapter);

        //TODO: lisää items stringin alle details teksti

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast toasti = Toast.makeText(getApplicationContext(), items.get(position), Toast.LENGTH_SHORT);
                Toast toasti = Toast.makeText(getApplicationContext(), "New note added", Toast.LENGTH_SHORT);
                toasti.show();
                newNotification(items.get(position));
            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast toasti = Toast.makeText(getApplicationContext(), position, Toast.LENGTH_SHORT);

                    deleteItem(position);
                //  newNotification(items.get(position));

                return true;
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        final ListView listview = (ListView) findViewById(R.id.listView);

        final ListAdapterArray adapter = new ListAdapterArray(this, items);

        listview.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    public void newNotification(String title) {

        Notification notification  = new NotificationCompat.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle(title)
                // .setContentText("Notification message here")
                .setSmallIcon(R.drawable.mainico)
                .setAutoCancel(true)
                .setVisibility(visibility).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notification_id, notification);
        notification_id += 1;

    }

    public void deleteItem(int delitem) {

        final int delint = delitem;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Delete note on line " + delint)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        items.remove(delint);
                        //   items[x] = input.getText().toString();
                        //   items[2] = "asd";

                        Toast toasti = Toast.makeText(getApplicationContext(), "Note deleted.", Toast.LENGTH_SHORT);
                        toasti.show();

                        for (int i=0; i<items.size();i++) {
                            items.get(i);
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                });
        builder.show();

    }

    public void addNote(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setTitle("Add new note")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        items.add(input.getText().toString());
                        int x = items.size()-1;
                     //   items[x] = input.getText().toString();
                     //   items[2] = "asd";

                     //   Toast toasti = Toast.makeText(getApplicationContext(), items.get(x), Toast.LENGTH_SHORT);
                        Toast toasti = Toast.makeText(getApplicationContext(), "Note added", Toast.LENGTH_SHORT);
                        toasti.show();

                   //    ListView listview = (ListView) findViewById(R.id.listView);

                        for (int i=0; i<items.size();i++) {
                            items.get(i);
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                });
        builder.show();

    }

}
