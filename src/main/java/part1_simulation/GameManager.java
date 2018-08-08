package part1_simulation;

import model.Box;
import model.BoxesGenerator;
import model.Player;

import java.util.Random;

public class GameManager
{
    private Box[] boxes;
    private Player player;
    private boolean extraLife;
    private boolean secondChance;

    public GameManager() {
        boxes = new BoxesGenerator().generateBoxes(true);
        player = new Player();
        extraLife = false;
        secondChance = true;
    }

    public int runGame()
    {
        for (int i = 0; i <boxes.length; i++)
        {
            if(boxes[i].getValue()==Box.BoxValue.EU100||
                boxes[i].getValue()==Box.BoxValue.EU20||
                boxes[i].getValue()==Box.BoxValue.EU5)
                {
                    player.addReward(boxes[i].getReward());
                }
            else if(boxes[i].getValue()==Box.BoxValue.EXTRA_LIFE)
            {
                extraLife = true;
                continue;
            }
            else if(boxes[i].getValue()==Box.BoxValue.GAME_OVER)
            {
                if(extraLife)
                {
                    extraLife = false;
                    continue;
                }
                else {
                    if (secondChance) { //this scenario describes what happen if player doesn't get second chance
                        if(!trySecondChance(true)) break;
                        secondChance = false;
                        continue;
                    } else {    //this scenario describes what happen after player get second chance
                        trySecondChance(false);
                        break;
                    }
                }
            }
        }
        return getPlayersReward();
    }

    private int randomInt(int length)
    {
        Random random = new Random();
        return random.nextInt(length);
    }

    private int getPlayersReward()
    {
        return player.getReward();
    }

    private boolean trySecondChance(boolean secondChance)
    {
       int i= randomInt(secondChance?4:3);
       switch(i){
           case 0: player.addReward(20); return false;
           case 1: player.addReward(10); return false;
           case 2: player.addReward(5); return false;
           case 3: player.addReward(0); return true;
       }
       return false;
    }

}
