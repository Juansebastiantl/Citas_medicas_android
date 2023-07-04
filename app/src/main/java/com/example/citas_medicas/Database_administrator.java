package com.example.citas_medicas;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

public class Database_administrator {
    Connection connect;
    String url = "jdbc:mysql://34.135.162.139:3306/db_citasmedicas";
    // Donde dice ip Toca ir a revisar la ip, luego en google le damos conexiones y herramientas de redes
    // En donde vamos a ir a dar nuestra ip y la damos en las conexiones.
    //Donde dice db-app toca poner la de google
    String user = "juan";
    String passw = "12345";

    public boolean connectSQL(){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connect = DriverManager.getConnection(url, user, passw);
            Log.i("My tag", "Successful Connection");
            return true;
        }
        catch(Exception err){
            Log.i("My tag",err.toString());
            return false;
        }


    }

    public boolean insert_record(String fullname, String specialist, String doctor, String date ){
        try{
            String instructionSQL = "INSERT INTO citas VALUES('"+fullname+"','"+specialist+"','"+doctor+"','"+date+"')";
            connect.prepareStatement(instructionSQL).execute();
            Log.i("My tag", "User registered");
            return true;
        }
        catch(Exception err){
            Log.i("My tag",err.toString());
            Log.i("My tag", "Failed registered");
            return false;
        }
    }

    public ArrayList<String> consultTable () {
        String instructionSQL = "SELECT * FROM citas";
        ArrayList <String> datos = new ArrayList <String>();
        try {
            ResultSet results = connect.prepareStatement(instructionSQL).executeQuery();
            while (results.next()) {
                datos.add(results.getString("fullname") + " " + results.getString("specialist") + " "
                        + results.getString("doctor") + " " + results.getString("meddate"));
            }
        } catch (Exception err) {
            Log.d("myTag", err.toString());
        }
        return datos;
    }

}
