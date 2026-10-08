package model;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Anime {
    public String nome;
    public String descripcion;
    public Date data;
    public String puntuacion;

    public Anime(String nome, String descripcion, Date data, String puntuacion) {
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

    public String getPuntuacion() {
        return puntuacion;
    }
}
