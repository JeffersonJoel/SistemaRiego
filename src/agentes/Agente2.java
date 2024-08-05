/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import mensaje.EnviarMSJ;

/**
 *
 * @author Jefferson
 */
public class Agente2 extends Agent{
    
    double lista[] = new double[3];
    double temperatura=-5000, humedad=-5000, uv=-5000;
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            
            ACLMessage acl = blockingReceive();
            //System.out.println(acl);
            if(("De_AG1_a_AG2".equals(acl.getConversationId())) && (temperatura==-5000)){
                temperatura = Double.parseDouble(acl.getContent());
                lista[0] = temperatura;
            }else if(("De_AG4_a_AG2".equals(acl.getConversationId())) && (humedad==-5000)){
                humedad = Double.parseDouble(acl.getContent());
                lista[1] = humedad;
            }else if(("De_AG3_a_AG2".equals(acl.getConversationId())) && (uv==-5000)){
                uv = Double.parseDouble(acl.getContent());
                lista[2] = uv;
            }
            
            if((temperatura!=-5000) && (humedad!=-5000) && (uv!=-5000)){
                EnviarMSJ.enviarMSJ(ACLMessage.INFORM, "AG5", getAgent(), "De_AG2_a_AG5", null, false, lista);
                temperatura=-5000;
                humedad=-5000;
                uv=-5000;
            }
        }
        
    }
}
