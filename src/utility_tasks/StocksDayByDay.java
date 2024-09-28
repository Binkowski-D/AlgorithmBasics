package utility_tasks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StocksDayByDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź sześć dowolnych liczb dodatnich oddzielonych od siebie spacjami. Jeśli chcesz wyjść z programu, naciśnij ENTER!");
        String numbers = scanner.nextLine().trim();

        String pattern = "(\\d+(\\.\\d+)?\\s){5}\\d+(\\.\\d+)?";


        while(!numbers.matches(pattern)) {
            if(numbers.isEmpty()){
                System.out.println("Program zakończył działanie. Do zobaczenia :)");
                return;
            }
            System.out.println("Użyto nieprawidłowego formatu. Prosimy o ponowne wpisanie sześciu dowolnych liczb dodatnich oddzielonych od siebie spacjami. Jeśli chcesz wyjść z programu, naciśnij ENTER!");
            numbers = scanner.nextLine();

        }

        String[] numbersArray = numbers.split(" ");
        List<BigDecimal> list = new ArrayList<>();
        for(String singleNumber : numbersArray){
            list.add(new BigDecimal(singleNumber));
        }

        BigDecimal profit = highestProfit(list);
        if(profit.equals(BigDecimal.ZERO)){
            System.out.println("Nie można osiągnąć zysku!");
        }
        else{
            System.out.println("Zysk wynosi: " + profit);
        }

    }

    private static BigDecimal highestProfit(List<BigDecimal> list){
        BigDecimal highestProfit = BigDecimal.ZERO;
        for(int i = 0; i < list.size() - 1; i++){
            BigDecimal tmp = list.get(i + 1).subtract(list.get(i));
            if(tmp.compareTo(highestProfit) > 0){
                highestProfit = tmp;
            }
        }
        return highestProfit;
    }
}


