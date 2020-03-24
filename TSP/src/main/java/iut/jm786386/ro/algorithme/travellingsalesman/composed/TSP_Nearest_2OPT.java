/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman.composed;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_2OPT;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Algorithm;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_LS_SWAP;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Nearest;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Nearest_2OPT extends TSP_Algorithm {

    @Override
    public Route compute(List<INode> nodes, INode start) {
        return new TSP_2OPT().compute(new TSP_Nearest().compute(nodes, start).getNodes(), start);
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
