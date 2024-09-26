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
 * Create and print an amazing 80x24 ASCII artwork. Prints first name in large ascii art,
 * surrounding by patter made by last name, which is then surrounding by a sea of psuedo random
 * characters.
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
    char[] pseudo = new char[100];
    char[] pseudo1 = new char[100];
    char[] pseudo2 = new char[100];
    char[] pseudoroot = new char[] {'@', '#', '%', '$', '&', '*'};
    for (int z = 0; z < 100; z++) {
      pseudo[z] = pseudoroot[(int) Math.floor(Math.random() * pseudoroot.length)];
      pseudo1[z] = pseudoroot[(int) Math.floor(Math.random() * pseudoroot.length)];
      pseudo2[z] = pseudoroot[(int) Math.floor(Math.random() * pseudoroot.length)];
    } // for
    char[][] pseudos = new char[][] {pseudo, pseudo1, pseudo2};
    PrintWriter pen = new PrintWriter(System.out, true);
    AsciiBlock art = new Rect('^', 80, 24);
    AsciiBlock art2 = new HComp(VAlignment.CENTER, new AsciiBlock[] {new Rect(' ', 3, 1),
        new Surrounded(new PatternBorder(new VComp(HAlignment.CENTER, new AsciiBlock[] {
            new Line("|\\   __  \\|\\   __  \\|\\   ___ \\|\\  ___ \\  |\\   ___  \\    "),
            new Line(
                "\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\   __/|\\  \\  \\\\ \\  \\   "),
            new Line(" \\ \\   ____\\ \\   __  \\ \\  \\ \\\\ \\ \\  \\_|/_\\  \\  \\\\ \\  \\  "),
            new Line(
                "  \\ \\  \\___|\\ \\  \\ \\  \\ \\  \\_\\\\ \\ \\  \\_|\\ \\  \\  \\\\ \\  \\ "),
            new Line("   \\ \\__\\    \\ \\__\\ \\__\\ \\_______\\ \\_______\\  \\__\\\\ \\__\\"),
            new Line("    \\|__|     \\|__|\\|__|\\|_______|\\|_______| \\|__| \\|__|"),
            }),
            new char[] {'H', 'O', 'U', 'C', 'K'}), ' '),
        new Rect(' ', 3, 1)});
    for (int z = 0; z < 7; z++) {
      art2 = new PatternBorder(art2, pseudos[(int) Math.floor(Math.random() * pseudos.length)]);
    } // for
    AsciiBlock.print(pen, art);
    AsciiBlock.print(pen, art2);
    pen.close();
  } // main(String[])
} // class Art80x24
