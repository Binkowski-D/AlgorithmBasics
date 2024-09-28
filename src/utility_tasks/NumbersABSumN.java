package utility_tasks;


import java.util.Scanner;

public class NumbersABSumN {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pattern = "\\d+";

        System.out.println("Podaj dodatnią liczbę całkowitą");
        String sum = scanner.nextLine();

        while(!sum.matches(pattern)){
            System.out.println("Musisz podać dodatnią liczbę całkowitą. Inne znaki nie będą tolerowane. Jeśli chcesz wyjść naciśnij ENTER!");
            sum = scanner.nextLine();
            if(sum.isBlank()){
                System.out.println("Program zakończył działanie.");
                return;
        }
        }

        int n = Integer.parseInt(sum);
        int b ;

        for(int a = 1; a < n; a ++){
            b = n - a;

            if(!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0")) {
                System.out.println("a = " + a + " b = " + b);
            }

        }
    }

}
