/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.travellingsalesman.composed;

import iut.jm786386.ro.algorithme.IAlgorithm;
import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public abstract class TSP_LocalSearch implements IAlgorithm {
    private IAlgorithm _f;
    private IAlgorithm _g;

    protected TSP_LocalSearch(IAlgorithm f, IAlgorithm g)
    {
        _f = f;
        _g = g;
    }
    
    /**
     * Compute f(g)
     * @param nodes
     * @param start
     * @return the new computed route
     */
    @Override
    public Route compute(List<INode> nodes, INode start) {
        return _f.compute(_g.compute(nodes, start).getNodes(), start);
    }
}
