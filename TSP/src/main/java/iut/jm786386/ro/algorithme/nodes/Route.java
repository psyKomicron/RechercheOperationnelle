/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.nodes;

import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class Route
{
    List<INode> _nodes;
    double _distance;
    
    public Route(List<INode> nodes, double distance)
    {
        _nodes = nodes;
        _distance = distance;
    }
    
    public List<INode> getNodes()
    {
        return _nodes;
    }

    public double getDistance()
    {
        return _distance;
    }
    
    public String toString()
    {
        return "Total distance : " + _distance;
    }
}
