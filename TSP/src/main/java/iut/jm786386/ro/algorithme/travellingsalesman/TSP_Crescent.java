/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman;

import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import java.util.List;
/**
 *
 * @author MonsieurJ
 */
public class TSP_Crescent extends TSP_Algorithm
{

    @Override
    public Route compute(List<INode> nodes, INode start)
    {
        INode node = start == null ? nodes.get(0) : start;
        return new Route(nodes, super.computeDistance(nodes, node));
    }

    @Override
    public String getName() {
        return "TSP_Crescent";
    }
}
