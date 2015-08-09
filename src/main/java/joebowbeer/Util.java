package joebowbeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

/** Tool class containing coding exercises. */
public class Util {

  private Util() { }

  /* 1 */

  /**
   * Sorts an array of ints in place, where odd ints appear first in the sort order.
   * @param numbers array of ints to be sorted in place
   */
  public static void fastSortOddsFirst(int[] numbers) {
    // Move odds before evens, keeping track of where evens start
    int startOfEvens = 0;
    for (int i = 0, len = numbers.length; i < len; i++) {
      int number = numbers[i];
      if ((number & 1) != 0) {
        // number is odd
        if (startOfEvens < i) {
          // Swap odd at current index with first even
          numbers[i] = numbers[startOfEvens];
          numbers[startOfEvens] = number;
        }
        // Increment start of evens
        startOfEvens++;
      }
    }
    // Sort odds and evens separately
    Arrays.sort(numbers, 0, startOfEvens);
    Arrays.sort(numbers, startOfEvens, numbers.length);
  }

  /**
   * Sorts an array of ints, where odd ints appear first in the sort order.
   * This implementation is a three-liner using the new stream methods in Java 8.
   * @param numbers array of ints to be sorted
   * @return new array of sorted ints
   */
  public static int[] sortedOddsFirst(int[] numbers) {
    IntStream odds = Arrays.stream(numbers).filter((int i) -> (i & 1) != 0);
    IntStream evens = Arrays.stream(numbers).filter((int i) -> (i & 1) == 0);
    return IntStream.concat(odds.sorted(), evens.sorted()).toArray();
  }

  /* 2 */

  /**
   * Reverses every word in the given string.
   * @param s input string
   * @return new string with original words in reverse order
   */
  public static String reversedWords(String s) {
    // Split string into words
    String[] words = s.split("\\s");
    // Make a copy of words to be reversed in place
    List<String> reversed = new ArrayList<>(Arrays.asList(words));
    Collections.reverse(reversed);
    // Re-join reversed list of words using space as delimiter
    return String.join(" ", reversed);
  }

  /* 3A */

  /**
   * Reverses the characters in the given string.
   * @param s input string
   * @return new string with characters reversed
   */
  public static String reverseCharacters(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  /* 3B */

  /**
   * Reverses the characters in the given string.
   * This implementation uses recursion (part B), albeit very inefficiently.
   * @param s input string
   * @return new string with characters reversed
   */
  public static String recursiveReverseCharacters(String s) {
    return (s.isEmpty()) ? s : recursiveReverseCharacters(s.substring(1)) + s.charAt(0);
  }

  /* 4 */

  /**
   * Returns first non-repeated character in the given string, or returns null
   * if no such character is found. A non-repeated character is one that occurs
   * only once in the given string.
   * @param s input string
   * @return first character that appears only once, or null if none exists
   */
  public static Character findFirstUniqueCharacter(String s) {
    // LinkedHashMap maintains occurrences in insertion order
    Map<Character, Integer> occurrences = new LinkedHashMap<>(s.length());
    // Count occurrences of each character
    for (Character ch : s.toCharArray()) {
      // Insert if first occurrence, otherwise increment current count
      occurrences.merge(ch, 1, Integer::sum);
    }
    // Return first character that occurs only once
    for (Entry<Character, Integer> entry : occurrences.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    // Return null if not found
    return null;
  }
}
