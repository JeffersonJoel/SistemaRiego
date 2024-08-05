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
public class Agente3 extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            
            Random random = new Random();
            double uvObtenida = random.nextDouble()*46; //0.12345
            uvObtenida = Math.floor(uvObtenida*100) / 100; //funcion piso
            if(uvObtenida > 45){
                uvObtenida = 45;
            }
            String uv = String.valueOf(uvObtenida);
            //System.out.println("Soy "+getName()+" y el UV es: "+uv);
            
            EnviarMSJ.enviarMSJ(ACLMessage.INFORM, "AG2", getAgent(), "De_AG3_a_AG2", uv, true, null);
        }
        
    }
}
