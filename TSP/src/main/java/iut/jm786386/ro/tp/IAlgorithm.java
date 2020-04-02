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
 * Interface des algorithmes du voyageur de commerce
 * @author MonsieurJ
 */
public interface IAlgorithm {
    
    /**
     * Calcule (via une heuristique) la tournee la plus courte
     * parmis les noeuds.
     * @param nodes listes de noeud de la tournee
     * @param start noeud ou l'algorithme commence
     * @return Route, objet contenant la liste des noeuds et la distance totale de la tournee
     */
    Route compute(List<INode> nodes, INode start);
    
    /**
     * Donne le nom de l'algorithme. Correspond au nom du fichier
     * dans lequel le resultat de l'algo va etre ecrit
     * @return 
     */
    String getName();
    
    /**
     * Donne la description de l'algorithme.
     * @return 
     */
    String getDescription();
}
