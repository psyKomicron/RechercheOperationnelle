/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.composed.specific;

import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_2OPT;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_Nearest;
import iut.jm786386.ro.tp.travellingsalesman.composed.TSP_LocalSearch;
import java.util.List;

/**
 * Calcule une recherche locale avec 2OPT et algo du plus
 * proche voisin
 * @author MonsieurJ
 */
public class TSP_Nearest_2OPT extends TSP_LocalSearch {
    
    public TSP_Nearest_2OPT()
    {
        super(new TSP_2OPT(), new TSP_Nearest());
    }

    @Override
    public Route compute(List<INode> nodes, INode start) {
        return super.compute(nodes, start);
    }

    @Override
    public String getName() {
        return "tsp_2opt";
    }

    @Override
    public String getDescription() {
        return "nearest neighbor with 2 OPT local search";
    }
    
}
