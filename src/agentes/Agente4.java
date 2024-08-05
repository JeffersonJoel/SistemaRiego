/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import java.util.Random;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import mensaje.EnviarMSJ;

/**
 *
 * @author Jefferson
 */
public class Agente4 extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            
            Random random = new Random();
            int humedadObtenida = random.nextInt(74)+25;
            String humedad = String.valueOf(humedadObtenida);
            //System.out.println("Soy "+getName()+" y la humedad es: "+humedad);
            
            EnviarMSJ.enviarMSJ(ACLMessage.INFORM, "AG2", getAgent(), "De_AG4_a_AG2", humedad, true, null);
        }
        
    }
}
