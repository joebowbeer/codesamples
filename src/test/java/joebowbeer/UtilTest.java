package joebowbeer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
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
  public void testSampleCompare() {
    Comparator<String> comparator = new Util.SampleComparator();
    assertThat(comparator.compare("", ""), equalTo(0));
    assertThat(comparator.compare("ab", "ab"), equalTo(0));
    assertThat(comparator.compare("ab", "abc"), lessThan(0));
    assertThat(comparator.compare("abc", "ab"), greaterThan(0));
    assertThat(comparator.compare("a10b", "a2b"), greaterThan(0));
    assertThat(comparator.compare("a10b", "ab"), lessThan(0));
    assertThat(comparator.compare("ab2", "a2"), greaterThan(0));
  }

  @Test
  public void testPreviousSmaller() {
    assertArrayEquals(new int[] { }, Util.leftNearestSmaller(new int[] { }));
    assertArrayEquals(new int[] { -1 }, Util.leftNearestSmaller(new int[] { 0 }));
    assertArrayEquals(new int[] { -1, 0, 1, 2 }, Util.leftNearestSmaller(new int[] { 0, 1, 2, 3 }));
    assertArrayEquals(new int[] { -1, -1, -1, -1 }, Util.leftNearestSmaller(new int[] { 3, 2, 1, 0 }));
    assertArrayEquals(new int[] { -1, 0, 1, 0 }, Util.leftNearestSmaller(new int[] { 0, 2, 3, 1 }));
  }

  @Test
  public void testClosestSmaller() {
    assertArrayEquals(new int[] { }, Util.closestSmaller(new int[] { }));
    assertArrayEquals(new int[] { -1 }, Util.closestSmaller(new int[] { 0 }));
    assertArrayEquals(new int[] { -1, 0, 1, 2 }, Util.closestSmaller(new int[] { 0, 1, 2, 3 }));
    assertArrayEquals(new int[] { 1, 2, 3, -1 }, Util.closestSmaller(new int[] { 3, 2, 1, 0 }));
    assertArrayEquals(new int[] { -1, 0, 1, 0 }, Util.closestSmaller(new int[] { 0, 2, 3, 1 }));
    assertArrayEquals(new int[] { 1, 2, -1, 2 }, Util.closestSmaller(new int[] { 3, 1, 0, 2 }));
    assertArrayEquals(new int[] { 3, 0, 3, -1 }, Util.closestSmaller(new int[] { 1, 3, 2, 0 }));
  }

  @Test
  public void testSelectSmallest() {
    assertThat(Util.selectSmallest(Arrays.asList(1), 2), Matchers.containsInAnyOrder(1));
    List<Integer> list = Arrays.asList(1, -2, 3, 101, 100, 99, 98, -1, 2, -3);
    assertThat(Util.selectSmallest(list, 2), Matchers.containsInAnyOrder(-2, -3));
  }
}
