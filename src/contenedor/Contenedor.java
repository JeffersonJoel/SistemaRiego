/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenedor;

import agentes.Agente1;
import agentes.Agente2;
import agentes.Agente3;
import agentes.Agente4;
import agentes.Agente5;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson
 */
public class Contenedor {
    AgentContainer contenedorAgentes;
    
    public void crearContenedor(){
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        runtime.setCloseVM(true);
        Profile profile = new ProfileImpl(null, 1099, null);
        contenedorAgentes = runtime.createMainContainer(profile);
        iniciarAgentes();
    }
    
    private void iniciarAgentes(){
        try {
            contenedorAgentes.createNewAgent("AG5", Agente5.class.getName(), null).start(); //Recibe object, compara y decide si regar o no 
            contenedorAgentes.createNewAgent("AG2", Agente2.class.getName(), null).start(); //Recibe parametros, convierte a object y lo manda a AG5
            contenedorAgentes.createNewAgent("AG3", Agente3.class.getName(), null).start(); //Envia UV (0 a 45)luvs a AG2
            contenedorAgentes.createNewAgent("AG4", Agente4.class.getName(), null).start(); //Envia humedad (25 a 98)% AG2
            contenedorAgentes.createNewAgent("AG1", Agente1.class.getName(), null).start(); //Envia temperatura (0 a 35)C AG2
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}