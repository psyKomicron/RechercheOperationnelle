/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro;

import java.util.List;

import iut.jm786386.ro.tp.IAlgorithm;
import iut.jm786386.ro.tp.fal.TSPReader;
import iut.jm786386.ro.tp.fal.resultcomparer.ResultsReader;
import iut.jm786386.ro.tp.fal.Writer;
import iut.jm786386.ro.tp.gps.coordinate.Coordinate;
import iut.jm786386.ro.tp.nodes.City;
import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.threading.Launcher;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.*;
import iut.jm786386.ro.tp.travellingsalesman.composed.TSP_Generic;
import iut.jm786386.ro.tp.travellingsalesman.composed.specific.TSP_Nearest_2OPT;
import iut.jm786386.ro.tp.travellingsalesman.composed.specific.TSP_Nearest_CS;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
            List<INode> data = TSPReader.read("C:\\Users\\julie\\Desktop\\Cloud\\GitHub\\RechercheOperationnelle\\villes.tsp");
            List<IAlgorithm> algos = fill();
            Launcher l = new Launcher(algos, data);
            l.launch();
        }
        catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        System.out.println("Computing results");
        try
        {
            ResultsReader reader = new ResultsReader(Writer.getUserLibDirectory());
            System.out.println(reader.compareResults());
        }
        catch (FileNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, "tsp res files not found :(", ex);
        }
    }
    
    public static List<IAlgorithm> fill()
    {
        List<IAlgorithm> algos = new java.util.ArrayList();
        /*--------------------------------------------*/
        //algos.add(new TSP_Crescent());
        //algos.add(new TSP_Nearest());
        //algos.add(new TSP_Nearest_NCS());
        //algos.add(new TSP_Nearest_CS());
        algos.add(new TSP_Nearest_2OPT());
        //algos.add(new TSP_Generic(new TSP_2OPT(), new TSP_NCS()));
        /*--------------------------------------------*/
        return algos;
    }
}
