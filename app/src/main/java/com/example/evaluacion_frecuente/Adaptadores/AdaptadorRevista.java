package com.example.evaluacion_frecuente.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluacion_frecuente.Data.Revista;
import com.example.evaluacion_frecuente.R;

import java.util.ArrayList;

public class AdaptadorRevista extends ArrayAdapter <Revista> {
    //contructor de la calse
    public AdaptadorRevista(Context context, ArrayList<Revista>datos) {
      super(context, R.layout.lyitemnoticia,datos);


    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemnoticia, null);
        //se incoca a la  tviw

        TextView lblNombres = (TextView)item.findViewById(R.id.txtnombrerevista);
        lblNombres.setText(getItem(position).getName());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgarevista);
        Glide.with(this.getContext()).load(getItem(position).getPortada()).into(imageView);
        return(item);
    }

}
