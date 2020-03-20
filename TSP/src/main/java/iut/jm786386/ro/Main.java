/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro;

import iut.jm786386.ro.algorithme.IAlgorithm;
import iut.jm786386.ro.algorithme.threading.Launcher;
import iut.jm786386.ro.algorithme.loader.TSPLoader;
import iut.jm786386.ro.algorithme.nodes.City;
import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Closest;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Crescent;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_LocalSearch;
import iut.jm786386.ro.algorithme.travellingsalesman.composed.TSP_ClosestLocalSearch;
import iut.jm786386.ro.algorithme.threading.colorconsole.Printer;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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
        // Put code here to get execution time
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
            while (!(Printer.getEntries() >= 3)) { System.out.println(Printer.getEntries() >= 3);}
            Printer.free();
            System.out.println("end");
            /*
            
            Instant now = Instant.now();
            
            Route crescent = new TSP_Crescent().compute(data, null);
            Printer.printExecutionTime(now, Instant.now());
            System.out.println(Printer.printGreen("TSP crescent : ") + crescent.toString());
            
            now = Instant.now();
            
            Route closest = new TSP_Closest().compute(data, null);
            Printer.printExecutionTime(now, Instant.now());
            System.out.println(Printer.printGreen("TSP closest : ") + closest.toString());
            closest.getNodes().forEach(v -> {
                System.out.println(v.getName());
            });
            
            now = Instant.now();
            
            Route localSearch = new TSP_LocalSearch().compute(closest.getNodes(), null);
            Printer.printExecutionTime(now, Instant.now());
            System.out.println(Printer.printGreen("TSP local search : ") + localSearch.toString());
            localSearch.getNodes().forEach(v -> {
                System.out.println(v.getName());
            });
        } */
        }   
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
