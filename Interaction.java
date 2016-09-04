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
  public static String get_string(String prompt) {
    String input;
    while(true) {
      Writer.with_no_nl(prompt+": ",Writer.YELLOW);
      input = con.readLine();
      if(input.toCharArray().length == 0){ Writer.red("Input invalid. Type something!"); }
      else { break; }
    }
    return input;
  }
}
