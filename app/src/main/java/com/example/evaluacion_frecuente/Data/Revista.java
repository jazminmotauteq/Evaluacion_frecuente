package com.example.evaluacion_frecuente.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
//por q solo se la ha desenpeñar dengro de clase
private String joiunal_i;
private String portada;
private String name;

public Revista(JSONObject jsondatos) throws JSONException {
      joiunal_i = jsondatos.getString("journal_id");
       portada = jsondatos.getString("portada");
      name = jsondatos.getString("name");



}
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray jsondato) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < jsondato.length() && i<20; i++) {
            revistas.add(new Revista(jsondato.getJSONObject(i)));
        }
        return revistas;
    }

    public String getJoiunal_i() {
        return joiunal_i;
    }

    public void setJoiunal_i(String joiunal_i) {
        this.joiunal_i = joiunal_i;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
