package model;

import java.util.Random;

public class BoxesGenerator
{
    public static final int BOXES_COUNT = 12;

    public Box[] generateBoxes(boolean random)
    {
        Box[] boxes = new Box[BOXES_COUNT];
        fillBoxes(boxes);
        if(random)shuffleBoxes(boxes);
        return boxes;
    }

    private void fillBoxes(Box[] boxes)
    {
        boxes[0] = new Box(Box.BoxValue.EU100);
        boxes[1] = new Box(Box.BoxValue.EU20);
        boxes[2] = new Box(Box.BoxValue.EU20);
        boxes[3] = new Box(Box.BoxValue.EU5);
        boxes[4] = new Box(Box.BoxValue.EU5);
        boxes[5] = new Box(Box.BoxValue.EU5);
        boxes[6] = new Box(Box.BoxValue.EU5);
        boxes[7] = new Box(Box.BoxValue.EU5);
        boxes[8] = new Box(Box.BoxValue.EXTRA_LIFE);
        boxes[9] = new Box(Box.BoxValue.GAME_OVER);
        boxes[10] = new Box(Box.BoxValue.GAME_OVER);
        boxes[11] = new Box(Box.BoxValue.GAME_OVER);
    }

    private void shuffleBoxes(Box[] boxes)
    {
        Random random = new Random();
        for (int i = boxes.length - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            Box box = boxes[index];
            boxes[index] = boxes[i];
            boxes[i] = box;
        }
    }



}
