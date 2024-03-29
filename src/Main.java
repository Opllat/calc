import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.printf(calc(input.nextLine()));
        input.close();
    }
    public static String calc(String inputString) throws Exception {
        String[] inputArr = inputString.split(" ");
        String operandOne = inputArr[0];
        String operation = inputArr[1];
        String operandTwo = inputArr[2];
        String output;
        String romansValidation = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";


        if(inputArr.length > 3) throw new Exception("Калькулятор должен выбрасывать исключение если выражение содержит более двух чисел");



        else {


        if(operandOne.matches(romansValidation) && operandTwo.matches(romansValidation)){
            if(romanToInt(operandOne) == 0 || romanToInt(operandTwo) == 0) throw new Exception("Калькулятор должен выбрасывать исключение если выражение содержит более двух чисел");


            if (romanToInt(operandOne) >= 0 && 10 >= romanToInt(operandOne) && romanToInt(operandTwo) >= 0 && 10 >= romanToInt(operandTwo)) {
                switch (operation) {
                    case ("+"):
                        output = intToRoman(romanToInt(operandOne) + romanToInt(operandTwo));
                        break;
                    case ("-"):
                        output = intToRoman(romanToInt(operandOne) - romanToInt(operandTwo));
                        break;
                    case ("*"):
                        output = intToRoman(romanToInt(operandOne) * romanToInt(operandTwo));
                        break;
                    case ("/"):
                        output =  intToRoman(romanToInt(operandOne) / romanToInt(operandTwo));
                        break;

                    default:
                        throw new Exception("Калькулятор должен выбрасывать исключение если выражение содержит более двух чисел");

                }

            }
            else{
                output = "Ошибка: Невалидные числа";
            }

        }

       else  if (Integer.valueOf(operandOne) >= 0 && 10 >= Integer.valueOf(operandOne) && Integer.valueOf(operandTwo) >= 0 && 10 >= Integer.valueOf(operandTwo)) {
            if(Integer.valueOf(operandOne) == 0 || Integer.valueOf(operandTwo) == 0) throw new Exception("Калькулятор должен выбрасывать исключение если выражение содержит более двух чисел");

            switch (operation) {
                case ("+"):
                    output = String.valueOf(Integer.valueOf(operandOne) + Integer.valueOf(operandTwo));
                    break;
                case ("-"):
                    output = String.valueOf(Integer.valueOf(operandOne) - Integer.valueOf(operandTwo));
                    break;
                case ("*"):
                    output = String.valueOf(Integer.valueOf(operandOne) * Integer.valueOf(operandTwo));
                    break;
                case ("/"):
                    output =  String.valueOf(Integer.valueOf(operandOne) / Integer.valueOf(operandTwo));
                    break;

                default:
                    throw new Exception("Калькулятор должен выбрасывать исключение если выражение содержит более двух чисел");

            }

        }
        else{
            throw new Exception("Калькулятор должен выбрасывать исключение если выражение содержит более двух чисел");
        }

        }
        return output;
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
        if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
        result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
        } else {
        result += map.get(s.charAt(i));
        }
        }
        return result;
        }

    private static String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds =
        {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens =
        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units =
        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] +
        hundreds[(num % 1000) / 100] +
        tens[(num % 100) / 10] +
        units[num % 10];
        }

}

