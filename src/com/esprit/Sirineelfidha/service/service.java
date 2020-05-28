/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Sirineelfidha.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;


import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.esprit.Sirineelfidha.entities.User;
import com.esprit.Sirineelfidha.entities.reclamation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;




/**
 *
 * @author Sirine
 */
public class service {
    

    public ArrayList<reclamation> reclamation;
    int k =0;
    public static service instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public service() {
         req = new ConnectionRequest();
    }

    public static service getInstance() {
        if (instance == null) {
            instance = new service();
        }
        return instance;
    }

    public boolean addRec(reclamation r) {
        String url = "http://localhost:81/untitled/web/app_dev.php/Reclamation/new?idReporter=8"+"&idReported="+r.getIdUser()+"&details="+r.getDetails()+"&dateReclamation="+ r.getDateReclamation();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this);    
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
       
    }

    public ArrayList<reclamation> parse(String jsonText)  {
        try {
            reclamation=new ArrayList<>();
            JSONParser j = new JSONParser();

           
            Map<String,Object> RecListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)RecListJson.get("root");
            //System.out.println("id:"+ list.get(0).get("idReclamation"));
           // for(Map<String,Object> obj : list){
            //System.out.println("size"+list.size());
               for(int i=0 ;i<list.size();i++){
                reclamation r = new reclamation();
                   //System.out.println("11111111111111:"+list.get(i).get("idReclamation").toString());
                float idReclamation = Float.parseFloat(list.get(i).get("id").toString());
                  r.setIdReclamation((int)idReclamation);

                  r.setDetails(list.get(i).get("details").toString());

                  r.setDateReclamation(list.get(i).get("date_reclamation").toString());
                  //r.setEtatReclamation(obj.get("etatReclamation").toString());
                 // r.setEtatUser(obj.get("etatUser").toString());
                 // r.setUserRep(obj.get("userRep").toString());
                 // r.setIdUser(list.get(i).get("user_reported").toString());

                  //System.out.println("reccccccccccc"+r);
                  
                try {
                    
                    Date dateReclamation =new SimpleDateFormat("dd/MM/yyyy").parse(list.get(i).get("date_Reclamation").toString());
                } catch (Exception ex) {
                   
                }
                reclamation.add(r);
            }
            
            
        } catch (NullPointerException e) {
            e.printStackTrace();
            
        } catch (IOException ex) {
                      ex.printStackTrace();

        }
         
        return reclamation;
    }
    
    
    public ArrayList<reclamation> getAll(){
        String url = "http://localhost:81/untitled/web/app_dev.php/Reclamation/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                    reclamation = parse(new String(req.getResponseData()));
                    req.removeResponseListener(this);
               
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamation;
    }
  

     public void deleteM(reclamation r,int idReclamation) {
        req.setPost(true);
        req.setUrl("http://localhost:81/untitled/web/app_dev.php/Reclamation/deleteM/" + r.getIdReclamation());
        req.setHttpMethod("POST");
        
        req.addArgument("reclamation", String.valueOf(idReclamation));

        NetworkManager.getInstance().addToQueueAndWait(req);

    }
     
     public ArrayList<User> user;

    public ArrayList<User> parseTasksuser(String jsonText) {
        try {
            user = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> NoteListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) NoteListJson.get("root");
            for(int i=0 ;i<list.size();i++){
            //for (Map<String, Object> obj : list) {
                User t = new User();
//                float id = Float.parseFloat(obj.get("id").toString());
//                t.setId((int) id);
               // t.setIdUser(obj.get("user_reported").toString());
                 float id = Float.parseFloat(list.get(i).get("id").toString());
                  t.setId((int)id);
                 
                  t.setIdUser(list.get(i).get("username").toString());
                 
               
                user.add(t);

            }
        } catch (IOException ex) {

        }
        return user;
    }
     
  
    
      public ArrayList<User> getAllUser() {
        
        String Url = "http://localhost:81/untitled/web/app_dev.php/User/affiche";
        req.setUrl(Url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                user = parseTasksuser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return user;
    }
     /*
      Ba33333333333333333333333333
      */
}


