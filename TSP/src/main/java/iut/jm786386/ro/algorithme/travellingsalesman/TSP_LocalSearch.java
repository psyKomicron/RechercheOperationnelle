/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_LocalSearch extends TSP_Algorithm {

    @Override
    public Route compute(List<INode> nodes, INode start) {
        ArrayList<INode> currentRoute = new ArrayList(nodes);
        boolean end = false;
        while (!end)
        {
            ArrayList<INode> temp = new ArrayList(currentRoute);
            for (int i = 0; i < currentRoute.size(); i++) 
            {
                ArrayList<INode> neighborRoute = new ArrayList(temp);
                if ((i + 1) == currentRoute.size())
                    Collections.swap(neighborRoute, i, 0);
                else
                    Collections.swap(neighborRoute, i, i + 1);
                if (computeDistance(neighborRoute, null) < computeDistance(currentRoute, null))
                    currentRoute = neighborRoute;
            }
            end = currentRoute.equals(temp);
        }
        return new Route(currentRoute, computeDistance(currentRoute, null));
    }

    @Override
    public String getName() {
        return "TSP_LocalSearch";
    }
}
