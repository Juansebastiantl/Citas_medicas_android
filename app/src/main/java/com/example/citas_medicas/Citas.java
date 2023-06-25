package com.example.citas_medicas;

public class Citas {

    private String nombre;
    private String especialidad;
    private String medico;
    private String fecha;

    public Citas(String nombre, String especialidad, String medico, String fecha) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.medico = medico;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }





}
