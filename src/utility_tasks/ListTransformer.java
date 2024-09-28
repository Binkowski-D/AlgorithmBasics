package utility_tasks;

import java.util.List;
import java.util.stream.Collectors;

public class ListTransformer {
    public static void main(String[] args) {
        List<String> input = List.of("MOTOCYKL", "MARAKUJA", "MAMA", "MAŁPA", "POMARAŃCZA");
        List<String> output = replaceAWithMAndCopy(input);
        System.out.println(output);

    }

    private static List<String> replaceAWithMAndCopy(List<String> input){
        return input.stream()
                .map(str -> str.replace('A', 'M'))
                .collect(Collectors.toList());
    }
}
