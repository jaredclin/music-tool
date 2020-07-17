import java.util.HashMap;
import java.util.Scanner;

public class MusicTool {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input;
        String key = "C";
        Boolean minor = false;
        KeyDefine k;
        TextTransform tt = new TextTransform();

        System.out.println("Music Tool\n");
        System.out.println("The following app follows the convention of the circle of fifths\n");
        System.out.println("                 C \n");
        System.out.println("      F    d     a     e    G \n");
        System.out.println("  Bb     g               b     D\n");
        System.out.println("Eb     c                   f#     A \n");
        System.out.println("  Ab     f               c#     E\n");
        System.out.println("     Db     bb   eb    g#    B\n");
        System.out.println("                 Gb \n");
        System.out.println("The outer circle(Uppercase) is for major keys\n");
        System.out.println("The inner circle(Lowercase) is for minor keys\n");
        System.out.println("Please use these convention moving forward\n");
        System.out.print("Enter Key (a-g, b/#): ");
        key = kb.nextLine();

        System.out.print("Minor? (y/n): ");
        String m = kb.nextLine();

        if (m.toLowerCase().equals("y")) {
            minor = true;
        } else {
            minor = false;
        }
        k = new KeyDefine(key.toUpperCase(), minor);
        System.out.print(k.toString());


        System.out.println("\nType 'restart' to choose a new key.");
        System.out.println("Type 'end' to terminate the program.");

        while (true) {
            System.out.print("\nEnter Text: ");
            input = kb.nextLine();
            if (input.equals("restart")) {
                System.out.print("Enter Key (a-g, #): ");
                key = kb.nextLine();

                System.out.print("Minor? (y/n): ");
                m = kb.nextLine();

                if (m.toLowerCase().equals("y")) {
                    minor = true;
                } else {
                    minor = false;
                }
                k = new KeyDefine(key.toUpperCase(), minor);
                continue;
            }
            if (input.equals("end")) {
                kb.close();
                System.exit(0);
            }

            input = input.replaceAll("\\s+", "");
            input = input.toLowerCase();
            System.out.print("Enter Start Note (0-7): ");
            int start = Integer.parseInt(kb.nextLine());
            tt.transform(k, start, input);


        }
    }
}