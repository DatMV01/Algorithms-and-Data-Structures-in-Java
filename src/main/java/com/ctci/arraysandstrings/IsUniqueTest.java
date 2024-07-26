package com.ctci.arraysandstrings;

import org.junit.jupiter.api.*;

public class IsUniqueTest {

    @Nested
    @DisplayName("Test cases for hasAllUniqueCharacters() method")
    class TestCases_For_HasAllUniqueCharacters {

        @Test
        public void testHasAllUniqueCharacters_StringIsNull_ReturnFalse() {
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters(null));
        }

        @Test
        public void testHasAllUniqueCharacters_StringIsEmpty_ReturnFalse() {
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters(""));
        }

        @Test
        public void testHasAllUniqueCharacters_DuplicateAtHead_ReturnFalse() {
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("aab"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("AAb"));

            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("ááb"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("ÁÁb"));

            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("1123456"));
        }

        @Test
        public void testHasAllUniqueCharacters_DuplicateAtMiddle_ReturnFalse() {
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("abcbd"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("aBcBd"));

            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("aưcưd"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("aƯcƯd"));

            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("123436"));
        }

        @Test
        public void testHasAllUniqueCharacters_DuplicateAtTail_ReturnFalse() {
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("aba"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("AbA"));

            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("ăbă"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("ĂbĂ"));

            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("1234566"));
        }

        @Test
        public void testHasAllUniqueCharacters_OnlyOneCharacter_ReturnTrue() {
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("a"));
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("1"));
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("A"));
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("#"));
        }

        @Test
        public void testHasAllUniqueCharacters_OnlyOneCharacter_ReturnFalse() {
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("á"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("Ô"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("€"));
        }

        @Test
        public void testHasAllUniqueCharacters_InvalidString_ReturnFalse() {
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("€á"));
            Assertions.assertFalse(IsUnique.hasDifferentIndividualCharacters("áÂ"));
        }

        @Test
        public void testHasAllUniqueCharacters_ValidString_ReturnTrue() {
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("aAb"));
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("abcBd"));
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("abA"));
            Assertions.assertTrue(IsUnique.hasDifferentIndividualCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
        }
    }
}