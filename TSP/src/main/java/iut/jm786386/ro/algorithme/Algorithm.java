/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme;

import java.util.List;
import iut.jm786386.ro.algorithme.nodes.INode;

/**
 *
 * @author MonsieurJ
 */
public interface Algorithm {
    
    List<INode> compute(List<INode> nodes, INode start);
    
}
