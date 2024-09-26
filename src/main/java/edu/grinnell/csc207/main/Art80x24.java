package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.PatternBorder;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Surrounded;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.VComp;
import java.io.PrintWriter;

/**
 * Create and print an amazing 80x24 ASCII artwork.
 *
 * @author Paden Houck
 */
public class Art80x24 {
  /**
   * Create the artwork.
   *
   * @param args Command-line arguments (currently ignored).
   *
   * @exception Exception If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    AsciiBlock art = new Rect('^', 80, 24);
    AsciiBlock art2 = new PatternBorder(new PatternBorder(
        new HComp(VAlignment.CENTER, new AsciiBlock[] {new Surrounded(new PatternBorder(
            new VComp(HAlignment.CENTER, new AsciiBlock[] {
                new Line(" ________  ________  ________  _______   ________      "),
                new Line("|\\   __  \\|\\   __  \\|\\   ___ \\|\\  ___ \\ |\\   ___  \\    "),
                new Line(
                    "\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\   __/|\\ \\  \\\\ \\  \\   "),
                new Line(
                    " \\ \\   ____\\ \\   __  \\ \\  \\ \\\\ \\ \\  \\_|/_\\ \\  \\\\ \\  \\  "),
                new Line(
                    "  \\ \\  \\___|\\ \\  \\ \\  \\ \\  \\_\\\\ \\ \\  \\_|\\ \\ \\  \\\\ \\  \\ "),
                new Line(
                    "   \\ \\__\\    \\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\__\\\\ \\__\\"),
                new Line("    \\|__|     \\|__|\\|__|\\|_______|\\|_______|\\|__| \\|__|"),}),
            new char[] {'H', 'O', 'U', 'C', 'K'}), ' ')}),
        new char[] {'@', '#', '$', '%', '&', '*'}), new char[] {'@', '#', '$', '%', '&', '*'});
    AsciiBlock.print(pen, art);
    AsciiBlock.print(pen, art2);
    pen.close();
  } // main(String[])
} // class Art80x24
