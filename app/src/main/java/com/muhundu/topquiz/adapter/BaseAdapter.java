package com.muhundu.topquiz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muhundu.topquiz.R;

import java.util.ArrayList;

public class BaseAdapter extends android.widget.BaseAdapter {
    int index=0;
    Context context;
    ArrayList responseList;
    LayoutInflater inflter;

    public BaseAdapter(final Context context, final ArrayList responseList) {
        this.context = context;
        this.responseList = responseList;
        inflter=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item, null);
        TextView textA, textB, textC, txtNumColonne;
        textA=view.findViewById(R.id.colonne_a);
        textB=view.findViewById(R.id.colonne_b);
        textC=view.findViewById(R.id.colonne_c);
        txtNumColonne=view.findViewById(R.id.num_colonne);
        index=Integer.parseInt(responseList.get(i).toString());
        switch (index){
            case 0:
            textA.setText("A");
            textB.setText("");
            textC.setText("");
            txtNumColonne.setText("1.");
            break;
            case 1:
                textA.setText("");
                textB.setText("B");
                textC.setText("");
                txtNumColonne.setText("1.");
                break;
            case 2:
                textA.setText("");
                textB.setText("");
                textC.setText("C");
                txtNumColonne.setText("1.");
        }

        return view;

    }
}
