/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.threading.colorconsole;

import iut.jm786386.ro.algorithme.IAlgorithm;
import iut.jm786386.ro.algorithme.fal.TSPWriter;
import iut.jm786386.ro.algorithme.nodes.INode;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class Printer {
    private static HashMap<IAlgorithm, String> _buffer = new HashMap();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\033[1;31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static int getEntries() { return _buffer.size(); }
    
    public static String getEntry(IAlgorithm key)
    {
        return _buffer.get(key);
    }
    
    public static void free()
    {
        _buffer.forEach((a, s) -> 
        {
            System.out.println(a + ", " + s);
        });
    }
    
    public static void print(IAlgorithm a, String s, List<INode> nodes)
    {
        _buffer.put(a, s);
        
        new TSPWriter().write(s + printNodes(nodes), a.getName());
    }
    
    public static String printRed(String s)
    {
        return ANSI_RED + s + ANSI_RESET;
    }
    
    public static String printGreen(String s)
    {
        return ANSI_GREEN + s + ANSI_RESET;
    }
    
    public static String printBlue(String s)
    {
        return ANSI_BLUE + s + ANSI_RESET;
    }
    
    public static String printColor(String s, String color)
    {
        return color + s + ANSI_RESET;
    }
    
    public static String printExecutionTime(Instant past, Instant now)
    {
        return "\nExecution time : " + Duration.between(past, now).toMillis() + "ms";
    }
    
    private static String printNodes(List<INode> list)
    {
        String nodes = "\n";
        for (INode node : list)
        {
            nodes += node.getName() + "\n";
        }
        return nodes;
    }
}
