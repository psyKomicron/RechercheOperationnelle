/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.threading;

import iut.jm786386.ro.tp.IAlgorithm;
import iut.jm786386.ro.tp.fal.TSPReader;
import iut.jm786386.ro.tp.fal.Writer;
import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import iut.jm786386.ro.tp.threading.printer.Printer;
import iut.jm786386.ro.tp.travellingsalesman.checker.NodeChecker;
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
            _nodes = TSPReader.read(filePath);
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
        System.out.println(Printer.printRed("Writing in : ") + Writer.getUserLibDirectory());
        if (_algorithms.size() == 1) start(0);
        else if (_algorithms.size() < 256)
        {
            _algorithms.forEach((a) -> {
                new Thread(() -> {
                    Instant now = Instant.now();
                    Route route = a.compute(_nodes, null);
                    Instant d = Instant.now();
                    NodeChecker checker = new NodeChecker(_nodes);
                    Printer.print(a,
                            a.getDescription()+Printer.LN_BRK+
                            route.toString()+" " +a.getClass().getCanonicalName()+Printer.LN_BRK+
                            Printer.printExecutionTime(now, d)+Printer.LN_BRK+
                            "Contains all nodes : "+checker.check(route.getNodes()), 
                            route.getNodes());
                    
                    System.out.println(a.getName() + " ended, results in file");
                }).start();
            });
        }
        else throw new UnknownError("Not enough threads to start all algorithm in parallel");
    }
    
    public void launch(IAlgorithm a)
    {
        new Thread(() -> {
                a.compute(_nodes, null);
                Instant now = Instant.now();
                    Route route = a.compute(_nodes, null);
                    Instant d = Instant.now();
                    NodeChecker checker = new NodeChecker(_nodes);
                    Printer.print(a,
                            a.getDescription()+Printer.LN_BRK+
                            route.toString()+" " +a.getClass().getCanonicalName()+Printer.LN_BRK+
                            Printer.printExecutionTime(now, d)+Printer.LN_BRK+
                            "Contains all nodes : "+checker.check(route.getNodes()), 
                            route.getNodes());
                    
                    System.out.println(a.getName() + " ended, results in file");
        }).start();
    }
    
    private void start(int index)
    {
        launch(_algorithms.get(index));
    }
}
