package com.syahril.utsmobprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDaftarItem extends BaseAdapter {
    private static ArrayList<RincianData> listData;
    private LayoutInflater layout;

    // Konstruktor
    public AdapterDaftarItem(Context context,
                             ArrayList<RincianData> results) {
        listData = results;
        layout = LayoutInflater.from(context);
    }

    public int getCount() {
        return listData.size();
    }

    public Object getItem(int position) {
        return listData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View cV, ViewGroup parent) {
        ViewData vd;
        if (cV == null) {
            cV = layout.inflate(R.layout.detail, null);
            vd = new ViewData();
            vd.imageViewCake = (ImageView) cV.findViewById(
                    R.id.imageViewCake);

            vd.textViewCake = (TextView) cV.findViewById(
                    R.id.textViewCake);

            cV.setTag(vd);
        } else {
            vd = (ViewData) cV.getTag();
        }

        vd.imageViewCake.setImageResource(
                MainActivity.ID_CAKE[listData.get(position)
                        .perolehIdCake() - 1]);
        vd.textViewCake.setText(listData.get(position)
                .perolehCake());
        return cV;
    }

    static class ViewData {
        ImageView imageViewCake;
        TextView textViewCake;
    }
}
