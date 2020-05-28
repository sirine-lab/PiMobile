/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Sirineelfidha.entities;

/**
 *
 * @author Sirine
 */
public class User {
    int id;
    String idUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", idUser=" + idUser + '}';
    }

    public User(int id, String idUser) {
        this.id = id;
        this.idUser = idUser;
    }

    public User(int id) {
        this.id = id;
    }

    public User() {
    }
    
}
