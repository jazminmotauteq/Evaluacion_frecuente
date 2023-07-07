package com.example.evaluacion_frecuente.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluacion_frecuente.Data.Libro;
import com.example.evaluacion_frecuente.Data.Revista;
import com.example.evaluacion_frecuente.R;

import java.util.ArrayList;

public class AdaptadorLibro extends ArrayAdapter <Libro>  {

    public AdaptadorLibro(Context context, ArrayList<Libro> datos) {
        super(context, R.layout.lyiteminfolibro,datos);


    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyiteminfolibro, null);
        //se incoca a la  tviw

        TextView lblaño = (TextView)item.findViewById(R.id.txtaño);
        lblaño.setText(getItem(position).getAño());
        TextView lbltitulo = (TextView)item.findViewById(R.id.txttitulo);
        lbltitulo .setText(getItem(position).getTitulo());
        TextView lblvolumen = (TextView)item.findViewById(R.id.txtvolumen);
        lblvolumen.setText(getItem(position).getVolumen());
        ImageView imageView = (ImageView)item.findViewById(R.id.imglibros);
        Glide.with(this.getContext()).load(getItem(position).getImg()).into(imageView);
        return(item);
    }

}
