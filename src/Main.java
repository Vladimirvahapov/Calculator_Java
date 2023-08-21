import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи выражение: ");
        String example = scanner.nextLine();
        example = CheckingForValidInput.Checking(example);
        if(example == null){
            System.exit(0);
        }
        else {
            new Calc(example);
        }
    }
}
class Calc{
    public String exemple;
    public String operation = CheckingForValidInput.operation;

     Calc(String exemple){
        this.exemple = exemple;
        Result();
    }
    void Result() {
        String[] exampleParts = exemple.replaceAll("\\s", "").split("\\Q" + operation + "\\E");
        String result = ""; // Инициализируйте result пустой строкой

        switch (operation) {
            case "-":
                result = Integer.toString(Integer.parseInt(exampleParts[0]) - Integer.parseInt(exampleParts[1]));
                break;
            case "+":
                result = Integer.toString(Integer.parseInt(exampleParts[0]) + Integer.parseInt(exampleParts[1]));
                break;
            case "*":
                result = Integer.toString(Integer.parseInt(exampleParts[0]) * Integer.parseInt(exampleParts[1]));
                break;
            case "/":
                result = Integer.toString(Integer.parseInt(exampleParts[0]) / Integer.parseInt(exampleParts[1]));
                break;
        }

        if (CheckingForValidInput.isRoman) {
            result = arabicToRoman(Integer.parseInt(result));
            System.out.println(result);
        } else {
            System.out.println(result);
        }
    }
     String arabicToRoman(int a) {
            String s = switch (a) {
                case 1 -> "I";
                case 2 -> "II";
                case 3 -> "III";
                case 4 -> "IV";
                case 5 -> "V";
                case 6 -> "VI";
                case 7 -> "VII";
                case 8 -> "VIII";
                case 9 -> "IX";
                case 10 -> "X";
                case 11 -> "XI";
                case 12 -> "XII";
                case 13 -> "XIII";
                case 14 -> "XIV";
                case 15 -> "XV";
                case 16 -> "XVI";
                case 17 -> "XVII";
                case 18 -> "XVIII";
                case 19 -> "XIX";
                case 20 -> "XX";
                case 21 -> "XXI";
                case 24 -> "XXIV";
                case 25 -> "XXV";
                case 27 -> "XXVII";
                case 28 -> "XXVIII";
                case 30 -> "XXX";
                case 32 -> "XXXII";
                case 35 -> "XXXV";
                case 36 -> "XXXVI";
                case 40 -> "XL";
                case 42 -> "XLII";
                case 45 -> "XLV";
                case 48 -> "XLVIII";
                case 49 -> "XLIX";
                case 50 -> "L";
                case 54 -> "LIV";
                case 56 -> "LVI";
                case 60 -> "LX";
                case 63 -> "LXIII";
                case 64 -> "LXIV";
                case 70 -> "LXX";
                case 72 -> "LXXII";
                case 80 -> "LXXX";
                case 81 -> "LXXXI";
                case 90 -> "XC";
                case 100 -> "C";
                default -> "Отрицательное значение";
            };
            return s;
        }

    }





