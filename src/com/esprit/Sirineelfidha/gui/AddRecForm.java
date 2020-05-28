/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Sirineelfidha.gui;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.esprit.Sirineelfidha.entities.User;
import com.esprit.Sirineelfidha.entities.reclamation;
import com.esprit.Sirineelfidha.service.OpinionDAO;
import com.esprit.Sirineelfidha.service.service;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Sirine
 */
public class AddRecForm extends BaseForm {
     
    public AddRecForm (com.codename1.ui.util.Resources resourceObjectInstance){
      installSidemenu(resourceObjectInstance);
      setTitle("Add a reclamation");
        setLayout(BoxLayout.y());
        
         ComboBox combo = new ComboBox();
        if (service.getInstance().getAllUser()!= null && !service.getInstance().getAllUser().isEmpty()) {
            Random r = new Random();
           
          // combo.addItem("0");
            for (User n : service.getInstance().getAllUser()) {

                combo.addItem(n.getIdUser());

            };
       }
        String x= String.valueOf((String)combo.getSelectedItem());
        TextField tfUser = new TextField("","User");
        TextField tfDetails= new TextField("", "Details");
        Picker tfdatereclamation = new Picker();
        tfdatereclamation.setType(Display.PICKER_TYPE_DATE);
        Button btnValider = new Button("Add reclamation");
      
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfDetails.getText().length()==0)
                        //||(tfUser.getText().length()==0)
                        )
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        reclamation r = new reclamation(tfDetails.getText()
                                //,tfUser.getText()
                        );
                         String n3 = (String)combo.getSelectedItem();
                        if( service.getInstance().addRec(r))
                            
                        Dialog.show("Success","Connection accepted",new Command("OK"));
                        new OpinionDAO();
                      
                        
//        else
//                            Dialog.show("error", "Connection no accepted", new Command("OK"));
//                        
                } catch (NumberFormatException e) {
//                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                   }
                    
               }
                
         }
        });
        
        addAll(//tfUser,
                tfDetails,combo
                ,btnValider);
 
                
    }
    
    }

