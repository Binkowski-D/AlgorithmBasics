package utility_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCountInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = "[a-zA-Z]+";
        System.out.println("Napisz jakiś wyraz. Białe znaki, cyfry oraz znaki specjalne nie będą tolerowane.");
        String text = scanner.nextLine();
        while(!text.matches(pattern)){
            System.out.println("Proszę o używanie wyłącznie liter. Inne znaki nie będą tolerowane. Naciśnij ENTER aby zakończyć program.");
            text = scanner.nextLine().toLowerCase();
            if(text.isBlank()){
                System.out.println("Program zakończył działanie.");
                return;
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            char tmp = text.charAt(i);

            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp) + 1);
            }
            else{
                map.put(tmp, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println("Znak: " + entry.getKey() + " Wystąpienia: " + entry.getValue());
        }

    }
}
