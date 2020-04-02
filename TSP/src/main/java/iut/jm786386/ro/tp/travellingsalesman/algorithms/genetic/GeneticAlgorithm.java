/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.algorithms.genetic;

import iut.jm786386.ro.tp.IAlgorithm;
import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import iut.jm786386.ro.tp.travellingsalesman.TSP_Algorithm;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_NearestRandom;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.genetic.comparator.RouteComparator;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author MonsieurJ
 */
public class GeneticAlgorithm extends TSP_Algorithm {
    private int _bound = 0;
    private int _popSize = 800;
    private int _maxGen = 100;
    private int _parentNum = 100;
    
    private SecureRandom _generator = new SecureRandom();
    
    private IAlgorithm _algo;
    
    @Override
    public String getName() {
        return GeneticAlgorithm.class.getName();
    }

    @Override
    public String getDescription() {
        return "genetic algorithm";
    }
    
    @Override
    public Route compute(List<INode> nodes, INode start) {
        _bound = nodes.size();
        // point de depart a null pour random le choix
        PriorityQueue<Route> queue = new PriorityQueue(new RouteComparator());
        for (int n = 0; n < _parentNum; n++) {
            queue.add(new TSP_NearestRandom().compute(nodes, null));
        }
        int repetition = 0;
        while (repetition < _maxGen)
        {
            ArrayList<Route> parents = new ArrayList();
            // choix des parents -> OK
            for (int i = 0; i < _parentNum/2; i++)
                parents.add(queue.poll());
            ArrayList<Route> temp = new ArrayList();
            for (int i = 0; i < _parentNum/2; i++)
                temp.add(queue.poll());
            Collections.shuffle(temp);
            parents.addAll(temp);
            
            // croisement de touts les parents
            int j = parents.size()-1;
            int i = 0;
            ArrayList<Route> children = new ArrayList();
            for (; i<parents.size() && j > i; i++, j--)
            {
                ArrayList<Route> routes = cross(parents.get(i), parents.get(j), rand());
                children.add(routes.get(0));
                children.add(routes.get(1));
            }
            
            ++repetition;
        }
        return new Route(nodes, computeDistance(nodes, start));
    }
    
    private ArrayList<Route> select(ArrayList<Route> nodes, int n)
    {
        // TODO here
        return null;
    }
    
    private ArrayList<Route> cross(Route father, Route mother, int crosspoint)
    {
        ArrayList<INode> fArray = (ArrayList) father.getNodes();
        ArrayList<INode> mArray = (ArrayList) mother.getNodes();
        for (int i=crosspoint; i < mArray.size()-crosspoint; i++)
        {
            INode res = fArray.set(i, mArray.get(i));
            mArray.set(i, res);
        }
        ArrayList<Route> routes = new ArrayList();
        routes.add(new Route(fArray, computeDistance(fArray, null)));
        routes.add(new Route(mArray, computeDistance(mArray, null)));
        return routes;
    }
    
    /**
     * Mutates children (from index y to collection size) with 2OPT fed with 
     * random glutton algorithm
     * @param children
     * @return 
     */
    private ArrayList<Route> mutate(ArrayList<Route> children, int y)
    {
        // TODO
        return null;
    }
    
    private Route birth(Route parent)
    {
        // TODO here
        return null;
    }
    
    private double fitness(Route node)
    {
        // TODO here
        return _generator.nextDouble();
    }
    
    private int rand()
    {
        return _generator.nextInt(_bound);
    }
}
