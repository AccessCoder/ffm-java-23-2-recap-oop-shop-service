package de.neuefische;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int x = romanNumberToInt("XIV");
        System.out.println(x);
    }

    public static int romanNumberToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Erstelle eine HashMap, um die Werte der römischen Ziffern zuzuordnen
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = romanMap.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));
            int previous = romanMap.get(s.charAt(i - 1));

            // Wenn der Wert der vorherigen Ziffer kleiner ist als der Wert der aktuellen Ziffer,
            // subtrahiere den Wert der vorherigen Ziffer, da dies ein spezieller Fall ist (z.B., IV oder IX)
            if (previous < current) {
                result += current - 2 * previous;
            } else {
                result += current;
            }
        }

        return result;
    }


}
