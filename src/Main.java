import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи выражение: ");
        String example = scanner.nextLine();
        calc(example);

}

    public static void calc(String example){

        String[][] romanNumeralsArray = {
                {"1", "I"},
                {"2", "II"},
                {"3", "III"},
                {"4", "IV"},
                {"5", "V"},
                {"6", "VI"},
                {"7", "VII"},
                {"8", "VIII"},
                {"9", "IX"},
                {"10", "X"},
        };



        char[] symbol = {'-', '+', '*', '/'};
        String operation = "";
        for (char ch : symbol) {
            if (example.contains(String.valueOf(ch))) {
                operation = String.valueOf(ch);

                break;
            }
        }
        String[] exempleParts = example.replaceAll("\\s","").split("\\Q" + operation + "\\E");


        if ((operation != "") && (exempleParts.length == 2) && (Integer.parseInt(exempleParts[0]) >= 1) && (Integer.parseInt(exempleParts[0]) <= 10) && (Integer.parseInt(exempleParts[1]) >= 1)
                && (Integer.parseInt(exempleParts[1]) <= 10)) {
            Calc clc = new Calc(exempleParts, operation);

        }
        else {
            System.out.println("Вы нарушили условие для работы калькулятора:\n" + " 1.Калькулятор работает только с числами от 1 до 10, и только с двумя\n" +
                    " 2.Калькулятор работает только с операциями сложения, вычитания, умножения, деления\n" +" 3.");
        }

    }

}

    class Calc{
    public String[] exempleParts;
    public String operation;
    public Calc(String[] exempleParts,String operation){
        this.exempleParts = exempleParts;
        this.operation = operation;
        Result();
    }
    public void Result(){
        switch(operation){
            case "-":
                System.out.println(Integer.parseInt(exempleParts[0]) - Integer.parseInt(exempleParts[1]));
                break;
            case "+":
                System.out.println(Integer.parseInt(exempleParts[0]) + Integer.parseInt(exempleParts[1]));
                break;
            case "*":
                System.out.println(Integer.parseInt(exempleParts[0]) * Integer.parseInt(exempleParts[1]));
                break;
            case "/":
                System.out.println(Integer.parseInt(exempleParts[0]) / Integer.parseInt(exempleParts[1]));
                break;
        }
    }
}





