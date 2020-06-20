import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RomanToInteger {

    public static class Test {
        public static List<String> combinations = Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM");
        public static Map<Character, Integer> stringToNum = new HashMap();

        static {
            stringToNum.put('I', 1);
            stringToNum.put('V', 5);
            stringToNum.put('X', 10);
            stringToNum.put('L', 50);
            stringToNum.put('C', 100);
            stringToNum.put('D', 500);
            stringToNum.put('M', 1000);
        }

        public int romanToInt(String s) {
            int number = 0;
            char[] a = s.toCharArray();
            int len = a.length;
            while (len > 0) {
                if (len / 2 != 0) {
                    char last_char = a[len-1];
                    char second_last_char = a[len - 2];
                    String combination = s.substring(len - 2, len);
                    if (combinations.contains(combination)) {
                        number -= stringToNum.get(second_last_char);
                    } else {
                        number += stringToNum.get(second_last_char);
                    }
                    number += stringToNum.get(last_char);
                    len = len - 2;
                } else {
                    number += stringToNum.get(a[0]);
                    --len;
                }
            }
            return number;
        }
    }
    public static void main(String args[]) {
        Test test = new Test();
        System.out.println(test.romanToInt("MCDLXXVI"));
    }
}



