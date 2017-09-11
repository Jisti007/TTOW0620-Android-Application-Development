package com.dontgodont.jisti007.luento3_teht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dontgodont.jisti007.luento3_teht.R;

import java.util.ArrayList;

/**
 * Created by Käyttäjä on 11.9.2017.
 */
public class ListAdapterArray extends ArrayAdapter<String> {

    private Context context;

    private ArrayList<String> items;

    public ListAdapterArray(Context context, ArrayList<String> phones) {
        super(context, R.layout.rowlayout, R.id.textView, phones);
        this.context = context;
        this.items = phones;
    }

    // populate every row in ListView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        textView.setText(items.get(position));

/*        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        switch (phones.get(position)) {
            case "Android": imageView.setImageResource(R.drawable.android); break;
            case "iPhone": imageView.setImageResource(R.drawable.ios); break;
            case "WindowsMobile": imageView.setImageResource(R.drawable.windows); break;
            case "Blackberry": imageView.setImageResource(R.drawable.blackberry); break;
            case "WebOS": imageView.setImageResource(R.drawable.webos); break;
            case "Ubuntu": imageView.setImageResource(R.drawable.ubuntu); break;
        }
*/
        return rowView;
    }

}