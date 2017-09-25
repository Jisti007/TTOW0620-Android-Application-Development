package com.dontgodont.jisti007.luento5_teht;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        setContentView(R.layout.activity_teht1);
    }

    public void buttonClick(View view) {

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        int id = rg.getCheckedRadioButtonId();

        RadioButton rb = (RadioButton) findViewById(id);

        String text = (String) rb.getText();

        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void exitClick(View view) {
        finish();
    }
}
