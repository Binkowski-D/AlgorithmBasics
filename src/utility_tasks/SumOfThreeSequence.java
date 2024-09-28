package utility_tasks;

import java.util.ArrayList;
import java.util.List;

public class SumOfThreeSequence {
    public static void main(String[] args) {

        SumOfThreeSequence sumOfThreeSequence = new SumOfThreeSequence();
        int i = sumOfThreeSequence.calculate(5);
        System.out.println(i);
    }

    public int calculate(int index){
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(0);
        numbersList.add(1);
        numbersList.add(2);

        for(int i = 3; i <= index; i++){
            numbersList.add(i, numbersList.get(i - 3) + numbersList.get(i - 2) + numbersList.get(i - 1));
        }

        return numbersList.get(index);
    }
}
