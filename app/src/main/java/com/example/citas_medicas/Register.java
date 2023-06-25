package com.example.citas_medicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText txtName;
    private EditText txtId;
    private EditText txtEmail;
    private EditText txtBirthday;
    private Button btnRegister;

    DataBase dataBase = new DataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Register.this, txtName.getText(),Toast.LENGTH_LONG).show();
                dataBase.addcitas(txtName.getText().toString(),txtId.getText().toString(),txtEmail.getText().toString(),txtBirthday.getText().toString());
                //dataBase.addcitas("A","N","C", "D");
                Toast.makeText(Register.this, "Se ha registrado la cita",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initialize(){

        txtName = (EditText) findViewById(R.id.txtName);
        txtId = (EditText) findViewById(R.id.txtEspecialidad);
        txtEmail = (EditText) findViewById(R.id.txtMedico);
        txtBirthday = (EditText) findViewById(R.id.txtBirthday);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }
}