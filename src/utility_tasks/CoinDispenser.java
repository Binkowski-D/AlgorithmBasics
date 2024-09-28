package utility_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinDispenser {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Podaj liczbę całkowitą dodatnią, która określi ilość 'reszt' do wydania. Błędny format danych spowoduje wyjście z programu!");
            String firstPattern = "\\d+";
            String quantityAsText = scanner.nextLine().strip();
            if (quantityAsText.isEmpty() || !quantityAsText.matches(firstPattern)) {
                System.out.println("Program zakończył działanie. Do zobaczenia!");
                return;
            }
            int quantity = Integer.parseInt(quantityAsText);
            double[] array = new double[quantity];

            System.out.println("Podawaj kolejno kwoty, które mają być wydane klientowi (np. 1,20). Jeśli chcesz wyjść z programu naciśnij ENTER!");
            String secondPattern = "\\d+,\\d{2}";
            for (int i = 0; i < array.length; i++) {
                String amountAsText = scanner.nextLine().strip();
                while (!amountAsText.matches(secondPattern)) {
                    if (amountAsText.isEmpty()) {
                        System.out.println("Program zakończył działanie. Do zobaczenia!");
                        return;
                    }
                    System.out.println("Niepoprawny format danych. Spróbuj raz jeszcze lub naciśnij ENTER, jeśli chcesz wyjść z programu.");
                    amountAsText = scanner.nextLine().strip();
                }
                amountAsText = amountAsText.replace(',', '.');
                double amount = Double.parseDouble(amountAsText);
                array[i] = amount;
            }

            spendTheChange(array);
        }
    }

    private static void spendTheChange(double[] amounts) {

        Map<Double, Integer> coinsMap = new LinkedHashMap<>();
        coinsMap.put(5.0, 1);
        coinsMap.put(2.0, 3);
        coinsMap.put(1.0, 5);
        coinsMap.put(0.5, 10);
        coinsMap.put(0.2, 20);
        coinsMap.put(0.1, 200);
        coinsMap.put(0.05, 100);
        coinsMap.put(0.02, 100);
        coinsMap.put(0.01, 10000);

        for(double amount : amounts){
            System.out.println("Wydaję resztę dla kwoty: " + amount + " zł");

            for(Map.Entry<Double, Integer> entry : coinsMap.entrySet()){
                Double nominal = entry.getKey();
                Integer availableCoins = entry.getValue();

                if(amount >= nominal && availableCoins > 0){
                    int coinsNeeded = (int) (amount / nominal);
                    int coinsTaken = Math.min(coinsNeeded, availableCoins);

                    amount = amount - (coinsTaken * nominal);
                    amount = Math.round(amount * 100.0) / 100.0;

                    coinsMap.put(nominal, availableCoins - coinsTaken);

                    System.out.printf("Wydaję %d * %.2f zł %n", coinsTaken, nominal);
                }

                if (amount == 0){
                    break;
                }
            }

            if(amount > 0){
                System.out.println("Nie da się wypłacić reszty. Pozostała kwota " + amount + " zł");
            }

            System.out.println();

        }


    }
}


