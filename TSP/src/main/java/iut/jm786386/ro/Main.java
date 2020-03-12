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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Traveling Salesman Problem");
        Instant t = Instant.now();
        // Put code here to get execution time
        try {
            String path = 
                    "C:\\Users\\julie\\Documents\\NetBeansProjects\\villes.tsp";
            
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
