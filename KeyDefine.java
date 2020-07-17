
import java.util.HashMap;

public class KeyDefine {
    String[] availableNotes = {"C", "D", "E", "F", "G", "A", "B"};
    String[] notes = new String[7];

    // Hashmap index is used to make sure that the notes are display in the right order(root A display a b c d e...)
    // and has no other use. Functions relatively the same as the hashmap in Key.class but shrunk to 7 index because
    // sharps and flats are handled in other places
    HashMap<String, Integer> index = new HashMap<String, Integer>() {
        {
            put("C", 0);
            put("D", 1);
            put("E", 2);
            put("F", 3);
            put("G", 4);
            put("A", 5);
            put("B", 6);
        }
    };
    // Hashmap keys is the indexing of notes by clockwise motion on the circle of fifths, starting on C, this is used
    // since the index number can tell us which half of the circle the root note is on, and adjust to either displaying
    // sharp or displaying flat. From index 0 -5 the motion is clockwise, from index 6 - 11 motion is counter clockwise
    HashMap<String, Integer> keys = new HashMap<String, Integer>() {
        {
            put("C", 0);
            put("G", 1);
            put("D", 2);
            put("A", 3);
            put("E", 4);
            put("B", 5);
            put("F", 6);
            put("BB", 7);
            put("EB", 8);
            put("AB", 9);
            put("DB", 10);
            put("GB", 11);
        }

    };
    // Hashmap relativeMajor is used to find the relative major of a minor key if prompted
    HashMap<String, String> relativeMajor = new HashMap<String, String>() {
        {
            put("A", "C");
            put("E", "G");
            put("B", "D");
            put("F#", "A");
            put("C#", "E");
            put("G#", "B");
            put("EB", "GB");
            put("BB", "DB");
            put("F", "AB");
            put("C", "EB");
            put("G", "BB");
            put("D", "F");
        }

    };
    // Hashmap sharps is indexing of the sharp notes in order.
    HashMap<Integer, String> sharps = new HashMap<Integer, String>()
    {
        {
            put(0, "F");
            put(1, "C");
            put(2, "G");
            put(3, "D");
            put(4, "A");
            put(5, "E");
        }
    };
    // Hashmap flats is indexing of the flat notes in order.
    HashMap<Integer, String> flats = new HashMap<Integer, String>()
    {
        {
            put(0, "B");
            put(1, "E");
            put(2, "A");
            put(3, "D");
            put(4, "G");
            put(5, "C");
        }
    };

    public KeyDefine (String rootNote, boolean minor) {
        boolean rightSide;
        char rootLevel = rootNote.charAt(0);
        String rootDefine = String.valueOf(rootLevel);
        if (minor)
        {
            rootNote = relativeMajor.get(rootNote);
        }
        int scale = index.get(rootDefine);
        int root = keys.get(rootNote);
        if (root <= 5)
        {
            rightSide = true;
        }
        else
        {
            rightSide = false;
        }


        notes[0] = availableNotes[scale%7];
        notes[1] = availableNotes[(scale+1)%7];
        notes[2] = availableNotes[(scale+2)%7];
        notes[3] = availableNotes[(scale+3)%7];
        notes[4] = availableNotes[(scale+4)%7];
        notes[5] = availableNotes[(scale+5)%7];
        notes[6] = availableNotes[(scale+6)%7];

        if (rightSide)
        {
            for (int i = 0; i < root; i++)
            {
                String comp = sharps.get(i);
                for (int j = 0; j <= 6; j++)
                {
                    if (comp.compareTo(notes[j]) == 0)
                    {
                        notes[j] = notes[j].concat("#");

                    }
                }

            }
        }
        else
        {
            root = root - 6;
            for (int i = 0; i < root + 1; i++)
            {
                String comp = flats.get(i);
                for (int j = 0; j <= 6; j++)
                {
                    if (comp.compareTo(notes[j]) == 0)
                    {
                        notes[j] = notes[j].concat("b");

                    }
                }

            }

        }


    }
    public String toString() {
        return notes[0] + "\t" + notes[1] + "\t" + notes[2] + "\t" + notes[3] + "\t" + notes[4] + "\t" + notes[5] + "\t" + notes[6];
    }
}