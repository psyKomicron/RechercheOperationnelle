/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.nodes;

import iut.jm786386.ro.tp.gps.coordinate.Coordinate;
import java.util.List;

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
    String getKey();
    
    /**
     * Calculate the theoretical distance between 2 nodes (real distance or cost).
     * @param node 
     * @return the distance cost
     */
    double distanceTo(INode node);
    
    /**
     * Swap the node at index1 with node at index2, and every node in between
     * the two
     * @param nodes
     * @param index1
     * @param index2 
     */
    void swapInBetween(List<INode> nodes, int index1, int index2);
}
