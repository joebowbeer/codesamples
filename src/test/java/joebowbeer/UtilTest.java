package joebowbeer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class UtilTest {

  @Test
  public void testFastSortOddsFirst() {
    int[] numbers;

    Util.fastSortOddsFirst(numbers = new int[] { });
    assertArrayEquals(new int[] { }, numbers);

    Util.fastSortOddsFirst(numbers = new int[] { 0 });
    assertArrayEquals(new int[] { 0 }, numbers);

    Util.fastSortOddsFirst(numbers = new int[] { 1 });
    assertArrayEquals(new int[] { 1 }, numbers);

    Util.fastSortOddsFirst(numbers = new int[] { 0, 1 });
    assertArrayEquals(new int[] { 1, 0 }, numbers);

    Util.fastSortOddsFirst(numbers = new int[] { 1, 2, 3, 4 });
    assertArrayEquals(new int[] { 1, 3, 2, 4 }, numbers);

    Util.fastSortOddsFirst(numbers = new int[] { 6, 4, 2, 7 });
    assertArrayEquals(new int[] { 7, 2, 4, 6 }, numbers);
  }

  @Test
  public void testSortedOddsFirst() {
    assertArrayEquals(new int[] { }, Util.sortedOddsFirst(new int[] { }));
    assertArrayEquals(new int[] { 0 }, Util.sortedOddsFirst(new int[] { 0 }));
    assertArrayEquals(new int[] { 1 }, Util.sortedOddsFirst(new int[] { 1 }));
    assertArrayEquals(new int[] { 1, 0 }, Util.sortedOddsFirst(new int[] { 0, 1 }));
    assertArrayEquals(new int[] { 1, 3, 2, 4 }, Util.sortedOddsFirst(new int[] { 1, 2, 3, 4 }));
    assertArrayEquals(new int[] { 7, 2, 4, 6 }, Util.sortedOddsFirst(new int[] { 6, 4, 2, 7 }));
  }

  @Test
  public void testWordsReversed() {
    assertEquals("Max is name My", Util.reversedWords("My name is Max"));
  }

  @Test
  public void testCharactersReversed() {
    assertEquals("!dlrow olleH", Util.reverseCharacters("Hello world!"));
  }

  @Test
  public void testCharactersReversedRecursively() {
    assertEquals("!dlrow olleH", Util.recursiveReverseCharacters("Hello world!"));
  }

  @Test
  public void testFindFirstUniqueCharacter() {
    assertEquals(Character.valueOf('H'), Util.findFirstUniqueCharacter("Hello world!"));
    assertEquals(Character.valueOf('y'), Util.findFirstUniqueCharacter("My name is Max"));
    assertEquals(Character.valueOf('g'), Util.findFirstUniqueCharacter("abcdefgfedcba"));
    assertNull(Util.findFirstUniqueCharacter(""));
    assertNull(Util.findFirstUniqueCharacter("aabbcc"));
  }

  @Test
  public void testParseRomanNumerals() {
    assertEquals(1, Util.parseRomanNumerals("I"));
    assertEquals(2, Util.parseRomanNumerals("II"));
    assertEquals(3, Util.parseRomanNumerals("III"));
    assertEquals(4, Util.parseRomanNumerals("IV"));
    assertEquals(5, Util.parseRomanNumerals("V"));
    assertEquals(6, Util.parseRomanNumerals("VI"));
    assertEquals(7, Util.parseRomanNumerals("VII"));
    assertEquals(8, Util.parseRomanNumerals("VIII"));
    assertEquals(9, Util.parseRomanNumerals("IX"));
    assertEquals(10, Util.parseRomanNumerals("X"));
    assertEquals(11, Util.parseRomanNumerals("XI"));
    assertEquals(12, Util.parseRomanNumerals("XII"));
    assertEquals(1492, Util.parseRomanNumerals("MCDXCII"));
    assertEquals(1958, Util.parseRomanNumerals("MCMLVIII"));
    assertEquals(2015, Util.parseRomanNumerals("MMXV"));
  }

  @Test
  public void testParseEnglishNumerals() {
    assertEquals(1, Util.parseEnglishNumerals("one"));
    assertEquals(2, Util.parseEnglishNumerals("two"));
    assertEquals(3, Util.parseEnglishNumerals("three"));
    assertEquals(4, Util.parseEnglishNumerals("four"));
    assertEquals(5, Util.parseEnglishNumerals("five"));
    assertEquals(6, Util.parseEnglishNumerals("six"));
    assertEquals(7, Util.parseEnglishNumerals("seven"));
    assertEquals(8, Util.parseEnglishNumerals("eight"));
    assertEquals(9, Util.parseEnglishNumerals("nine"));
    assertEquals(10, Util.parseEnglishNumerals("ten"));
    assertEquals(11, Util.parseEnglishNumerals("eleven"));
    assertEquals(1016, Util.parseEnglishNumerals("one thousand and sixteen"));
    assertEquals(1492, Util.parseEnglishNumerals("fourteen hundred ninety two"));
    assertEquals(1958, Util.parseEnglishNumerals("one thousand nine hundred fifty eight"));
    assertEquals(2015, Util.parseEnglishNumerals("two thousand fifteen"));
    assertEquals(52100, Util.parseEnglishNumerals("fifty two thousand and one hundred"));
    assertEquals(152000, Util.parseEnglishNumerals("one hundred fifty two thousand"));
//    assertEquals(1492, Util.parseEnglishNumerals("fourteen ninety two"));
//    assertEquals(2015, Util.parseEnglishNumerals("twenty fifteen"));
  }
}
