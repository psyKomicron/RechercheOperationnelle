/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.algorithme.gps.coordinate;

/**
 *
 * @author MonsieurJ
 */
public class Coordinate {
    private double _latitude;
    private double _longitude;
    
    public Coordinate(double x, double y)
    {
        _latitude = x;
        _longitude = y;
    }
    
    public double getLongitude() { return _longitude; }
    
    public double getLatitude() { return _latitude; }
    
    public double distanceTo(Coordinate coor)
    {
        double phiA = Math.toRadians(_latitude);
        double phiB = Math.toRadians(coor.getLatitude());
        double dPhi = Math.toRadians(coor.getLatitude() - _latitude);
        double dLambda = Math.toRadians(coor.getLongitude() - _longitude);
        double a = Math.sin(dPhi / 2) * Math.sin(dPhi / 2) +
                Math.cos(phiA) * Math.cos(phiB) *
                Math.sin(dLambda / 2) * Math.sin(dLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return c * 6371;
    }
    
    @Override
    public String toString()
    {
        return "(" + _longitude + ", " + _latitude + ")";
    }
}
