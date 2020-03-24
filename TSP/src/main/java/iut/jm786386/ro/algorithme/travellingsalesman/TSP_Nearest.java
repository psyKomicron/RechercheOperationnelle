/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman;

import iut.jm786386.ro.algorithme.nodes.INode;
import java.util.List;
import iut.jm786386.ro.algorithme.nodes.Route;
import java.util.ArrayList;

/**
 * Class to create a round using the closest neighbor heuristic
 * @author MonsieurJ
 */
public class TSP_Nearest extends TSP_Algorithm {

    @Override
    public Route compute(List<INode> nodes, INode start) {
        ArrayList<INode> cities = new ArrayList();
        INode currentNode = start == null ? nodes.get(0) : start;
        cities.add(currentNode);
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
            currentNode = closestNode;
        }
        return new Route(cities, computeDistance(cities, null));
    }

    @Override
    public String getName() {
        return "tsp_nearestneighbor";
    }

    @Override
    public String getDescription() {
        return "nearest neighbor";
    }
    
}