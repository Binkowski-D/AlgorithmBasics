package utility_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAndNumberProcessing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź jakiekolwiek znaki.");
        String input = scanner.nextLine();
        while(input.isEmpty()){
            System.out.println("Nic nie wpisano. Ponów próbę lub naciśnij ENTER, jeśli chcesz wyjść z programu.");
            input = scanner.nextLine();
            if(input.isEmpty()){
                System.out.println("Program zakończył działanie. Do zobaczenia :)");
                return;
            }
        }

        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        List<Long> numbers = new ArrayList<>();

        while(matcher.find()){
            numbers.add(Long.parseLong(matcher.group()));
        }


        System.out.printf("Suma wszystkich liczb wynosi: %d%n", sum(numbers));
        System.out.printf("Średnia wszystkich liczb wynosi: %.2f%n", average(numbers));
        System.out.printf("Najmniejsza liczba: %d%n", theSmallestNumber(numbers));
        System.out.printf("Największa liczba: %d%n", theGreatestNumber(numbers));

    }

    private static Long sum(List<Long> list){

        return list.stream()
                .mapToLong(Long :: longValue)
                .sum();
    }

    private static double average (List<Long> list){
        return list.stream()
                .mapToLong(Long :: longValue)
                .average()
                .orElse(0);
    }

    private static long theSmallestNumber(List<Long> list){
        return list.stream()
                .mapToLong(Long :: longValue)
                .min()
                .orElse(Long.MIN_VALUE);
    }

    private static long theGreatestNumber(List<Long> list){
        return list.stream()
                .mapToLong(Long :: longValue)
                .max()
                .orElse(Long.MAX_VALUE);
    }

}
