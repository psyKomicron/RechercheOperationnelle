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
            double bestDist = computeDistance(currentRoute, null);
            for (int i = 0; i < nodes.size(); i++) 
            {
                for (int j = 0; j < nodes.size(); j++) 
                {
                    if (j!=i-1 && j!=i && j!=i+1)
                    {
                        ArrayList<INode> newRoute = swap(currentRoute, i, j);
                        double newDist = computeDistance(newRoute, null);
                        if (newDist < bestDist)
                        {
                            end = false;
                            currentRoute = newRoute;
                        }
                    }
                }
            }
        }
        return new Route(currentRoute, computeDistance(currentRoute, null));
    }
    
    /**
     * Swap elements at index i and j and all elements in between.
     * Basically it reverse the path from i->j
     * @param nodes values
     * @param i first index
     * @param j second index
     * @return the arrayList with the elements swapped
     */
    public ArrayList<INode> swap(ArrayList<INode> nodes, int i, int j)
    {
        ArrayList<INode> copy = new ArrayList(nodes);
        INode element = copy.get(i);
        INode element2 = copy.get(j);
        copy.set(j, element);
        copy.set(i, element2);
        if (i+1!=j)
        {
            int i2 = Math.min(i, j)+1;
            int j2 = Math.max(i, j)-1;
            for (; i2 < j2; ++i2, --j2)
            {
                if (i2!=j2)
                {
                    INode s1 = copy.get(i2);
                    INode s2 = copy.get(j2);
                    copy.set(i2, s2);
                    copy.set(j2, s1);
                }
            }
        }
        return copy;
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
