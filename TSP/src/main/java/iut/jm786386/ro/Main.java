/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro;

import iut.jm786386.ro.algorithme.loader.TSPLoader;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Closest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MonsieurJ
 */
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\033[1;31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Traveling Salesman Problem");
        Instant t = Instant.now();
        // Put code here to get execution time
        try {
            String path = 
                    "C:\\Users\\julie\\Desktop\\Cloud\\GitHub\\RechercheOperationnelle\\villes.tsp";
            
            new TSP_Closest().compute(TSPLoader.read(path), null);
        } catch (IOException e) {
            try {
                String path = "C:\\Users\\jm786386\\Desktop\\villes.tsp";
                new TSP_Closest().compute(TSPLoader.read(path), null);
            } catch (IOException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        // End
        Instant finish = Instant.now();
        System.out.println("Execution time : " + Duration.between(t, finish).toMillis() + "ms");
    }
    
}
