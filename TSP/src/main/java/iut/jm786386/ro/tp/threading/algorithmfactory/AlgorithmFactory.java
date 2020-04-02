/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.threading.algorithmfactory;

import iut.jm786386.ro.tp.IAlgorithm;
import java.io.File;

/**
 *
 * @author MonsieurJ
 */
public class AlgorithmFactory {
    
    public static IAlgorithm create(String name)
    {
        File f = new File("./");
        System.out.println(f.getAbsolutePath());
        return null;
    }
}
