package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The horizontal composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Paden Houck
 */
public class HComp implements AsciiBlock {
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
  VAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a horizontal composition of two blocks.
   *
   * @param alignment The way in which the blocks should be aligned.
   * @param leftBlock The block on the left.
   * @param rightBlock The block on the right.
   */
  public HComp(VAlignment alignment, AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {leftBlock, rightBlock};
  } // HComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a horizontal composition of multiple blocks.
   *
   * @param alignment The alignment of the blocks.
   * @param blocksToCompose The blocks we will be composing.
   */
  public HComp(VAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // HComp(Alignment, AsciiBLOCK[])

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
   * @exception Exception if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    if ((i >= 0) && (i <= this.height())) {
      // Stuff within the box
      String constructedString = "";
      for (AsciiBlock block : this.blocks) {
        int iOffset = i;
        switch (this.align) {
          case TOP:

            break;
          case BOTTOM:
            iOffset = iOffset - (this.height() - block.height());
            break;
          case CENTER:
            iOffset = iOffset - ((this.height() - block.height()) / 2);
            break;
          default:
            break;
        }
        if ((iOffset >= 0) && (iOffset < block.height())) {
          constructedString = constructedString + block.row(iOffset);
        } else {
          constructedString = constructedString + " ".repeat(block.width());
        }
      }

      return constructedString;
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
    int maxHeight = 0;
    for (AsciiBlock block : this.blocks) {
      maxHeight = Math.max(maxHeight, block.height());
    }
    return maxHeight;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int totalWidth = 0;
    for (AsciiBlock block : this.blocks) {
      totalWidth = totalWidth + block.width();
    }
    return totalWidth;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof HComp) && (this.eqv((HComp) other)));
  } // eqv(AsciiBlock)

  /**
   * Determine if another HComp is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(HComp other) {
    if (this.align != other.align) {
      return false;
    } // if
    if (this.blocks.length != other.blocks.length) {
      return false;
    } // if
    for (int z = 0; z < this.blocks.length; z++) {
      if (!this.blocks[z].eqv(other.blocks[z])) {
        return false;
      } // if
    } // for
    return true;
  } // eqv(HComp)
} // class HComp
