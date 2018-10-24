package p05_randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement(ArrayList<Object> inputList) {
        Random random = new Random();
        Object obj = inputList.get(random.nextInt(inputList.size()));
        inputList.remove(obj);
        return obj;
    }

}
