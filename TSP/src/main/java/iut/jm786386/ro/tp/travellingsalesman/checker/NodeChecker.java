/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.checker;

import iut.jm786386.ro.tp.nodes.INode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class NodeChecker {
    private ArrayList<INode> _checks;
    
    public NodeChecker(List<INode> nodes)
    {
        _checks = new ArrayList(nodes);
    }
    
    public boolean check(List<INode> nodes)
    {
        if (_checks.size() > nodes.size()) return false;
        boolean res = true;
        for (INode n : _checks)
            if (!nodes.contains(n)) res = false;
        return res;
    }
}
