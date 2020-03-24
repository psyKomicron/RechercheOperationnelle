/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman.composed;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Algorithm;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_LS_SWAPALL;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Nearest;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Nearest_LS_SWAPALL extends TSP_Algorithm {

    @Override
    public Route compute(List<INode> nodes, INode start) {
        return new TSP_LS_SWAPALL().compute(new TSP_Nearest().compute(nodes, start).getNodes(), start);
    }

    @Override
    public String getName() {
        return "tsp_nearestswap_all";
    }

    @Override
    public String getDescription() {
        return "local search using non-consecutive node swapping & result from nearest neighbor algo";
    }
    
}
