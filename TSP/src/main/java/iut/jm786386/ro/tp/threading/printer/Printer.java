/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.threading.printer;

import iut.jm786386.ro.tp.IAlgorithm;
import iut.jm786386.ro.tp.fal.Writer;
import iut.jm786386.ro.tp.nodes.INode;
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
    
    public static final String LN_BRK = System.lineSeparator();
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\033[1;31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    
    public static void print(IAlgorithm a, String s, List<INode> nodes)
    {
        _buffer.put(a, s + LN_BRK);
        new Writer().write(s + printNodes(nodes), a.getName());
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
        return LN_BRK + "Execution time : " + Duration.between(past, now).toMillis() + "ms";
    }
    
    private static String printNodes(List<INode> list)
    {
        String nodes = LN_BRK;
        for (INode node : list)
        {
            nodes += node.toString()+ LN_BRK;
        }
        return nodes;
    }
}
