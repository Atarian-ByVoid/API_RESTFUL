package com.planotatico.demo.converters;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null)
            return 0D;

        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static boolean isNumeric(Double numberOne) {
        return false;
    }

    public static int convertToDouble(Double numberOne) {
        return 0;
    }
}
