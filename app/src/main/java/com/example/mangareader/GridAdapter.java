package com.example.mangareader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private String[] mangaName;
    private int[] mangaImage;
    private Context context;

    LayoutInflater layoutInflater;
    public GridAdapter(String[] mangaName, int[] mangaImage, Context context){
        this.mangaName = mangaName;
        this.mangaImage = mangaImage;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mangaName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.row_images, parent);
        }

        ImageView imageView = convertView.findViewById(R.id.manga_images);
        TextView textView = convertView.findViewById(R.id.manga_names);

        imageView.setImageResource(mangaImage[position]);
        textView.setText(mangaName[position]);
        return convertView;
    }
}
