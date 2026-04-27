package com.example.dopamine;

public class Evento {
    private int id;
    private String nomeEvento;
    private String posizione;
    private String data;
    private String descrizione;

    public Evento(int id, String nomeEvento, String posizione, String data, String descrizione) {
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.posizione = posizione;
        this.data = data;
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getPosizione() {
        return posizione;
    }

    public String getData() {
        return data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
