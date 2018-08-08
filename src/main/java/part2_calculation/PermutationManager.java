package part2_calculation;

import model.Box;
import model.BoxesGenerator;
import model.Player;
import settings.Setup;

public class PermutationManager {

    private Box[] boxes;
    private int gcCounter =0;

    class ResultCounter
    {
        private long sum=0;
        private long counter=0;

        public void addSum(long i)
        {
            sum+=i;
        }

        public void addCounter(long i)
        {
            counter+=i;
        }

        public long getSum() {
            return sum;
        }

        public long getCounter() {
            return counter;
        }

        public double getAverage()
        {
            return (double)sum/(double)counter;
        }
    }

    public PermutationManager() {
        this.boxes = new BoxesGenerator().generateBoxes(false);
    }

    public Double countAverageResult()
    {
        ResultCounter resultCounter = new ResultCounter();
        countSumBoxesArray(java.util.Arrays.asList(boxes), 0, resultCounter);
        return resultCounter.getAverage();
    }

    private int getPossibleResultsFromGame(Box[] boxArrayToPlay)
    {
        int[] result = new int[6];
        Player player = new Player();
        boolean secondChance = true;
        boolean extraLife = false;

        for (int i = 0; i <boxArrayToPlay.length; i++)
        {
            if(boxArrayToPlay[i].getValue()==Box.BoxValue.EU100||
                    boxArrayToPlay[i].getValue()==Box.BoxValue.EU20||
                    boxArrayToPlay[i].getValue()==Box.BoxValue.EU5)
            {
                player.addReward(boxArrayToPlay[i].getReward());
            }
            else if(boxArrayToPlay[i].getValue()==Box.BoxValue.EXTRA_LIFE)
            {
                extraLife = true;
                continue;
            }
            else if(boxArrayToPlay[i].getValue()==Box.BoxValue.GAME_OVER)
            {
                if(extraLife)
                {
                    extraLife = false;
                    continue;
                }
                else {
                    if (secondChance) { //this scenario describes what happen if player doesn't get second chance
                        result[0] = player.getReward() + 20;
                        result[1] = player.getReward() + 10;
                        result[2] = player.getReward() + 5;
                        secondChance = false;
                        continue;
                    } else {    //this scenario describes what happen after player get second chance
                        result[3] = player.getReward() + 20;
                        result[4] = player.getReward() + 10;
                        result[5] = player.getReward() + 5;
                        break;
                    }
                }
            }
        }
        gcCounter++;
        return 3*(result[0]+result[1]+result[2])+result[3]+result[4]+result[5];
    }

    private void countSumBoxesArray(java.util.List<Box> arrayList, int element, ResultCounter resultCounter)
    {
        for (int i = element; i < arrayList.size(); i++)
        {
            java.util.Collections.swap(arrayList, i, element);
            countSumBoxesArray(arrayList, element + 1, resultCounter);
            java.util.Collections.swap(arrayList, element, i);
        }
        if (element == arrayList.size() - 1)
        {
            if(gcCounter>500000)   //this block of code
            {
                if(gcCounter%10000>9000)
                System.gc();
                if(Setup.debugMode)
                {
                System.out.println("Sum: " + resultCounter.getSum() + "; permutationsCounter: " + resultCounter.getCounter()
                        + "; Average: "+resultCounter.getAverage());
                }
                gcCounter=0;
            }
            resultCounter.addSum(getPossibleResultsFromGame((Box[])arrayList.toArray()));
            resultCounter.addCounter(12);
        }
    }
}
