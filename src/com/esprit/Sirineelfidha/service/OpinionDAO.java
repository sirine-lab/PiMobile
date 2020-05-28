/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Sirineelfidha.service;

import com.codename1.messaging.Message;
import com.codename1.ui.Display;

/**
 *
 * @author Sirine
 */
public class OpinionDAO {
   
             public OpinionDAO(){
    
    Message m = new Message("Body of message");
    Display.getInstance().sendMessage(new String[] {"sirine.elfidha@esprit.tn"}, "Reclamation envoyée pour toi ", m);
        
        
    }
    
}
