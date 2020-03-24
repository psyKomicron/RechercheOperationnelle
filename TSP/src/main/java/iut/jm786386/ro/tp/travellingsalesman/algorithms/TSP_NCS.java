/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.algorithms;

import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import iut.jm786386.ro.tp.travellingsalesman.TSP_Algorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class TSP_NCS extends TSP_Algorithm {

    @Override
    public Route compute(List<INode> nodes, INode start) {
        ArrayList<INode> currentRoute = new ArrayList(nodes);
        boolean end = false;
        while (!end)
        {
            ArrayList<INode> temp = new ArrayList(currentRoute);
            for (int i = 0; i < currentRoute.size(); i++) 
            {
                for (int j = i+1; j < currentRoute.size(); j++) 
                {
                    ArrayList<INode> neighborRoute = new ArrayList(temp);
                    Collections.swap(neighborRoute, i, j);
                    if (computeDistance(neighborRoute, null) < computeDistance(currentRoute, null))
                        currentRoute = neighborRoute;
                }
            }
            end = currentRoute.equals(temp);
        }
        return new Route(currentRoute, computeDistance(currentRoute, null));
    }

    @Override
    public String getName() {
        return "tsp_ncs";
    }

    @Override
    public String getDescription() {
        return "local search with unconsecutive node swapping";
    }
}
