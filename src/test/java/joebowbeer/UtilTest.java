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
}
