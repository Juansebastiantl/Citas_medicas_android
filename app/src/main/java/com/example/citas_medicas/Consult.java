package com.example.citas_medicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class Consult extends AppCompatActivity {
    private ListView listUsers;
    private Button btnConsult;
    DataBase dataBase = new DataBase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        initialize();
        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Consult.this, "Consulta",Toast.LENGTH_LONG).show();
               // Toast.makeText(Consult.this, dataBase.getcitas().getNombre(),Toast.LENGTH_LONG).show();
               //        android.R.layout.simple_list_item_1);

                String[] str = new String[dataBase.getCitas().size()];

                for (int i = 0; i < dataBase.getCitas().size(); i++) {
                    str[i] = (dataBase.getCitas().get(i).getNombre()+" "+
                              dataBase.getCitas().get(i).getEspecialidad()+" "+
                            dataBase.getCitas().get(i).getMedico()+" "+
                            dataBase.getCitas().get(i).getFecha());
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Consult.this, android.R.layout.simple_list_item_1, str);
                listUsers.setAdapter(adapter);
                //listUsers.setAdapter(Arrays.toString(adapter));


            }
        });

    }

    private void initialize(){
        listUsers = (ListView) findViewById(R.id.listUsers);
        btnConsult = (Button) findViewById(R.id.btnConsult);
    }
}