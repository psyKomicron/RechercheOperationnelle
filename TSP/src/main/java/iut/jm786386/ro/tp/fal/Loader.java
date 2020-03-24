/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.fal;

import iut.jm786386.ro.tp.gps.coordinate.Coordinate;
import iut.jm786386.ro.tp.nodes.City;
import iut.jm786386.ro.tp.nodes.INode;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class Loader {
    public static List<INode> read(String filePath) throws FileNotFoundException, IOException
    {
        ArrayList<INode> cities = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitedLine = line.split(" ");
                if (splitedLine[1].contains(",") || splitedLine[2].contains(","))
                {
                    splitedLine[1] = splitedLine[1].replace(",", ".");
                    splitedLine[2] = splitedLine[2].replace(",", ".");
                }
                double lat = Double.valueOf(splitedLine[1]);
                double lon = Double.valueOf(splitedLine[2]);
                cities.add(new City(new Coordinate(lat, lon), splitedLine[0]));
            }
        }
        return cities;
    }
}
