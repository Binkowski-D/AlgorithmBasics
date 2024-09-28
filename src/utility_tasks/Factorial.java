package utility_tasks;


import java.util.Scanner;

public class Factorial {
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
                if(number < 0){
                    System.out.println("Prosimy o podanie liczby całkowitej dodatniej. Jeśli chcesz wyjśc z programu, naciśnij ENTER!");
                    continue;
                }

                long n = factorialOf(number);
                if(n == -1){
                    System.out.printf("Nie można obliczyć silni dla liczby %d, Long overflow", number);
                }
                else{
                    System.out.printf("Factorial dla liczby %d wynosi %d", number, n);
                }

                break;

            }catch (NumberFormatException ex){
                System.out.println("Niepoprawny format liczby. Prosimy ponowić próbę. Jeśli chcesz wyjść z programu, naciśnij ENTER!");
            }
        }

    }

    public static long factorialOf(long number){
        if(number == 0){
            return 1;
        }
        long n = 1;
        for(long i = 1; i <= number; i++){
            if(Long.MAX_VALUE / n < i ){
                return -1;
            }
            n = n * i;
        }
        return n;
    }
}