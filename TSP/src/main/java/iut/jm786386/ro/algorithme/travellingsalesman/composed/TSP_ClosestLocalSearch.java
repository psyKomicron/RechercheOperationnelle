/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman.composed;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Algorithm;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Closest;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_LocalSearch;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_ClosestLocalSearch extends TSP_Algorithm {
    
    @Override
    public Route compute(List<INode> nodes, INode start) {
        return new TSP_LocalSearch().compute(new TSP_Closest().compute(nodes, start).getNodes(), start);
    }

    @Override
    public String getName() {
        return "TSP_Closest + LocalSearch";
    }
    
}
