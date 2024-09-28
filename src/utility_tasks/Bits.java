package utility_tasks;

import java.util.Scanner;

public class Bits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą dodatnią. Jeśli chcesz wyjść z programu, naciśnij ENTER!");
        String numberAsText = scanner.nextLine().trim();
        String pattern = "\\d+";

        while(!numberAsText.matches(pattern)){
            if(numberAsText.isEmpty()){
                System.out.println("Program kończy działanie. Do zobaczenia :)");
                return;
            }
            System.out.println("Nie rozpoznano żadnej liczby. Prosimy ponowić próbę. Jeśli chcesz wyjść z programu, naciśnij ENTER!");
            numberAsText = scanner.nextLine();
        }
        long number = Long.parseLong(numberAsText);
        System.out.printf("Liczba ustawionych bitów na 1 w binarnej reprezentacji liczby %d wynosi: %d", number, howManyBits(number));

    }

    private static long howManyBits(long number){
        return Long.bitCount(number);
    }
}
