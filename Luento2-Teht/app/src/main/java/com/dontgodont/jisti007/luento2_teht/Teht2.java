package com.dontgodont.jisti007.luento2_teht;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by K1697 on 4.9.2017.
 */

public class Teht2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teht2);

        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.username);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new String[] {"Pasi", "Juha", "Kari", "Jouni", "Esa", "Hannu"});
        actv.setAdapter(aa);
    }

    public void loginClick(View view) {

       /* RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        int id = rg.getCheckedRadioButtonId();*/

        AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.username);

        EditText edit = (EditText) findViewById(R.id.password);

        String text = (String) act.getText().toString() + " " + edit.getText();

        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void exitClick(View view) {
        finish();
    }
}
