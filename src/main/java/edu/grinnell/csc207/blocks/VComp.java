package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class VComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The blocks.
   */
  AsciiBlock[] blocks;

  /**
   * How the blocks are aligned.
   */
  HAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param topBlock
   *   The block on the top.
   * @param bottomBlock
   *   The block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock,
      AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
  } // VComp(HAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
   */
  public VComp(HAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // VComp(HAlignment, AsciiBLOCK[])

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
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    if ((i >= 0) && (i <= this.height())) {
      // Stuff within the box
      String constructedString = "";
      AsciiBlock block = null;
      int iOffset = 0;
      for (int z = 0; z < this.blocks.length; z ++) {
        if (iOffset + this.blocks[z].height() > i) {
          block = this.blocks[z];
          switch (this.align) {
            case LEFT:
              constructedString = block.row(i - iOffset) + " ".repeat(this.width() - block.width());
              
              break;
            case RIGHT:
             constructedString = " ".repeat(this.width() - block.width()) + block.row(i - iOffset);
              break;
            case CENTER:
              constructedString = " ".repeat((this.width() - block.width()) / 2) + block.row(i - iOffset) + " ".repeat(this.width() - ((this.width() - block.width()) / 2 + block.width()));
              break;
            default:
              break;
          } // switch
          return constructedString;
        } // if
        iOffset = iOffset + this.blocks[z].height();
      } // for
      throw new Exception("Invalid block " + i);
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
    int totalheight = 0;
    for (AsciiBlock block: this.blocks) {
      totalheight = totalheight + block.height();
    }
    return totalheight;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int maxWidth = 0;
    for (AsciiBlock block: this.blocks) {
      maxWidth = Math.max(maxWidth, block.width());
    }
    return maxWidth;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other
   *   The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return false;       // STUB
  } // eqv(AsciiBlock)
} // class VComp
