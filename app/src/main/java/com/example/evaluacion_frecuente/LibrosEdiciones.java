package com.example.evaluacion_frecuente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evaluacion_frecuente.Adaptadores.AdaptadorLibro;
import com.example.evaluacion_frecuente.Adaptadores.AdaptadorRevista;
import com.example.evaluacion_frecuente.Data.Libro;
import com.example.evaluacion_frecuente.Data.Revista;
import com.example.evaluacion_frecuente.WebService.Asynchtask;
import com.example.evaluacion_frecuente.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibrosEdiciones extends AppCompatActivity implements Asynchtask {
    private ListView lstOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_ediciones);
//PARA RECIBIR LOS DATOS DE LA ACTIVIDDA QUE SE ENVIA
       Bundle bundle = this.getIntent().getExtras();

       String url="https://revistas.uteq.edu.ec/ws/issues.php?j_id=" +bundle.getString("id");
     //se crea un objeto MAP para el envio de datos al web servgice y se inicializa el mismo
        Map<String,String> datos =new HashMap<String,String>();
//se llama al web service
        WebService webService = new WebService(url,datos,LibrosEdiciones.this,LibrosEdiciones.this);

        webService.execute("GET");
        //vista
        lstOp= (ListView)findViewById(R.id.txtlibros);


    }




    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlislibros = new JSONArray(result);
        //modelo
        ArrayList<Libro> lstlibro = Libro.JsonObjectsBuild(JSONlislibros);
        //adaptador
        AdaptadorLibro adaptadorlibro = new AdaptadorLibro(LibrosEdiciones.this,lstlibro);
        lstOp.setAdapter(adaptadorlibro);
//inicializacion del evento onlclick


    }
}