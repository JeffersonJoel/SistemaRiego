/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensaje;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson
 */
public class EnviarMSJ {
    public static void enviarMSJ(int tipo, String receptor, Agent agenteEmisor, String conversationID,
            String contenido, boolean contenidoString, Serializable contenidoObject){ //Para obtener el aid es el emisor
        
        ACLMessage acl = new ACLMessage(tipo); //Lang, Domain. Escogemos Lang acl
        AID aid = new AID();
        aid.setLocalName(receptor);
        acl.addReceiver(aid);
        acl.setSender(agenteEmisor.getAID());
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL); 
        acl.setConversationId(conversationID);
        
        if(contenidoString){
            acl.setContent(contenido);
        }else{
            try {
                acl.setContentObject(contenidoObject);
            } catch (IOException ex) {
                Logger.getLogger(EnviarMSJ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        agenteEmisor.send(acl);
    }
}
