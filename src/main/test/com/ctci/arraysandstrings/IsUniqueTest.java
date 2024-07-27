package com.ctci.arraysandstrings;

import org.junit.jupiter.api.*;

public class IsUniqueTest {

    @Nested
    @DisplayName("Test cases for isAllCharactersUniqueAndInASCII()")
    class TestCasesForIsAllCharactersUniqueAndInASCII {

        @Test
        public void isAllCharactersUniqueAndInASCII_StringIsNull_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII(null));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_StringIsEmpty_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII(""));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_StringLengthSmallerOrEqual128_ReturnFalse() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 128; i++) {
                stringBuilder.append((char) i);
            }
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII(stringBuilder.toString()));

            stringBuilder.setLength(0);
            for (int i = 1; i < 127; i++) {
                stringBuilder.append((char) i);
            }
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII(stringBuilder.toString()));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_StringLengthLargerThan128_ReturnFalse() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 128; i++) {
                stringBuilder.append((char) i);
            }
            stringBuilder.append("a");

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII(stringBuilder.toString()));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_DuplicateAtHead_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aab"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("AAb"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ááb"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ÁÁb"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("1123456"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_DuplicateAtMiddle_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("abcbd"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aBcBd"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aưcưd"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aƯcƯd"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("123436"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_DuplicateAtTail_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aba"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("AbA"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ăbă"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ĂbĂ"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("1234566"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_OnlyOneCharacter_ReturnTrue() {
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("a"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("1"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("A"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("#"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_OnlyOneCharacter_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("á"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("Ô"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("€"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_InvalidString_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("€á"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("áÂ"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_ValidString_ReturnTrue() {
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("aAb"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("abcBd"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("abA"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
        }
    }

    @Nested
    @DisplayName("Test cases for isAllCharactersUniqueAndLowercaseAndInAlphabet()")
    class TestCasesForIsAllCharactersUniqueAndLowercaseAndInAlphabet {

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_StringIsNull_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet(null));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_StringIsEmpty_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet(""));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_StringLengthSmallerOrEqual26_ReturnFalse() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 97; i <= 122; i++) {   // 'a' -> 'z'
                stringBuilder.append((char) i);
            }
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet(stringBuilder.toString()));

            stringBuilder.setLength(0);
            for (int i = 100; i <= 120; i++) {   // 'a' -> 'z'
                stringBuilder.append((char) i);
            }
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet(stringBuilder.toString()));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_StringLengthLargerThan26_ReturnFalse() {
            String a2z = "abcdefghijklmnopqrstuvwxyz";
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet(a2z + (char) 96)); // 96 => `
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet(a2z + (char) 123)); // 123 => {
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_Beyond_a2z_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("GH@"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("{} "));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("ááb"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("ÁÁb"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("1123456"));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_DuplicateAtHead_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("aab"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("AAb"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("ááb"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("ÁÁb"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("1123456"));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_DuplicateAtMiddle_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("abcbd"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("aBcBd"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("aưcưd"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("aƯcƯd"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("123436"));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_DuplicateAtTail_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("aba"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("AbA"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("ăbă"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("ĂbĂ"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("1234566"));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_OnlyOneCharacter_ReturnTrue() {
            for (int i = 97; i <= 122; i++) {
                Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet(String.valueOf((char) i)));
            }
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_OnlyOneCharacter_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("A"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("á"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("Ô"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("€"));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_InvalidString_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("€á"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("áÂ"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("aB"));
        }

        @Test
        public void isAllCharactersUniqueAndLowercaseAndInAlphabet_ValidString_ReturnTrue() {
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("mwq"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("fwoklt"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndLowercaseAndInAlphabet("abcdefghijklmnopqrstuvwxyz"));
        }
    }

}
