import java.io.Console;
public class Interaction {
  private static Console con = System.console();
  public static int choose(String[] options) {
    int input = 0;
    String option_list = "";
    for(int i = 0; i<options.length; i++) { option_list += "["+(i+1)+" "+options[i]+"] "; }
    while(true) {
      Writer.yellow(option_list);
      try {
        String enter = con.readLine();
        input = (enter.toCharArray().length == 0)? 1 : Integer.parseInt(enter);
      }
      catch(NumberFormatException e) { Writer.red("Please input a valid number"); }
      if((input < 1) || (input > options.length)) { Writer.red("Invalid input! 1-"+options.length+" please."); }
      else { break; }
    }
    return input;
  }
}
