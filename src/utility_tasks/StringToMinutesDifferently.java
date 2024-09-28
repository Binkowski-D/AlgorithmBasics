package utility_tasks;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringToMinutesDifferently {
    public static void main(String[] args) {

        String time = "11.00am-8.00pm";
        String timeAsText = time.toUpperCase();

        timeAsText = timeAsText.replaceAll("(?i)(am|pm)", " $1");

        String [] timeAsTextArray = timeAsText.split("-");
        String firstValue = timeAsTextArray[0];
        String secondValue = timeAsTextArray[1];

        LocalTime firstTime = LocalTime.parse(firstValue, DateTimeFormatter.ofPattern("h.mm a"));
        LocalTime secondTime = LocalTime.parse(secondValue, DateTimeFormatter.ofPattern("h.mm a"));

        int minutesCounter = (int) Duration.between(firstTime, secondTime).toMinutes();

        if(firstTime.isAfter(secondTime)){
            minutesCounter+= 24 * 60;
        }

        System.out.println(minutesCounter + " minut.");



    }
}
