/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman;

import iut.jm786386.ro.algorithme.nodes.INode;
import java.util.List;
import iut.jm786386.ro.algorithme.IAlgorithm;

/**
 *
 * @author MonsieurJ
 */
public abstract class TSP_Algorithm implements IAlgorithm
{
    protected double computeDistance(List<INode> nodes, INode start)
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
