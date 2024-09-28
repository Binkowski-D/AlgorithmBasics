package utility_tasks;

import javax.swing.*;

public class PhoneNumberValidation {
    public static void main(String[] args) {

        String phoneNumber = JOptionPane.showInputDialog(null, "Wprowadź swój numer telefonu. ENTER kończy działanie programu!", "Prośba o wprowadzenie nr telefonu", JOptionPane.QUESTION_MESSAGE);
        if(phoneNumber == null || phoneNumber.isEmpty()){
            JOptionPane.showMessageDialog(null,"Program zakończył działanie! Do zobaczenia.", "Koniec!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(isCorrect(phoneNumber)){
            JOptionPane.showMessageDialog(null, "Podany nr telefonu " + phoneNumber + " jest prawidłowy!", "Sukces!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Podany nr telefonu " + phoneNumber + " nie jest prawidłowy!", "Porażka!", JOptionPane.ERROR_MESSAGE);
        }


    }

    private static boolean isCorrect(String phoneNumber){
        String pattern = String.join("\\-?",
                "(\\(?\\d{3}\\)?|\\[?\\d{3}\\]?|\\{?\\d{3}\\}?)",
                "(\\(?\\d{3}\\)?|\\[?\\d{3}\\]?|\\{?\\d{3}\\}?)",
                "(\\(?\\d{3}\\)?|\\[?\\d{3}\\]?|\\{?\\d{3}\\}?)");

        return phoneNumber.matches(pattern);
    }
}
