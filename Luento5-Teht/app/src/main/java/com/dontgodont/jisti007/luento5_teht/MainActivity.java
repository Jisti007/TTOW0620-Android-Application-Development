package com.dontgodont.jisti007.luento5_teht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1Click(View view) {
        Intent i = new Intent(getApplicationContext(), Teht1.class);
        startActivity(i);
    }

    public void btn2Click(View view) {
        Intent i = new Intent(getApplicationContext(), Teht2.class);
        startActivity(i);
    }


}
