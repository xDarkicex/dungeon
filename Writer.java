public class Writer {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final void write(String string, String color, boolean with_color) {
    string += "\n";
    try {
      for(char c : string.toCharArray()) {
        if(with_color) { System.out.print(color+c+ANSI_RESET); }
        else { System.out.print(c); }
        Thread.sleep(5);
      }
    }
    catch(InterruptedException e) { }
  }
  public static final void say(Object obj) { write(obj.toString(),"",false); }
  // With color helper
  private static final void with(Object obj, String color) { Writer.write(obj.toString(),color,true); }
  // Colors!
  public static final void red(Object o) { Writer.with(o,ANSI_RED); }
  public static final void green(Object o) { Writer.with(o,ANSI_GREEN); }
  public static final void blue(Object o) { Writer.with(o,ANSI_BLUE); }
  public static final void yellow(Object o) { Writer.with(o,ANSI_YELLOW); }
  public static final void cyan(Object o) { Writer.with(o,ANSI_CYAN); }
  // Aliases to make life interesting
  public static final void debug(Object o) { Writer.yellow(o); }
}
