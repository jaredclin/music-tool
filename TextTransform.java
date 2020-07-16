import java.lang.Math;

public class TextTransform {
    //main method traversing through all stages
  public void transform(Key key, int startnote, String text) {
    Note [] notes = new Note[text.length()];
    String[] keyNotes = key.notes;
    textToCharValues(notes, text);
    charValuesToDeltaValues(notes);
    deltaValuesToNumeric(notes, startnote);
    numericToNotes(notes, keyNotes);
    displayKey(keyNotes);
    Note.print(notes);
    return;
  }

  private static void displayKey(String[] keyNotes) {
    System.out.println("\n\nAvailable notes:");
    for (int i = 0; i < 7; i++ ) {
      System.out.print(keyNotes[i] + " ");
    }
  }

  private static void textToCharValues(Note[] notes, String text) {
    for (int i = 0; i < text.length(); i++) {
      Note n = new Note();
      notes[i] = n;
      notes[i].charValue = (int) text.charAt(i);
    }
    return;
  }

  private static void charValuesToDeltaValues(Note[] notes) {
    notes[0].deltaValue = 0;
    for (int i = 1; i < notes.length; i++) {
      notes[i].deltaValue = (notes[i].charValue - notes[i-1].charValue) % 7;
    }
    return;
  }

  private static void deltaValuesToNumeric(Note[] notes, int startnote) {
    notes[0].numeric = startnote;
    for (int i = 1; i < notes.length; i++) {
      notes[i].numeric = notes[i-1].numeric + notes[i].deltaValue;
    }
    return;
  }

  private static void numericToNotes(Note[] notes, String[] keyNotes) {
    for (int i = 0; i < notes.length; i++) {
      int octave = (int) Math.floor((double) notes[i].numeric / 7);
      int num = notes[i].numeric;
        while(num > 6) {
          num = num - 7;
        }
        while(num < 0) {
          num = num + 7;
        }
      notes[i].note = keyNotes[num];
      notes[i].octave = octave;
    }
    return;
  }
}