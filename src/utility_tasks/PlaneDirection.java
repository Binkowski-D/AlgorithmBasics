package utility_tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PlaneDirection {

    final static String path = "src/utility_tasks/resources/Plane.txt";

    public static void main(String[] args) {
        NavigableMap<String, Integer> flightDetails = new TreeMap<>();
        try {
            List<String> list = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            for(String element : list){
                String [] array = element.replace("°", "").strip().split("-");
                if(array.length == 2) {
                    String hour = array[0];
                    int angle = Integer.parseInt(array[1]);
                    if(angle >= 0 && angle <= 360) {
                        flightDetails.put(hour, angle);
                    }else{
                        System.out.println("Niepoprawny kąt w linii " + element);
                    }
                }else{
                    System.out.println("Błędny format linii " + element);
                }
            }
        }catch (IOException ex){
            System.out.println("Error " + ex.getMessage());
        }

            if(!flightDetails.isEmpty()){
            Map.Entry<String, Integer> firstEntry = flightDetails.firstEntry();
            System.out.println("Samolot wystartował o godzinie " + firstEntry.getKey() + " i początkowo leciał pod kątem " + firstEntry.getValue() + "°.");
            int firstAngle = firstEntry.getValue();

            for (Map.Entry<String, Integer> entry : flightDetails.tailMap(firstEntry.getKey(), false).entrySet()) {
                String message = getDirection(firstAngle, entry.getValue());
                System.out.println("O godzinie " + entry.getKey() + " " + message);

                firstAngle = entry.getValue();
            }
            }else{
                System.out.println("Brak danych w pliku lub plik jest pusty!");
            }

    }

    private static String getDirection(int previousAngle, int currentAngle){
        if(previousAngle == 0 && currentAngle == 360 || previousAngle == 360 && currentAngle == 0){
            return "samolot leciał prosto";
        }

        else if(previousAngle < currentAngle){
            return "samolot skręcił w prawo!";
        }
        else if(previousAngle > currentAngle){
            return "samolot skręcił w lewo!";
        }

        return "samolot leciał prosto";
    }
}
