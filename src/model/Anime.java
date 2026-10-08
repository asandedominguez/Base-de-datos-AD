package model;

import java.sql.Date;

public class Anime {
    public String nome;
    public String descripcion;
    public Date data;
    public int puntuacion;

    public Anime(String nome, String descripcion, Date data, int puntuacion) {
        this.nome = nome;
        this.descripcion = descripcion;
        this.data = data;
        this.puntuacion = puntuacion;
    }

    public String getNome() {
        return nome;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getData() {
        return data;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}