/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman;

import iut.jm786386.ro.algorithme.Algorithm;
import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Crescent implements Algorithm
{

    @Override
    public Route compute(List<INode> nodes, INode start)
    {
        INode node = start == null ? nodes.get(0) : start;
        return new Route(nodes, computeDistance(nodes, node));
    }

    private double computeDistance(List<INode> nodes, INode start)
    {
        double distance = 0.;
        INode currentNode = start;
        for (INode node : nodes)
        {
            distance += currentNode.getValue().distanceTo(node.getValue());
            currentNode = node;
        }
        distance += currentNode.getValue().distanceTo(start.getValue());
        return distance;
    }
    
}
