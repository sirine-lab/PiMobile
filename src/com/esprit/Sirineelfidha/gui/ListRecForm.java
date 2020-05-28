/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Sirineelfidha.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.Sirineelfidha.entities.User;
import com.esprit.Sirineelfidha.entities.reclamation;
import com.esprit.Sirineelfidha.service.service;
import java.util.ArrayList;

/**
 *
 * @author Sirine
 */
public class ListRecForm extends BaseForm {
    
      public ListRecForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    public ListRecForm(com.codename1.ui.util.Resources resourceObjectInstance) {
       
          
        installSidemenu(resourceObjectInstance);

       setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label("List Reclamation ");
               C1.add(titre);
               add(C1);
              
        service r = new service();
       
        ArrayList<reclamation> list = r.getAll();
        for (int i = 0; i < list.size(); i++) {
           
            reclamation rec = list.get(i);
              Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                //SpanLabel User= new SpanLabel("User:   " +rec.getIdUser());
                SpanLabel details = new SpanLabel("Details   " + rec.getDetails());
                SpanLabel date = new SpanLabel("Date:    "+ rec.getDateReclamation());
              
                
               Button btnDelete = new Button("Delete");
              
               btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { 
                int idReclamation = 0;
              service.getInstance().deleteM(rec,idReclamation)  ;
            }});
                 //C2.add(User);
                 C3.add(details);
                 C4.add( date);
                 C6.add(btnDelete);
           
       // C5.add(C2);
        C5.add(C3);
        C5.add(C4);
        C5.add(C6);
        add(C5);
       
        }
        
  
   }
}
