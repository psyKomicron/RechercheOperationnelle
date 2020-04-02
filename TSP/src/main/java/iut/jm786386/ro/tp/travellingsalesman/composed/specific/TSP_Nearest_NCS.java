/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.composed.specific;

import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_NCS;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_Nearest;
import iut.jm786386.ro.tp.travellingsalesman.composed.TSP_LocalSearch;
import java.util.List;

/**
 * Recherche locale avec swap non-consecutif et algo du plus
 * proche voisin
 * @author MonsieurJ
 */
public class TSP_Nearest_NCS extends TSP_LocalSearch {

    public TSP_Nearest_NCS()
    {
        super(new TSP_NCS(), new TSP_Nearest());
    }
    
    @Override
    public Route compute(List<INode> nodes, INode start) {
        return super.compute(nodes, start);
    }

    @Override
    public String getName() {
        return "tsp_nonconsecutive_swap";   
    }

    @Override
    public String getDescription() {
        return "local search using non-consecutive node swapping & result from nearest neighbor algo";
    }
    
}
