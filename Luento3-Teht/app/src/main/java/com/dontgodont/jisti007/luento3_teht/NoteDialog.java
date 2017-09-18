package com.dontgodont.jisti007.luento3_teht;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Käyttäjä on 18.9.2017.
 */

public class NoteDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final EditText input = new EditText(getActivity());
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

        builder.setTitle("Add new note")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // m_Text = input.getText().toString();
                        //Toast.makeText(getActivity(), "Exit", Toast.LENGTH_SHORT).show();
                        //android.os.Process.killProcess(android.os.Process.myPid());
                        //System.exit(1);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                    }


                });
        return builder.create();
    }

}