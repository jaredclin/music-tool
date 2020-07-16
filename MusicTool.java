import java.util.HashMap;
import java.util.Scanner;

public class MusicTool {    
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        HashMap<String, Integer> keys = new HashMap<String, Integer>();
        keys.put("C", 0);
        keys.put("C#", 1);
        keys.put("D", 2);
        keys.put("D#", 3);
        keys.put("E", 4);
        keys.put("F", 5);
        keys.put("F#", 6);
        keys.put("G", 7);
        keys.put("G#", 8);
        keys.put("A", 9);
        keys.put("A#", 10);
        keys.put("B", 11);
        String input;
        String key = "C";
        Boolean minor = false;
        Key k;
        TextTransform tt = new TextTransform();

        System.out.println("Music Tool\n");
        System.out.print("Enter Key (a-g, #): ");
        key = kb.nextLine();
        
        System.out.print("Minor? (y/n): ");
        String m = kb.nextLine();
        
        if (m.toLowerCase().equals("y")) {
            minor=true;
        }
        else {minor=false;}
        k = new Key(keys.get(key.toUpperCase()), minor);

        System.out.println("\nType 'restart' to choose a new key.");
        System.out.println("Type 'end' to terminate the program.");

        while(true) {
            System.out.println("\nEnter Text:");
            input = kb.nextLine();
            if(input.equals("restart")) {
                System.out.print("Enter Key (a-g, #): ");
                key = kb.nextLine();
                
                System.out.print("Minor? (y/n): ");
                m = kb.nextLine();
                
                if (m.toLowerCase().equals("y")) {
                    minor=true;
                }
                else {minor=false;}
                k = new Key(keys.get(key.toUpperCase()), minor);
                continue;
            }
            if(input.equals("end")) {
                kb.close();
                System.exit(0);
            }

            input = input.replaceAll("\\s+","");
            input = input.toLowerCase();
            System.out.print("Enter Start Note (0-7): ");
            int start = Integer.parseInt(kb.nextLine());
            tt.transform(k, start, input);

        }
    }
}