package edu.grinnell.csc207.blocks;

/**
 * A text block surrounded by a single letter.
 *
 * @author Paden Houck
 */
public class PatternBorder implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box.
   */
  AsciiBlock contents;

  /**
   * The character pattern we put around the box.
   */
  char[] pattern;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param blockContents The contents of the block.
   *
   * @param thePattern The pattern that we use to surround the block.
   */
  public PatternBorder(AsciiBlock blockContents, char[] thePattern) throws Exception {
    this.contents = blockContents;

    if (thePattern.length <= 0) {
      throw new Exception("Invalid Pattern");
    }
    this.pattern = thePattern;
  } // Surrounded(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception If the row is invalid.
   */
  public String row(int i) throws Exception {
    if (i == 0 || i == this.height() - 1) {
      // The top of the box
      String constructedString = "";
      for (int z = 0; z < this.width(); z++) {
        constructedString = constructedString + this.pattern[(z + i) % this.pattern.length];
      }
      return constructedString;
    } else if ((i > 0) && (i <= this.height())) {
      // Stuff within the box
      return this.pattern[(i) % this.pattern.length] + this.contents.row(i - 1)
          + this.pattern[(1 + this.contents.width() + i) % this.pattern.length];
    } else {
      throw new Exception("Invalid row " + i);
    } // if/else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.contents.height() + 2;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.contents.width() + 2;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return false; // STUB
  } // eqv(AsciiBlock)
} // class Surrounded
