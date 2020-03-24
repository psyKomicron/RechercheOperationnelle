/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman.composed;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_NCS;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Nearest_NCS extends TSP_LocalSearch {

    public TSP_Nearest_NCS()
    {
        super(new TSP_NCS(), new TSP_NCS());
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
