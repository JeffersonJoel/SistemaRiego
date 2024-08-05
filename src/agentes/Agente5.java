/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson
 */
public class Agente5 extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            //System.out.println(acl);
            
            double lista[];
            String temperaturaString="desconocido", humedadString="desconocido", uvString="desconocido";
            /*
            TEMPERATURA(C): baja(menor a 10), moderada(10-25), alta(mayor a 25)  | lista[0]
            HUMEDAD(%): baja(menor a 40), moderada(40-70), alta(mayor a 70)      | lista[1]
            UV(luvs): baja(menor a 16), moderada(16-30), altta(mayor a 30)       | lista[2]
            */
            try {
                lista = (double[]) acl.getContentObject();
                
                if(lista[0]<10){
                    temperaturaString = "baja";
                }else if((lista[0]>=10) && (lista[0]<=25)){
                    temperaturaString = "moderada";
                }else if(lista[0] > 25){
                    temperaturaString = "alta";
                }
                
                if(lista[1]<40){
                    humedadString = "baja";
                }else if((lista[1]>=40) && (lista[1]<=70)){
                    humedadString = "moderada";
                }else if(lista[1] > 70){
                    humedadString = "alta";
                }
                
                if(lista[2]<16){
                    uvString = "baja";
                }else if((lista[2]>=16) && (lista[2]<=30)){
                    uvString = "moderada";
                }else if(lista[2] > 30){
                    uvString = "alta";
                }
                
                if(("alta".equals(temperaturaString)) && ("baja".equals(humedadString)) && ("alta".equals(uvString))){
                    System.out.println("\nTemperatura "+temperaturaString+": "+lista[0]+" °C\t"
                            +"Humedad "+humedadString+": "+lista[1]+" %\t"
                            +"UV "+uvString+": "+lista[2]+" luvs"
                            +"\nPor tanto, HAY RIEGO");
                }else if(("alta".equals(temperaturaString)) && ("baja".equals(humedadString)) && ("baja".equals(uvString))){
                    System.out.println("\nTemperatura "+temperaturaString+": "+lista[0]+" °C\t"
                            +"Humedad "+humedadString+": "+lista[1]+" %\t"
                            +"UV "+uvString+": "+lista[2]+" luvs"
                            +"\nPor tanto, HAY RIEGO");
                }else if(("alta".equals(temperaturaString)) && ("alta".equals(humedadString)) && ("alta".equals(uvString))){
                    System.out.println("\nTemperatura "+temperaturaString+": "+lista[0]+" °C\t"
                            +"Humedad "+humedadString+": "+lista[1]+" %\t"
                            +"UV "+uvString+": "+lista[2]+" luvs"
                            +"\nPor tanto, HAY RIEGO");
                }else if(("moderada".equals(temperaturaString)) && ("baja".equals(humedadString)) && ("alta".equals(uvString))){
                    System.out.println("\nTemperatura "+temperaturaString+": "+lista[0]+" °C\t"
                            +"Humedad "+humedadString+": "+lista[1]+" %\t"
                            +"UV "+uvString+": "+lista[2]+" luvs"
                            +"\nPor tanto, HAY RIEGO");
                }else if(("moderada".equals(temperaturaString)) && ("alta".equals(humedadString)) && ("baja".equals(uvString))){
                    System.out.println("\nTemperatura "+temperaturaString+": "+lista[0]+" °C\t"
                            +"Humedad "+humedadString+": "+lista[1]+" %\t"
                            +"UV "+uvString+": "+lista[2]+" luvs"
                            +"\nPor tanto, HAY RIEGO");
                }else{
                    System.out.println("\nTemperatura "+temperaturaString+": "+lista[0]+" °C\t"
                            +"Humedad "+humedadString+": "+lista[1]+" %\t"
                            +"UV "+uvString+": "+lista[2]+" luvs"
                            +"\nPor tanto, NO HAY RIEGO POR AHORA");
                }
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
