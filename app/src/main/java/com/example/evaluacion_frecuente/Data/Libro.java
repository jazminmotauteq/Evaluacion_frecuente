package com.example.evaluacion_frecuente.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Libro {
    private String titulo;
    private  String volumen;
    private  String año;
    private String portada;
    private  String img;
    public Libro(JSONObject jsondatos) throws JSONException {
        titulo= jsondatos.getString("title");
        volumen= jsondatos.getString("volume");
        año= jsondatos.getString("year");
        img = jsondatos.getString("cover");

    }
    public static ArrayList<Libro> JsonObjectsBuild(JSONArray jsondato) throws JSONException {
        ArrayList<Libro> libro = new ArrayList<>();
        for (int i = 0; i < jsondato.length() && i<20; i++) {
            libro.add(new Libro(jsondato.getJSONObject(i)));
        }
        return libro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}

