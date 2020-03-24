/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.composed;

import iut.jm786386.ro.tp.IAlgorithm;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MonsieurJ
 */
public class TSP_Generic extends TSP_LocalSearch {

    public TSP_Generic(IAlgorithm f, IAlgorithm g)
    {
        super(f, g);
    }
    
    @Override
    public String getName() {
        return "tsp_generic";
    }

    @Override
    public String getDescription() {
        String desc = null;
        try
        {
            desc = getF().getDescription() + iut.jm786386.ro.tp.threading.colorconsole.Printer.LN_BRK + getG().getDescription();
        }
        catch (UnsupportedOperationException e)
        {
            Logger.getLogger(TSP_Generic.class.getName()).log(Level.SEVERE, null, e);
            desc = "tsp_generic";
        }
        return desc;
    }
    
}
