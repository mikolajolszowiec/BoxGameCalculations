package model;

public class Box {

    private boolean opened;

    public enum BoxValue{
        EU100(100),EU20(20), EU5(5), EXTRA_LIFE(0), GAME_OVER(0);

        private int rewardValue;
        BoxValue(int rewardValue)
        {
            this.rewardValue = rewardValue;
        }
    }

    public class ExtraLifeException extends Exception{

    }

    public class GameOverException extends Exception{

    }

    private BoxValue value;

    public Box(BoxValue value)
    {
        this.value = value;
        opened = false;
    }

    public boolean isOpened() {
        return opened;
    }

    public void openBox() {
        this.opened = true;
    }

    public BoxValue getValue() {
        return value;
    }

    public int getReward() throws ExtraLifeException, GameOverException {
        if(value==BoxValue.EXTRA_LIFE)
            throw new ExtraLifeException();
        else if(value==BoxValue.GAME_OVER)
            throw new GameOverException();

        return value.rewardValue;
    }
}
