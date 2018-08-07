package model;

public class Player
{
    private int reward;

    public Player() {
        reward = 0;
    }

    public int getReward() {
        return reward;
    }

    public void addReward(int wonReward)
    {
        reward+=wonReward;
    }


}
