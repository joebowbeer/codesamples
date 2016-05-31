package joebowbeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

  /* 5 */

  /**
   * Comparator for strings with a twist: consecutive digits are compared according to their
   * numeric value. For example, "a10b" compares greater than "a2b" because 10 is greater than 2.
   */
  static class SampleComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
      int lenA = a.length();
      int lenB = b.length();
      for (int i = 0, j = 0; i < lenA && j < lenB; ) {
        char charA = a.charAt(i);
        char charB = b.charAt(j);
        boolean hasNumA = Character.isDigit(charA);
        boolean hasNumB = Character.isDigit(charB);
        if (hasNumA && hasNumB) {
          int startIndex = i;
          while (++i < lenA && Character.isDigit(a.charAt(i))) { }
          int numA = Integer.parseInt(a.substring(startIndex, i));
          startIndex = j;
          while (++j < lenB && Character.isDigit(b.charAt(j))) { }
          int numB = Integer.parseInt(b.substring(startIndex, j));
          int c = Integer.compare(numA, numB);
          if (c != 0) {
            return c;
          }
        } else if (hasNumA) {
          return -1;
        } else if (hasNumB) {
          return 1;
        } else {
          int c = Character.compare(charA, charB);
          if (c != 0) {
            return c;
          }
          i++;
          j++;
        }
      }
      return lenA - lenB;
    }
  }

  /* All Nearest Smaller Values */

  public static int[] leftNearestSmaller(int[] elements) {
    int size = elements.length;
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      int j = i - 1;
      while (j != -1 && elements[j] >= elements[i]) {
        j = result[j];
      }
      result[i] = j;
    }
    return result;
  }

  public static int[] rightNearestSmaller(int[] elements) {
    int size = elements.length;
    int[] result = new int[size];
    for (int i = size; --i >= 0; ) {
      int j = i + 1;
      while (j != size && elements[j] >= elements[i]) {
        j = result[j];
      }
      result[i] = j;
    }
    return result;
  }

  public static int[] closestSmaller(int[] elements) {
    int[] prev = leftNearestSmaller(elements);
    int[] next = rightNearestSmaller(elements);
    int size = elements.length;
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      if (next[i] == size) {
        result[i] = prev[i];
      } else if (prev[i] == -1) {
        result[i] = next[i];
      } else {
        result[i] = (i - prev[i] <= next[i] - i) ? prev[i] : next[i];
      }
    }
    return result;
  }
}
