package com.example.kazukoba.listviewsamplesimple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kazukoba on 2018/01/30.
 */

public class ListViewAdapter extends ArrayAdapter<ListData> {
    private LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, int resource, List<ListData> objects) {
        super(context, resource, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListData data = (ListData)getItem(position);
        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView idText;
        TextView nameText;
        TextView yomiText;
        TextView kentyoText;
        TextView yomi_kentyoText;

        idText = (TextView)convertView.findViewById(R.id.id);
        nameText = (TextView)convertView.findViewById(R.id.name);
        yomiText = (TextView)convertView.findViewById(R.id.yomi);
        kentyoText = (TextView)convertView.findViewById(R.id.kentyo);
        yomi_kentyoText = (TextView)convertView.findViewById(R.id.yomi_kentyo);

        idText.setText(data.getId());
        nameText.setText(data.getName());
        yomiText.setText(data.getYomi());
        kentyoText.setText(data.getKentyo());
        yomi_kentyoText.setText(data.getYomi_kentyo());

        return convertView;
    }
}