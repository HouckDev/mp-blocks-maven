package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Boxed;
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
        "M: Correct width for a pattern border");
    assertEquals(6, patternedRect.height(),
        "M: Correct height for a pattern border");
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
  } // TestPatternedRect()

  /**
   * Testing of simple pattern border.
   */
  @Test
  void TestSimplePatternedRect() throws Exception {
    AsciiBlock patternedRect = new PatternBorder(new Rect('B', 3, 4), new char[] {'X','Y','Z'});
    assertEquals(5, patternedRect.width(),
        "M: Correct width for a pattern border");
    assertEquals(6, patternedRect.height(),
        "M: Correct height for a pattern border");
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

} // class TestNewBlock
