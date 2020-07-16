import java.util.Map;
import java.util.HashMap;

public class Note {
  public static Map<Integer, String[]> SHEET_MAP;
  int charValue;
  int deltaValue;
  int numeric;
  String note;
  int octave;

  public Note () {
  }

  public static void print(Note[] notes) {
    SHEET_MAP = new HashMap<Integer, String[]>();
    String[] line_1 = new String[notes.length + 1];
    String[] line0 = new String[notes.length + 1];
    String[] line1 = new String[notes.length + 1];
    line_1[0] = "-1|";
    line0[0] = "0|";
    line1[0] = "1|";
    SHEET_MAP.put(-1, line_1);
    SHEET_MAP.put(0, line0);
    SHEET_MAP.put(1, line1);

    System.out.println("\n\n");
    int lowerbound = -1;
    int upperbound = 1;

    for (int i = -1; i < 2; i++) {
      String[] sheet = SHEET_MAP.get(i);
      for (int j = 1; j< sheet.length; j++) {
        sheet[j] = "   ";
      }
    }

    for (int i = 0; i < notes.length; i++) {
      int octave = notes[i].octave;
      if (octave > upperbound || octave < lowerbound) {
        String[] newSheet = new String[notes.length + 1];
        newSheet[0] = Integer.toString(octave) + "|";
        for (int j = 1; j< notes.length + 1; j++) {
          newSheet[j] = "   ";
        }
        SHEET_MAP.put(octave, newSheet);
        if (octave > upperbound) upperbound = octave;
        if (octave < lowerbound) lowerbound = octave;
      }
      String[] sheet = SHEET_MAP.get(octave);
        sheet[i+1] = notes[i].note;
    }

    for (int i = upperbound; i > lowerbound-1; i--) {
      String[] sheet = SHEET_MAP.get(i);
      for (int j = 0; j< sheet.length; j++) {
        System.out.print(String.format("%3s", sheet[j]));
      }
      System.out.println("\n");
    }
  }
}