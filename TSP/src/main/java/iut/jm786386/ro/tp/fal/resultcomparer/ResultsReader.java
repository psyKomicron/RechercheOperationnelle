/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.fal.resultcomparer;

import iut.jm786386.ro.tp.threading.printer.Printer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MonsieurJ
 */
public class ResultsReader {
    private final String _workingDir;
    private final String _prefix = "tsp_";
    private final String _suffix = "txt";
    
    public ResultsReader(String path) throws FileNotFoundException
    {
        if (path.isBlank()) throw new FileNotFoundException("Path cannot be null");
        _workingDir = path;
    }
    
    public String compareResults()
    {
        File f = new File(_workingDir);
        File[] tspFiles = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(_prefix) && name.endsWith(_suffix);
            }
        });
        ArrayList<File> files = toArrayList(tspFiles);
        TreeMap<String, Double> distances = new TreeMap();
        try {
            distances = loadDistances(files);
        } catch (IOException ex) {
            Logger.getLogger(ResultsReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        distances.forEach((s, d) -> System.out.println(s + " -> " + d));
        
        String res = "Results :" + Printer.LN_BRK;
        for (Map.Entry<String, Double> entry : distances.entrySet())
        {
            res += Printer.printGreen(entry.getValue().toString()+"km") + " using " + Printer.printGreen(entry.getKey()) + " class" + Printer.LN_BRK;
        }
        res += Printer.LN_BRK + "Best algorithm : " + distances.firstKey();
        return res;
    }

    private ArrayList<File> toArrayList(File[] tspFiles) {
        ArrayList<File> files = new ArrayList<>();
        for (File tspFile : tspFiles)
            files.add(tspFile);
        return files;
    }

    private TreeMap<String, Double> loadDistances(ArrayList<File> files) throws IOException {
        TreeMap<String, Double> distances = new TreeMap();
        for (File file : files)
        {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = br.readLine()) != null) 
                {
                    if (line.startsWith("Total distance"))
                    {
                        String[] splitLine = line.split(" ");
                        try
                        {
                            double d = Double.valueOf(splitLine[3]);
                            String className = splitLine[4];
                            distances.put(className, d);
                        }
                        catch (NumberFormatException ex)
                        {
                            Logger.getLogger(ResultsReader.class.getName()).log(Level.SEVERE, "could not convert string to double", ex);
                        }
                    }
                }
            }
        }
        return distances;
    }
}
