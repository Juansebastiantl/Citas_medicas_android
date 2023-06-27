package com.example.citas_medicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class Consult extends AppCompatActivity {
    private ListView listUsers;
    private Button btnConsult;
    private Button btnConsultID;
    private Spinner spinnerID;
    DataBase dataBase = new DataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        spinnerID = findViewById(R.id.spinnerID);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerID, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerID.setAdapter(adapter);

        initialize();
        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Consult.this, "Consulta",Toast.LENGTH_LONG).show();
               // Toast.makeText(Consult.this, dataBase.getcitas().getNombre(),Toast.LENGTH_LONG).show();
               //        android.R.layout.simple_list_item_1);
                Log.i(dataBase.getCitas().toString(), "Tengo los datos " + dataBase.getCitas().size());

                String[] str = new String[dataBase.getCitas().size()];

                for (int i = 0; i < dataBase.getCitas().size(); i++) {
                    str[i] = (dataBase.getCitas().get(i).getNombre()+" "+
                              dataBase.getCitas().get(i).getEspecialidad()+" "+
                            dataBase.getCitas().get(i).getMedico()+" "+
                            dataBase.getCitas().get(i).getFecha());
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Consult.this, android.R.layout.simple_list_item_1, str);
                listUsers.setAdapter(adapter);
            }
        });

        btnConsultID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Citas> newListCitas = new ArrayList<>();

                //Log.i(spinnerID.getSelectedItem().toString(), "Esto seleccione");

                for (Citas elements : dataBase.getCitas()) {
                    if (elements.getEspecialidad().equals(spinnerID.getSelectedItem().toString())) {
                        newListCitas.add(elements);
                    }
                }

                //Log.i(dataBase.getCitas().toString(), "Tengo los datos old " + dataBase.getCitas().size());
                //Log.i(newListCitas.toString(), "Tengo los datos new " + newListCitas.size());

                String[] strFilter = new String[newListCitas.size()];

                for (int i = 0; i < newListCitas.size(); i++) {
                    strFilter[i] = (newListCitas.get(i).getNombre()+" "+
                            newListCitas.get(i).getEspecialidad()+" "+
                            newListCitas.get(i).getMedico()+" "+
                            newListCitas.get(i).getFecha());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Consult.this, android.R.layout.simple_list_item_1, strFilter);
                listUsers.setAdapter(adapter);
            }
        });

    }

    private void initialize(){
        listUsers = (ListView) findViewById(R.id.listUsers);
        btnConsult = (Button) findViewById(R.id.btnConsult);
        btnConsultID = (Button) findViewById(R.id.btnConsultID);
    }
}