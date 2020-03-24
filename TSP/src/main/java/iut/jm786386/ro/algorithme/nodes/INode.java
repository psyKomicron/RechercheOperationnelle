/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.nodes;

import iut.jm786386.ro.algorithme.gps.coordinate.Coordinate;

/**
 *
 * @author MonsieurJ
 */
public interface INode {

    /**
     * Returns the value of the node. Because we are currently dealing with cities
     * the return value type is Coordinate.
     * @return the value of the INode
     */
    Coordinate getValue();
     
    /**
     * Returns the name of the node, can be empty or null
     * @return the name of a string literal representing a name
     * for the node.
     */
    String getName();
    
    /**
     * Calculate the theoretical distance between 2 nodes (real distance or cost).
     * @param node 
     * @return the distance cost
     */
    double distanceTo(INode node);
}
