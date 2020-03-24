/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp;

import java.util.List;
import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;

/**
 *
 * @author MonsieurJ
 */
public interface IAlgorithm {
    
    Route compute(List<INode> nodes, INode start);
    
    String getName();
    
    String getDescription();
}
