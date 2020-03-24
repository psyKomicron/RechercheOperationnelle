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
public class TSP_2OPT extends TSP_Algorithm {

    @Override
    public Route compute(List<INode> nodes, INode start) {
        ArrayList<INode> currentRoute = new ArrayList(nodes);
        boolean end = false;
        while (!end)
        {
            end = true;
            for (int i = 0; i < currentRoute.size() - 1; i++) 
            {
                for (int j = 0; j < currentRoute.size() - 1; j++) 
                {
                    if ( (j != i-1) && (j != i) && (j != i+1) )
                    {
                        double d1 = currentRoute.get(i).distanceTo(currentRoute.get(i + 1)) + currentRoute.get(j).distanceTo(currentRoute.get(j + 1));
                        double d2 = currentRoute.get(i).distanceTo(currentRoute.get(j)) + currentRoute.get(i + 1).distanceTo(currentRoute.get(j + 1));
                        if (d1 > d2)
                        {
                            end = false;
                            Collections.swap(currentRoute, i + 1, j);
                        }
                    }
                }
            }
        }
        return new Route(currentRoute, computeDistance(currentRoute, null));
    }
    
    

    @Override
    public String getName() {
        return "2OPT";
    }

    @Override
    public String getDescription() {
        return "2OPT";
    }
    
}
