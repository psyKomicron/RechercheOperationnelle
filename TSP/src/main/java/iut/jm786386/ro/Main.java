/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro;

import iut.jm786386.ro.algorithme.IAlgorithm;
import iut.jm786386.ro.algorithme.threading.Launcher;
import iut.jm786386.ro.algorithme.fal.Loader;
import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Nearest;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Crescent;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_LS_SWAPALL;
import iut.jm786386.ro.algorithme.travellingsalesman.composed.TSP_Nearest_2OPT;
import iut.jm786386.ro.algorithme.travellingsalesman.composed.TSP_Nearest_LS_SWAP;
import iut.jm786386.ro.algorithme.travellingsalesman.composed.TSP_Nearest_LS_SWAPALL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MonsieurJ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Traveling Salesman Problem");
        try {
            List<INode> data = Loader.read("C:\\Users\\julie\\Desktop\\Cloud\\GitHub\\RechercheOperationnelle\\villes.tsp");
            ArrayList<IAlgorithm> algos = fill();
            Launcher l = new Launcher(algos, data);
            l.launch();
        }
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<IAlgorithm> fill()
    {
        ArrayList<IAlgorithm> algos = new ArrayList();
        /*--------------------------------------------*/
        //algos.add(new TSP_Crescent());
        //algos.add(new TSP_Nearest());
        algos.add(new TSP_Nearest_LS_SWAP());
        algos.add(new TSP_Nearest_LS_SWAPALL());
        algos.add(new TSP_Nearest_2OPT());
        /*--------------------------------------------*/
        return algos;
    }
}
