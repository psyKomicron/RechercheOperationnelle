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
public class City implements INode {
    private Coordinate _coor;
    private String _name;
    
    public City(Coordinate coor, String name)
    {
        _coor = coor;
        _name = name;
    }
    
    @Override
    public Coordinate getValue() { return _coor; }
    
    @Override
    public String getKey() { return _name; }
    
    public String toString()
    {
        return _name + "\t" + _coor.toString();
    }

    @Override
    public double distanceTo(INode node) {
        return getValue().distanceTo(node.getValue());
    }

    @Override
    public void swapInBetween(List<INode> nodes, int index1, int index2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
