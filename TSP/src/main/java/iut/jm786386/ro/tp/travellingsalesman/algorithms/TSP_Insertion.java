/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.algorithms;

import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import java.util.List;
import iut.jm786386.ro.tp.IAlgorithm;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Insertion implements IAlgorithm
{

    @Override
    public Route compute(List<INode> nodes, INode start)
    {
        return null;
    }

    @Override
    public String getName() {
        return "tsp_insertion";
    }

    @Override
    public String getDescription() {
        return "insertion method";
    }
    
}
