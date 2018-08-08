package model;

public class Box {

    private boolean opened;

    public enum BoxValue{
        EU100(100),EU20(20), EU5(5), EXTRA_LIFE(0), GAME_OVER(-1);

        private int rewardValue;
        BoxValue(int rewardValue)
        {
            this.rewardValue = rewardValue;
        }
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

    public int getReward(){
        return value.rewardValue;
    }
}
