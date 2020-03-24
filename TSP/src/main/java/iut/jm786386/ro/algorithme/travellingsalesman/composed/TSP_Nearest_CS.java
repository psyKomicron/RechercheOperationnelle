/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman.composed;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_Nearest;
import iut.jm786386.ro.algorithme.travellingsalesman.TSP_CS;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Nearest_CS extends TSP_LocalSearch {
    
    public TSP_Nearest_CS()
    {
        super(new TSP_CS(), new TSP_Nearest());
    }
    
    @Override
    public Route compute(List<INode> nodes, INode start) {
        return super.compute(nodes, start);
    }

    @Override
    public String getName() {
        return "tsp_nearestlocal";
    }

    @Override
    public String getDescription() {
        return "nearest neighbor enhanced with consecutive swapping";
    }
    
}
