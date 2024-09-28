package utility_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringSubsequences {
    public static void main(String[] args) {

        Map<Character, Integer> characterMap = new HashMap<>();
        characterMap.put('a', 1);
        characterMap.put('b', 1);
        characterMap.put('c', 2);
        characterMap.put('d', 2);
        characterMap.put('e', 2);
        characterMap.put('f', 3);
        characterMap.put('g', 3);
        characterMap.put('h', 3);
        characterMap.put('i', 4);
        characterMap.put('j', 4);
        characterMap.put('k', 4);
        characterMap.put('l', 5);
        characterMap.put('m', 5);
        characterMap.put('n', 5);
        characterMap.put('o', 6);
        characterMap.put('p', 6);
        characterMap.put('q', 6);
        characterMap.put('r', 7);
        characterMap.put('s', 7);
        characterMap.put('t', 7);
        characterMap.put('u', 8);
        characterMap.put('v', 8);
        characterMap.put('w', 8);
        characterMap.put('x', 9);
        characterMap.put('y', 9);
        characterMap.put('z', 9);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ciąg dowolnych małych liter - bez polskich znaków. Inne znaki nie będą tolerowane.");
        String text = scanner.nextLine();
        String pattern = "[a-z]+";

        while (!text.matches(pattern)){
            System.out.println("Wpisałeś niepoprawne znaki. Ponów próbę. Jeśli chcesz zakończyć, wciśnij ENTER");
            text = scanner.nextLine();
            if(text.isEmpty()){
                System.out.println("Program zakończył działanie! Do zobaczenia :)");
                return;
            }
        }

        int sum = 0;



        for(int i = 0; i < text.length(); i++){
            if(characterMap.containsKey(text.charAt(i))){
                sum+= characterMap.get(text.charAt(i));
            }
        }

        if(sum % text.length() == 0){
            System.out.println("Suma podciągu " + text + " dzieli się przez jego długość.");
        }
        else{
            System.out.println("Suma podciągu " + text + " nie dzieli się przez jego długość.");
        }

    }
}
