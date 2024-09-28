package utility_tasks;

import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        String [] operations = {"+", "-", "*", "/"};

        double firstNumber = getValidateNumber("Wprowadź pierwszą liczbę.");

        String operation = "";
        boolean isValid = false;

        while(!isValid){
            operation = (String) JOptionPane.showInputDialog(null, "Wybierz operację, którą chcesz wykonać", "Kalkulator", JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);
            if(operation != null){
                isValid = true;
            }else{
                JOptionPane.showMessageDialog(null, "Musisz wybrać operację, którą chcesz wykonać! Spróbuj raz jeszcze.");
            }
        }

        double secondNumber = getValidateNumber("Wprowadź drugą liczbę.");

        try{
            double result = switch (operation){
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                case "/" -> {
                    if(secondNumber == 0){
                        throw new ArithmeticException("Błąd dzielenia przez zero!");
                    }
                    yield firstNumber / secondNumber;
                }
                default ->  0;
            };

            JOptionPane.showMessageDialog(null, "Wynik operacji wynosi: " + result);

        }catch (ArithmeticException ex){
            JOptionPane.showMessageDialog(null, "Błąd arytmetyczny! " + ex.getMessage());
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Wystąpił nieoczekiwany błąd.");
        }

}


private static double getValidateNumber(String message){
        double number = 0;
        boolean isValid = false;

        while(!isValid){
            try {
                String input = JOptionPane.showInputDialog(null, message, "Kalkulator", JOptionPane.QUESTION_MESSAGE);
                if(input == null){
                    JOptionPane.showMessageDialog(null, "Nic nie wprowadzono. Program kończy działanie!");
                    System.exit(0);
                }

                number = Double.parseDouble(input);
                isValid = true;

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Niepoprawny format danych! Spróbuj jeszcze raz.");
            }
        }

        return number;
}
}
