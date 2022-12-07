package com.example.demo.model;

import java.time.LocalDate;

public class Persona {

    private String nome;
    private String cognome;
    private LocalDate dob; //dob = abb. date of birthday SI USA LOCAL DATE PERCHE CALENDAR E DATE SONO DEPRECATE
    private int height;

    public Persona(String nome, String cognome, LocalDate dob, int height) {
        this.nome = nome;
        this.cognome = cognome;
        this.dob = dob;
        this.height = height;
    }

    public Persona(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
