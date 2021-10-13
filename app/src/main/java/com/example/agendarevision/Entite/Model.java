package com.example.agendarevision.Entite;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "secret")
public class Model {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo (name = "nom")
    private String nom;

    @ColumnInfo (name = "mdp")
    private String mdp;


    public Model(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
