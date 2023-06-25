package com.example.citas_medicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister;
    private Button btnConsult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Register",Toast.LENGTH_LONG).show();
                Intent intent_register = new Intent(MainActivity.this,Register.class);
                startActivity(intent_register);
            }
        });

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Consult",Toast.LENGTH_SHORT).show();
                Intent intent_consult = new Intent(MainActivity.this,Consult.class);
                startActivity(intent_consult);
            }
        });

    }
    private void initialize(){
        btnRegister = (Button) findViewById(R.id.btnViewRegister);
        btnConsult = (Button) findViewById(R.id.btnViewConsult);
    }

}