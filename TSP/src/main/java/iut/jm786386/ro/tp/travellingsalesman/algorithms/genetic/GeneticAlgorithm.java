/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut.jm786386.ro.tp.travellingsalesman.algorithms.genetic;

import iut.jm786386.ro.tp.nodes.INode;
import iut.jm786386.ro.tp.nodes.Route;
import iut.jm786386.ro.tp.travellingsalesman.TSP_Algorithm;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_2OPT;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_NearestRandom;
import iut.jm786386.ro.tp.travellingsalesman.algorithms.TSP_Random;
import iut.jm786386.ro.tp.travellingsalesman.composed.TSP_Generic;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MonsieurJ
 */
public class GeneticAlgorithm extends TSP_Algorithm {
    private SecureRandom _generator = new SecureRandom();
    private int _bound = 0;

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
        ArrayList<INode> currentGen = (ArrayList) new TSP_NearestRandom().compute(nodes, null).getNodes();
        int r = 3600;
        while (r > 0)
        {
            int nParents = rand();
            ArrayList<INode> parents = select(currentGen, nParents);
            ArrayList<INode> children = new ArrayList();
            // faire des enfants
            for (int i = 0; i < nParents; i++) {
                INode[] honeyMoon = cross(currentGen.get(rand()), currentGen.get(rand()));
                children.add(honeyMoon[0]);
                children.add(honeyMoon[1]);
            }
            int y;
            while ((y = rand()) >= nParents){// generer un random inferieur strictement a nParents
            }
            // muter les enfants de y a N
            mutate(children, y);
            // choisir les candidats de la gen suivante
            ArrayList<INode> oldgen = new ArrayList(parents); // oldGen = children + parents
            oldgen.addAll(children);
            ArrayList<INode> newgen = new ArrayList(); // collection pour les meilleurs sujets
            for (int i = 0; i < nParents; i++) {
                INode e = null;
                double fitness = 0.;
                for (INode iNode : oldgen)
                    if (fitness(iNode) > fitness)
                        e = iNode;
                newgen.add(e);
            }
            currentGen = newgen;
            --r;
        }
        return new Route(currentGen, computeDistance(currentGen, null));
    }
    
    private ArrayList<INode> select(ArrayList<INode> nodes, int n)
    {
        // TODO here
        return null;
    }
    
    private INode[] cross(INode father, INode mother)
    {
        // TODO here
        return null;
    }
    
    /**
     * Mutates children (from index y to collection size) with 2OPT fed with 
     * random glutton algorithm
     * @param children
     * @return 
     */
    private ArrayList<INode> mutate(ArrayList<INode> children, int y)
    {
        TSP_Generic ls = new TSP_Generic(new TSP_Random(), new TSP_2OPT());
        ArrayList<INode> chosenChildren = new ArrayList();
        for (int i = y; i < children.size(); i++) {
            chosenChildren.add(children.get(i));
        }
        ArrayList<INode> mutatedChilren = (ArrayList<INode>) ls.compute(chosenChildren, null).getNodes();
        return mutatedChilren;
    }
    
    private INode birth(INode parent)
    {
        // TODO here
        return null;
    }
    
    private double fitness(INode node)
    {
        // TODO here
        return _generator.nextDouble();
    }
    
    private int rand()
    {
        return _generator.nextInt(_bound);
    }
}
