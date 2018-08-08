package part1_simulation;

import model.BoxesGenerator;
import settings.Setup;

public class SimulationManager {


    public SimulationManager() {
    }

    public Double countAverageSimulationResult()
    {
        long loopCount = 100000000;
        long sum = 0;
        GameManager gameManager = new GameManager();
        for (int i = 0; i <loopCount; i++)
        {
            int gameResult = gameManager.simulateGameResult(new BoxesGenerator().generateBoxes(true));
            sum +=gameResult;
            if(Setup.debugMode)
            {
                if (i % 500000 == 0)
                    System.out.println("Game number " + i + "; reward= " + gameResult + "; Average is = " + ((double) sum / (double) i));
            }
        }
        return ((double)sum/(double)loopCount);
    }
}
