package com.ctci.arraysandstrings;

/**
 * @author rampatra
 * @since 18/11/2018
 */
public class IsUnique {

    /**
     * Check whether the input string contains different individual characters and it in the ASCII table.
     *
     * @param str Input string
     * @return true if all characters are different from each other, otherwise false.
     */
    public static boolean isAllCharactersUniqueAndInASCII(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int maxCharIndex = 128;
        int stringLength = str.length();

        if (stringLength > maxCharIndex) {
            return false;
        }

        boolean[] characterTrack = new boolean[maxCharIndex]; // assuming the string contains only ASCII characters
        for (int i = 0; i < stringLength; i++) {
            int charIndex = str.charAt(i);
            if (charIndex >= maxCharIndex
                    || characterTrack[charIndex]) {
                return false;
            }

            characterTrack[charIndex] = true;
        }
        return true;
    }

    /**
     * Check whether the input string contains different individual characters, lowercase
     * and in between 'a' and 'z'
     *
     * @param str Input string
     * @return true if all characters are different from each other,lowercase and between 'a' and 'z', otherwise false.
     */
    public static boolean isAllCharactersUniqueAndLowercaseAndInAlphabet(String str) {
        if (str == null
                || str.isEmpty()
                || str.length() > 26) {
            return false;
        }

        int checker = 0;
        int stringLength = str.length();
        for (int i = 0; i < stringLength; i++) {

            char character = str.charAt(i);
            if (!(character >= 'a' && character <= 'z')) {
                return false;
            }

            int characterIndex  = character - 'a';
            int singleBitOnPosition = 1 << characterIndex ;

            if ((checker & singleBitOnPosition) > 0) {
                return false;
            }

            checker |= singleBitOnPosition; // checker = checker | singleBitOnPosition;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ram";
        System.out.println(isAllCharactersUniqueAndInASCII(s));
        s = "rama";
        System.out.println(isAllCharactersUniqueAndInASCII(s));
        s = "ramA";
        System.out.println(isAllCharactersUniqueAndInASCII(s));
        System.out.println("-------");
        s = "ram";
        System.out.println(isAllCharactersUniqueAndLowercaseAndInAlphabet(s));
        s = "rama";
        System.out.println(isAllCharactersUniqueAndLowercaseAndInAlphabet(s));
        // not working as the input contains different cases
        s = "ramA";
        System.out.println(isAllCharactersUniqueAndLowercaseAndInAlphabet(s));
    }
}
