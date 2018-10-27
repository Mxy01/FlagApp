package com.example.lenovo.flag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter <Item> {
    ArrayList<Item> flagList = new ArrayList<>();
    public MyAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        flagList = objects;
    }
    @Override
    public int getCount() {
        return super.getCount();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_view_items, null);
        TextView textView = (TextView) v.findViewById(R.id.tv_item);
        ImageView imageView = (ImageView) v.findViewById(R.id.iv_item);
        textView.setText(flagList.get(position).getcountryName());
        imageView.setImageResource(flagList.get(position).getflagImage());
        ((ViewGroup)textView.getParent()).setTag(textView.getText());
        return v;
    }
}