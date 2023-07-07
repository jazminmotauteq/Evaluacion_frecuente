package com.example.evaluacion_frecuente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evaluacion_frecuente.Adaptadores.AdaptadorRevista;
import com.example.evaluacion_frecuente.Data.Revista;
import com.example.evaluacion_frecuente.WebService.Asynchtask;
import com.example.evaluacion_frecuente.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements Asynchtask, AdapterView.OnItemClickListener {


private ListView lstOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //COnexion
        String url="https://revistas.uteq.edu.ec/ws/journals.php";
        Map<String,String> datos =new HashMap<String,String>();
//se llama al web service
        WebService webService = new WebService(url,datos,MainActivity.this,MainActivity.this);

        webService.execute("GET");
        //vista
         lstOp= (ListView)findViewById(R.id.lstrevista);

    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray JSONlistarevista = new JSONArray(result);
        //modelo
        ArrayList<Revista> lstrevista = Revista.JsonObjectsBuild(JSONlistarevista);
       //adaptador
        AdaptadorRevista adaptadorRevista = new AdaptadorRevista(MainActivity.this,lstrevista);
        lstOp.setAdapter(adaptadorRevista);
//inicializacion del evento onlclick
        lstOp.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      //crea objeto revista y guarda la posicion sele
        //seleccionada de la revista

        Revista revista = (Revista)parent.getItemAtPosition(position);

        String identificador= revista.getJoiunal_i().toString();
       Intent intent =new Intent(MainActivity.this,LibrosEdiciones.class);
       Bundle bundle = new Bundle ();
       bundle.putString("id",identificador);

       intent.putExtras(bundle);
       startActivity(intent);


//PRA VER SI NOS ENVIA ALA ACTIVIDDA
        Toast.makeText(this,"ID seleccionado"+identificador,Toast.LENGTH_SHORT).show();


    }
}