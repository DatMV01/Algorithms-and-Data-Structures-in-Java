package com.ctci.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rampatra
 * @since 18/11/2018
 */
public class IsUnique {

    /**
     * Check whether the input string contains different individual characters in the ASCII table.
     *
     * @param inputString Input string
     * @return true if all characters are different from each other, otherwise false.
     */
    public static boolean hasDifferentIndividualCharacters(String inputString) {
        int  maxCharacterDecimal = 128;

        if (inputString == null
                || inputString.isEmpty()
                || inputString.length() > maxCharacterDecimal) {
            return false;
        }

        boolean[] characterTrack = new boolean[maxCharacterDecimal];

        int inputStringLength = inputString.length();
        for (int i = 0; i < inputStringLength; i++) {
            int charInDecimal = inputString.charAt(i);

            if (charInDecimal >= maxCharacterDecimal
                    || characterTrack[charInDecimal]) {
                return false;
            }

            characterTrack[charInDecimal] = true;
        }
        return true;
    }

    /**
     * Check whether the input string contains different individual characters.
     *
     * @param inputString Input string
     * @return true if all characters are different from each other, otherwise false.
     */
    public static boolean hasAllUniqueCharactersEnhancement(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return false;
        }

        Set<Character> charSet = new HashSet<>();
        char[] inputStingArr = inputString.toCharArray();
        for (char c : inputStingArr) {
            if (!charSet.add(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasAllUniqueCharactersWhenStringContainsAllLowercase(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int charValue = s.charAt(i) - 'a';
            if ((checker & (1 << charValue)) > 0) {
                return false;
            }
            checker |= (1 << charValue);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ram";
        System.out.println(hasDifferentIndividualCharacters(s));
        s = "rama";
        System.out.println(hasDifferentIndividualCharacters(s));
        s = "ramA";
        System.out.println(hasDifferentIndividualCharacters(s));
        System.out.println("-------");
        s = "ram";
        System.out.println(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
        s = "rama";
        System.out.println(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
        // not working as the input contains different cases
        s = "ramA";
        System.out.println(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
    }
}
