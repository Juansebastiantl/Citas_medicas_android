package com.example.citas_medicas;

import java.util.ArrayList;

public class DataBase {
    private static ArrayList<Citas> citas = new ArrayList<>();
    static{
     //   citas.add(new Citas("Mensaje 1", "M","A", "V"));
    }

    public void addcitas(String name, String id, String email, String birthdate)
    {
        citas.add(new Citas(name, id, email, birthdate));
    }

    public ArrayList<Citas> getCitas()
    {
        return(citas);
    }
}
