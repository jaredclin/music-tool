public class Key {
    String[] availableNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    String[] notes = new String[7];

    public Key (int root, boolean minor) {
        notes[0] = availableNotes[root%12];
        notes[1] = availableNotes[(root+2)%12];
        if (minor) {
            notes[2] = availableNotes[(root+3)%12];
            notes[3] = availableNotes[(root+5)%12];
            notes[4] = availableNotes[(root+7)%12];
            notes[5] = availableNotes[(root+8)%12];
            notes[6] = availableNotes[(root+10)%12];
        }
        else {
            notes[2] = availableNotes[(root+4)%12];
            notes[3] = availableNotes[(root+5)%12];
            notes[4] = availableNotes[(root+7)%12];
            notes[5] = availableNotes[(root+9)%12];
            notes[6] = availableNotes[(root+11)%12];
        }
    }
    public String toString() {
        return notes[0] + "\t" + notes[1] + "\t" + notes[2] + "\t" + notes[3] + "\t" + notes[4] + "\t" + notes[5] + "\t" + notes[6];
    }
}