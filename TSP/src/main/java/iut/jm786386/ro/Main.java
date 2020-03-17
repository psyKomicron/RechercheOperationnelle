/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro;

import iut.jm786386.ro.algorithme.loader.TSPLoader;
import iut.jm786386.ro.algorithme.nodes.City;
import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Closest;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Crescent;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
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
        // Put code here to get execution time
        try {
            List<INode> data = TSPLoader.read("C:\\Users\\julie\\Desktop\\Cloud\\GitHub\\RechercheOperationnelle\\villes.tsp");
            
            Instant now = Instant.now();
            
            
            Route r = new TSP_Crescent().compute(data, null);
            Main.printExecutionTime(now, Instant.now());
            
            now = Instant.now();
            Route r2 = new TSP_Closest().compute(data, null);
            Main.printExecutionTime(now, Instant.now());
            
            System.out.println(Main.printGreen("TSP crescent : ") + r.toString());
            System.out.println(Main.printGreen("TSP closest : ") + r2.toString());
        } 
        catch (IOException e) {
            try {
                String path = "C:\\Users\\jm786386\\Desktop\\villes.tsp";
                new TSP_Closest().compute(TSPLoader.read(path), null);
            } catch (IOException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        // End
    }
    
    public static String printRed(String s)
    {
        return Main.ANSI_RED + s + Main.ANSI_RESET;
    }
    
    public static String printGreen(String s)
    {
        return Main.ANSI_GREEN + s + Main.ANSI_RESET;
    }
    
    public static String printBlue(String s)
    {
        return Main.ANSI_BLUE + s + Main.ANSI_RESET;
    }
    
    public static String printColor(String s, String color)
    {
        return color + s + Main.ANSI_RESET;
    }
    
    public static void printExecutionTime(Instant past, Instant now)
    {
        System.out.println("Execution time : " + Duration.between(past, now).toMillis() + "ms");
    }
}
