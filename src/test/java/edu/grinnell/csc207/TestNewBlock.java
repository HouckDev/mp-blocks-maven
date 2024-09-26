package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Boxed;
import edu.grinnell.csc207.blocks.Empty;
import edu.grinnell.csc207.blocks.PatternBorder;
import edu.grinnell.csc207.blocks.Rect;

/**
 * Tests of the new block.
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Testing of basic pattern border.
   */
  @Test
  void TestPatternedRect() throws Exception {
    AsciiBlock patternedRect = new PatternBorder(new Rect('B', 3, 4), new char[] {'X'});
    assertEquals(5, patternedRect.width(),
        "Correct width for a pattern border");
    assertEquals(6, patternedRect.height(),
        "Correct height for a pattern border");
    assertEquals("""
                 XXXXX
                 XBBBX
                 XBBBX
                 XBBBX
                 XBBBX
                 XXXXX
                 """,
        TestUtils.toString(patternedRect),
        "Correct contents for a pattern border with 1 character");
        
    patternedRect = new PatternBorder(new Rect('B', 3, 4), new char[] {'X','X'});
    assertEquals(5, patternedRect.width(),
        "Correct width for a pattern border");
    assertEquals(6, patternedRect.height(),
        "Correct height for a pattern border");
    assertEquals("""
                 XXXXX
                 XBBBX
                 XBBBX
                 XBBBX
                 XBBBX
                 XXXXX
                 """,
        TestUtils.toString(patternedRect),
        "Correct contents for a pattern border with 1 (repeating) character");
  } // TestPatternedRect()

  /**
   * Testing of simple pattern border.
   */
  @Test
  void TestSimplePatternedRect() throws Exception {
    AsciiBlock patternedRect = new PatternBorder(new Rect('B', 3, 4), new char[] {'X','Y','Z'});
    assertEquals(5, patternedRect.width(),
        "Correct width for a pattern border");
    assertEquals(6, patternedRect.height(),
        "Correct height for a pattern border");
    assertEquals("""
                 XYZXY
                 YBBBZ
                 ZBBBX
                 XBBBY
                 YBBBZ
                 ZXYZX
                 """,
        TestUtils.toString(patternedRect),
        "Correct contents for a pattern border with 3 characters");
  } // TestSimplePatternedRect()

  /**
   * Testing of empty pattern borders.
   */
  @Test
  void TestEmptyPatternedRect() throws Exception {
    AsciiBlock patternedRect = new PatternBorder(new Empty(), new char[] {'X','Y','Z'});
    assertEquals(2, patternedRect.width(),
        "Correct width for a pattern border");
    assertEquals(2, patternedRect.height(),
        "Correct height for a pattern border");
    assertEquals("""
                 XY
                 YZ
                 """,
        TestUtils.toString(patternedRect),
        "Correct contents for an empty pattern border with 3 characters");
  } // TestEmptyPatternedRect()

  /**
   * Testing of pattern borders with a pattern larger than can be shown.
   */
  @Test
  void TestLargePatternedRect() throws Exception {
    AsciiBlock patternedRect = new PatternBorder(new Rect('B', 1, 1), new char[] {'1','2','3','4','5','6','7','8','9','0'});
    assertEquals(3, patternedRect.width(),
        "Correct width for a pattern border");
    assertEquals(3, patternedRect.height(),
        "Correct height for a pattern border");
    assertEquals("""
                 123
                 2B4
                 345
                 """,
        TestUtils.toString(patternedRect),
        "Correct contents for a pattern border with many characters");
  } // TestLargePatternedRect()

  /**
   * Testing of nested pattern borders.
   */
  @Test
  void TestNestedPattern() throws Exception {
    AsciiBlock patternedRect = new PatternBorder(new PatternBorder(new Empty(), new char[] {'1','0'}), new char[] {'1','0'});
    assertEquals(4, patternedRect.width(),
        "Correct width for a pattern border");
    assertEquals(4, patternedRect.height(),
        "Correct height for a pattern border");
    assertEquals("""
                 1010
                 0101
                 1010
                 0101
                 """,
        TestUtils.toString(patternedRect),
        "Correct contents for a nested pattern border");
  } // TestNestedPattern()

  
  /**
   * Testing of nested pattern borders with varying patterns.
   */
  @Test
  void TestSuperNestedPattern() throws Exception {
    AsciiBlock patternedRect = new PatternBorder(new PatternBorder(new Empty(), new char[] {'1','0'}), new char[] {'X','Y','Z'});
    assertEquals(4, patternedRect.width(),
        "Correct width for a pattern border");
    assertEquals(4, patternedRect.height(),
        "Correct height for a pattern border");
    assertEquals("""
                 XYZX
                 Y10Y
                 Z01Z
                 XYZX
                 """,
        TestUtils.toString(patternedRect),
        "Correct contents for a nested pattern border with different characters");
  } // TestSuperNestedPattern()

  
  /**
   * Testing of invalid patterns.
   */
  @Test
  void TestEmptyPattern() throws Exception {
    
    assertThrows(Exception.class,
        () -> {AsciiBlock patternedRect = new PatternBorder(new Empty(),new char[] {});},
        "Throws error from invalid pattern");
  } // TestEmptyPattern()

} // class TestNewBlock
