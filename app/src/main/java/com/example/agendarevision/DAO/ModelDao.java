package com.example.agendarevision.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agendarevision.Entite.Model;

import java.util.List;

@Dao
public interface ModelDao {
    @Query("SELECT * FROM `secret`")
    List<Model> getAll();


    @Query("SELECT * FROM `secret` WHERE nom == :nom LIMIT 1")
    Model findByNom(String nom);




    @Insert
    void insertAll(Model... model);

    @Insert
    void insertOne(Model... model);

    @Delete
    void delete(Model... model);

}
