package utility_tasks;

import java.util.Scanner;

public class TDMagicSquare {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nieparzystą liczbę całkowitą większą od 1. Na jej podstawie zostanie stworzony kwadrat o podanych przez Ciebie wymiarach.");
        String pattern = "\\d+";
        String a = scanner.nextLine();
        if(!a.matches(pattern)){
            System.out.println("Oczekujemy nieparzystej liczby całkowitej. Inne znaki nie są tolerowane!");
            a = scanner.nextLine();
            if(!a.matches(pattern)){
                System.out.println("Program kończy działanie.");
                return;
            }
        }

        int b = Integer.parseInt(a);

        if(b % 2 == 0 || b == 1){
            System.out.println("Oczekujemy nieparzystej liczby całkowitej większej od 1. Kolejny błąd nie będzie tolerowany!");
            b = scanner.nextInt();

            if(b % 2 == 0 || b == 1){
                System.out.println("Program kończy działanie");
                return;
            }
        }

        int [][] array = new int[b][b];
        int i = 0;
        int j = b/2;
        array[i][j] = 1;


            for(int number = 2; number <= b * b ;number ++){

                i--; j++;

                if(i < 0 && j > array.length - 1){
                    j-=1;
                    i+=2;
                }

                if(i < 0){
                    i = array.length - 1;
                }

                if(j > array.length - 1 ){
                    j = 0;
                }

                if(array[i][j] != 0){
                    j-=1;
                    i+=2;
                }

                array[i][j] = number;

            }

        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }


    }


    }

