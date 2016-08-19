import java.io.Console;
public class Interaction {
  private static Console con = System.console();
  public static int choose(String[] options) {
    String option_list = "";
    // int i = 1;
    for(int i = 0; i<options.length; i++) { option_list += "["+(i+1)+" "+options[i]+"] "; }
    int input = -1;
    while(input == -1){
      try {
        Writer.yellow(option_list);
        input = Integer.parseInt(con.readLine());
      } catch(NumberFormatException e) { Writer.red("Please input a valid number"); continue; }
      if((input < 1) || (input > options.length)) {
        Writer.red("Invalid input! 1-"+options.length+" please.");
        input = -1; continue;
      }
    }
    return input;
  }
}
