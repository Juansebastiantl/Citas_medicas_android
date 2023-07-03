package com.example.citas_medicas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText txtName;
    private Spinner spinnerRID;
    private Spinner spnMedico;
    private EditText txtBirthday;
    private Button btnRegister;

    private Database_administrator obj_base;

   // DataBase dataBase = new DataBase();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinnerRID = findViewById(R.id.spinnerRID);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerID, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerRID.setAdapter(adapter);

        spnMedico = findViewById(R.id.spnMedico);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this, R.array.spnMedico, android.R.layout.simple_spinner_item);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnMedico.setAdapter(adapterTwo);

        initialize();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean confirm = obj_base.connectSQL();
                if(confirm){

                    Toast.makeText(Register.this, "Exito en la conexion",Toast.LENGTH_LONG).show();

                    boolean registro = obj_base.insert_record(txtName.getText().toString(), spinnerRID.getSelectedItem().toString(), spnMedico.getSelectedItem().toString(), txtBirthday.getText().toString());
                    if (registro){
                        Toast.makeText(Register.this, "Exito en el registro",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Register.this, "Fallo en el registro",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Register.this, "Fallo la conexion",Toast.LENGTH_LONG).show();
                }

                //dataBase.addcitas(txtName.getText().toString(), spinnerRID.getSelectedItem().toString(), spnMedico.getSelectedItem().toString(), txtBirthday.getText().toString());

                //Toast.makeText(Register.this, "Se ha registrado la cita",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initialize(){

        txtName = (EditText) findViewById(R.id.txtName);
        txtBirthday = (EditText) findViewById(R.id.txtBirthday);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        obj_base = new Database_administrator();
    }
}