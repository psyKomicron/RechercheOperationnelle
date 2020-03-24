/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.algorithms;

import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import iut.jm786386.ro.tp.travellingsalesman.TSP_Algorithm;
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
        return "tsp_crescent";
    }

    @Override
    public String getDescription() {
        return "trivial resolving method (return the same nodes)";
    }
}
