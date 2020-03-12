/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman;

import iut.jm786386.ro.Main;
import iut.jm786386.ro.algorithme.nodes.INode;
import java.util.List;
import iut.jm786386.ro.algorithme.Algorithm;
import java.util.ArrayList;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Closest implements Algorithm {

    @Override
    public List<INode> compute(List<INode> nodes, INode start) {
        ArrayList<INode> cities = new ArrayList();
        INode currentNode = start == null ? nodes.get(0) : start;
        cities.add(currentNode);
        double totalDistance = 0;
        while (!cities.containsAll(nodes))
        {
            double delta = Double.MAX_VALUE;
            INode closestNode = null;
            for (var n : nodes)
            {
                double distance = currentNode.getValue().distanceTo(n.getValue());
                if (distance < delta && distance != 0. && !cities.contains(n))
                {
                    delta = distance;
                    closestNode = n;
                }
            }
            cities.add(closestNode);
            System.out.println(
                    "Node " + Main.ANSI_GREEN + currentNode.getName() + Main.ANSI_RESET 
                    + "\tNode " + Main.ANSI_GREEN + closestNode.getName() + Main.ANSI_RESET
                    + ", distance in-between : " + Main.ANSI_GREEN + delta + Main.ANSI_RESET);
            currentNode = closestNode;
            totalDistance += delta;
        }
        System.out.println("\tTotal distance : " + Main.ANSI_GREEN + totalDistance + Main.ANSI_RESET);
        return cities;
    }
    
}
