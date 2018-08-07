package test;

import org.junit.Assert;
import part1_simulation.SimulationManager;
import part2_calculation.PermutationManager;

public class GameManagerTest {

    @org.junit.Test
    public void testSimulation()
    {
        SimulationManager simulationManager = new SimulationManager();
        Double result =simulationManager.countAverageSimulationResult();
        System.out.println("Average is = "+result);
    }

    @org.junit.Test
    public void testCalculation()
    {
        PermutationManager permutationManager = new PermutationManager();
        Double result = permutationManager.countAverageResult();
        System.out.println("Average is = "+result);
    }

    @org.junit.Test
    public void compareSimulationAndCalculation()
    {
        SimulationManager simulationManager = new SimulationManager();
        double simulationResult =simulationManager.countAverageSimulationResult();
        System.out.println(String.format( "%.1f", simulationResult));
        PermutationManager permutationManager = new PermutationManager();
        double calculationResult = permutationManager.countAverageResult();
        System.out.println(String.format( "%.1f", calculationResult));
        Assert.assertEquals(simulationResult,calculationResult,0.1d);
    }


}