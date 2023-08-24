class CheckingForValidInputAndRemakeToArabic {
static String error = "В строке должны содержаться две римские или арабские цифры от 1 до 10 и оператор между ними(+,-,*,/)";
static boolean isRoman = false;
static String operation = "";
    static String Checking(String example){
        String symbol = "-+*/";
        for(int i = 0;i<example.length();i++){
            if (symbol.contains(String.valueOf(example.charAt(i)))) {
                operation += example.charAt(i);
            }
        }
        String[] exempleParts = example.replaceAll("\\s", "").split("\\Q" + operation + "\\E");
        if(operation.length() == 1 && exempleParts.length ==2){
             String firstVarible = exempleParts[0];
             String secondvarible = exempleParts[1];
                if(isValidInput(example) && isRoman == true && isRomanNumberInRange(firstVarible) &&  isRomanNumberInRange(secondvarible)){
                    return romanToArabic(firstVarible)+operation+romanToArabic(secondvarible);
                }
                else if(isValidInput(example) && isRoman == false){
                    return firstVarible + operation + secondvarible;
                }
                else {
                    System.out.println(error);
                    return null;
                }
        }
        else {
            System.out.println(error);
            return null;
        }
    }
    static boolean isRomanNumberInRange(String roman) {
        String[] validRomanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String validNumber : validRomanNumbers) {
            if (roman.equals(validNumber)) {
                return true;
            }
        }
        return false;
    }
    static String romanToArabic(String roman){
        switch (roman) {
            case "I": return "1";
            case "II": return "2";
            case "III": return "3";
            case "IV": return "4";
            case "V": return "5";
            case "VI": return "6";
            case "VII": return "7";
            case "VIII": return "8";
            case "IX": return "9";
            case "X": return "10";
            default: return roman;
        }
    }
    static boolean isValidInput(String example) {
        // Проверка на арабские цифры от 1 до 10
        boolean isValidArabic = example.matches("^(?:[1-9]|10)(?:[+\\-*/](?:[1-9]|10))*$");
        // Проверка на римские цифры от I до X
        boolean isValidRoman = example.matches("^(?:[IVX]{1,10})(?:[+\\-*/](?:[IVX]{1,10}))*$");
        if(isValidRoman){
            isRoman=true;
        }
        return isValidArabic || isValidRoman;
    }
}
