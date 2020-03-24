/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Random extends TSP_Algorithm
{

    @Override
    public Route compute(List<INode> nodes, INode start)
    {
        List<INode> shuffled = nodes;
        Collections.shuffle(shuffled);
        return new Route(shuffled, computeDistance(nodes, start));
    }

    @Override
    public String getName() {
        return "tsp_random";
    }

    @Override
    public String getDescription() {
        return "random";
    }
    
}
