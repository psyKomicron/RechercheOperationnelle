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
     *
     * @return
     */
    Coordinate getValue();
     
    /**
     *
     * @return
     */
    String getName();
}
