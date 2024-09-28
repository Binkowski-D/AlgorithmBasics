package utility_tasks;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialBigInteger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Prosimy o wpisanie liczby całkowitej dodatniej! Jeśli chcesz wyjśc z programu, naciśnij ENTER!");

        while (true){
            String text = scanner.nextLine();
            if(text.isEmpty()){
                System.out.println("Program zakończył działanie.");
                return;
            }
            try{
                long number = Long.parseLong(text);
                if(number < 0) {
                    System.out.println("Prosimy o podanie liczby całkowitej dodatniej. Jeśli chcesz wyjśc z programu, naciśnij ENTER!");
                    continue;
                }

                BigInteger n = factorialOf(BigInteger.valueOf(number));

                System.out.printf("Silnia dla liczby %d wynosi %s", number, n);
                break;

            }catch (NumberFormatException ex){
                System.out.println("Niepoprawny format liczby. Prosimy ponowić próbę. Jeśli chcesz wyjść z programu, naciśnij ENTER!");
            }
        }

    }

    public static BigInteger factorialOf(BigInteger number){
       if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)){
           return BigInteger.ONE;
       }

       BigInteger result = BigInteger.ONE;
       for(BigInteger i = BigInteger.ONE; i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)){
           result = result.multiply(i);
       }

       return result;

    }
}

