/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro;

import iut.jm786386.ro.algorithme.IAlgorithm;
import iut.jm786386.ro.algorithme.threading.Launcher;
import iut.jm786386.ro.algorithme.fal.TSPLoader;
import iut.jm786386.ro.algorithme.fal.TSPWriter;
import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Closest;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Crescent;
import iut.jm786386.ro.algorithme.travellingsalesman.composed.TSP_ClosestLocalSearch;
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
            // TSPLoader.read("C:\\Users\\julie\\Desktop\\Cloud\\GitHub\\RechercheOperationnelle\\villes_nom.txt");
            // TSPLoader.read("C:\\Users\\julie\\Desktop\\Cloud\\GitHub\\RechercheOperationnelle\\villes.tsp");
            List<INode> data = TSPLoader.read("C:\\Users\\julie\\Desktop\\Cloud\\GitHub\\RechercheOperationnelle\\villes.tsp");
            ArrayList<IAlgorithm> algos = new ArrayList();
            // add algorithms to compute here
            algos.add(new TSP_Crescent());
            algos.add(new TSP_Closest());
            algos.add(new TSP_ClosestLocalSearch());
            
            Launcher l = new Launcher(algos, data);
            l.launch();
        }   
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
