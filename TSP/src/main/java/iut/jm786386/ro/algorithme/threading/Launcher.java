/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.threading;

import iut.jm786386.ro.algorithme.IAlgorithm;
import iut.jm786386.ro.algorithme.fal.Loader;
import iut.jm786386.ro.algorithme.nodes.INode;
import iut.jm786386.ro.algorithme.nodes.Route;
import iut.jm786386.ro.algorithme.threading.colorconsole.Printer;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MonsieurJ
 */
public class Launcher {
    private List<IAlgorithm> _algorithms;
    private List<INode> _nodes;
    
    public Launcher(List<IAlgorithm> algos, String filePath) 
    {
        _algorithms = algos;
        try {
            _nodes = Loader.read(filePath);
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Launcher(List<IAlgorithm> algos, List<INode> nodes)
    {
        _algorithms = algos;
        _nodes = nodes;
    }
    
    public void launch()
    {
        if (_algorithms.size() == 1) start(0);
        else if (_algorithms.size() < 256)
        {
            _algorithms.forEach((a) -> {
                new Thread(() -> {
                    Instant now = Instant.now();
                    Route route = a.compute(_nodes, null);
                    Instant d = Instant.now();
                    Printer.print(a, a.getDescription()+ Printer.LN_BRK + route.toString() + Printer.printExecutionTime(now, d), route.getNodes());
                }).start();
            });
        }
        else throw new UnknownError("Not enough threads to start all algorithm in parallel");
    }
    
    public void launch(IAlgorithm a)
    {
        new Thread(() -> {
                a.compute(_nodes, null);
        }).start();
    }
    
    private void start(int index)
    {
        _algorithms.get(index).compute(_nodes, null);
    }
}
