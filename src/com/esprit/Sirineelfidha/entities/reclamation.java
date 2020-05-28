/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Sirineelfidha.entities;

import java.util.Date;

/**
 *
 * @author Sirine
 */
public class reclamation {
     private int idReclamation;
   private String details ,etatReclamation,etatUser,idUser,userRep;
   private String dateReclamation;
   
   public reclamation(int idReclamation,String details,String etatReclamation,String etatUser ,String idUser,String userRep,String  dateReclamation ) {
             this.idReclamation=idReclamation;
             this.dateReclamation=dateReclamation;
             this.details=details;
             this.etatReclamation=etatReclamation;
             this.idUser=idUser;
             this.etatUser=etatUser;
             this.userRep=userRep;
             

     }

    public reclamation() {
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEtatReclamation() {
        return etatReclamation;
    }

    public void setEtatReclamation(String etatReclamation) {
        this.etatReclamation = etatReclamation;
    }

    public String getEtatUser() {
        return etatUser;
    }

    public void setEtatUser(String etatUser) {
        this.etatUser = etatUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserRep() {
        return userRep;
    }

    public void setUserRep(String userRep) {
        this.userRep = userRep;
    }

    public String getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(String dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

  
    public reclamation(String details, String idUser, String dateReclamation) {
        this.details = details;
        this.idUser = idUser;
        this.dateReclamation = dateReclamation;
    }

    public reclamation(String details, String idUser) {
        this.details = details;
        this.idUser = idUser;
    }
    @Override
    public String toString() {
        return "reclamation{" + "idReclamation=" + idReclamation + ", details=" + details + ", etatReclamation=" + etatReclamation + ", etatUser=" + etatUser + ", idUser=" + idUser + ", userRep=" + userRep + ", dateReclamation=" + dateReclamation + '}';
    }

    public reclamation(String details) {
        this.details = details;
    }
   
   
   
}
