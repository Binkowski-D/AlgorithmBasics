package utility_tasks;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą dodatnią: ");
        System.out.println("Jeśli chcesz wyjść z programu naciśnij ENTER!");
        String numberAsText = scanner.nextLine().trim();
        String pattern = "\\d+";

        while (!numberAsText.matches(pattern)){
            if(numberAsText.isEmpty()){
                System.out.println("Program zakończył działanie. Do zobaczenia.");
                return;
            }
            System.out.println("Podany ciąg znaków nie jest liczbą całkowita dodatnią. Prosimy o ponowne wprowadzenie liczby: ");
            System.out.println("Jeśli chcesz wyjść z programu naciśnij ENTER!");
            numberAsText = scanner.nextLine().trim();
        }

        long number = Long.parseLong(numberAsText);
        boolean isItPrime = isItPrimeNumber(number);
        if(!isItPrime){
            System.out.printf("Liczba %d nie jest liczbą pierwszą.", number);
        }
        else{
            System.out.printf("Liczba %d jest liczbą pierwszą.", number);
        }

    }

    private static boolean isItPrimeNumber(long number){
        if(number <= 1){
            return false;
        }
        if(number == 2){
            return true;
        }

        if(number % 2 == 0){
            return false;
        }

        for(int i = 3; i <= Math.sqrt(number); i+=2){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
