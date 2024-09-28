package utility_tasks;

import java.util.Scanner;

public class FactorialOnLargeNumbersWithoutBigInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prosimy o wpisanie liczby całkowitej dodatniej! Jeśli chcesz wyjść z programu naciśnij ENTER.");

        while (true){
            String text = scanner.nextLine();
            if(text.isEmpty()) {
                System.out.println("Program zakończył działanie. Do zobaczenia!");
                return;
            }
            try{
                int number = Integer.parseInt(text);
                if(number < 0){
                    System.out.println("Prosimy o podanie liczby całkowitej dodatniej. Jeśli chcesz wyjśc z programu, naciśnij ENTER!");
                    continue;
                }

                String n = factorialOf(number);
                System.out.printf("Silnia dla liczby %d wynosi %s", number, n);
                break;

            }catch (NumberFormatException ex){
                System.out.println("Niepoprawny format liczby. Prosimy ponowić próbę. Jeśli chcesz wyjść z programu, naciśnij ENTER!");
            }
        }

    }

    private static String factorialOf(int number){
       int [] array = new int[500];
       array[array.length - 1] = 1;
       for(int i = 1; i <= number; i++){
           multiply(array, i);
       }

       StringBuilder stringBuilder = new StringBuilder();
       boolean leadingZeros = true;

       for(int digit : array){
           if(digit != 0 || !leadingZeros){
               stringBuilder.append(digit);
               leadingZeros = false;
           }
       }

       return stringBuilder.toString();

    }

    private static void multiply(int[] array, int multiplier){
       int carry = 0;
       for(int i = array.length - 1; i >= 0; i--){
           int result = array[i] * multiplier + carry;
           array[i] = result % 10;
           carry = result / 10;

       }

    }


}