/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.algorithms.genetic.comparator;

import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class RouteComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Route && o2 instanceof Route)
        {
            Route r1 = (Route) o1;
            Route r2 = (Route) o2;
            double d1 = computeDistance(r1.getNodes());
            double d2 = computeDistance(r2.getNodes());
            if (d1 > d2)
                return 1;
            if (d1 == d2)
                return 0;
            if (d2 > d1)
                return -1;
        }
        return 0;
    }
    
    private double computeDistance(List<INode> nodes)
    {
        double distance = 0.;
        INode currentNode = nodes.get(0);
        INode start = currentNode;
        for (INode node : nodes)
        {
            distance += currentNode.getValue().distanceTo(node.getValue());
            currentNode = node;
        }
        distance += currentNode.getValue().distanceTo(start.getValue());
        return distance;
    }
}
