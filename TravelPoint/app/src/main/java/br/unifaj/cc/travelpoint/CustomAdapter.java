package br.unifaj.cc.travelpoint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataItem> {

    private final int resource;

    public CustomAdapter(Context context, int resource, List<DataItem> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(resource, parent, false);
        }

        DataItem item = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView textView = convertView.findViewById(R.id.item_text);

        imageView.setImageResource(item.resIdThumbnail);
        textView.setText(item.countryName);

        return convertView;
    }
}