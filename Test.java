public class Test {
    public static void main (String[] args) {
        for (int i=0; i<12; i++) {
            Key c = new Key(i, false);
            System.out.println(i+":\t" + c.toString());
    
            Key cm = new Key(i, true);
            System.out.println(i+"m:\t" + cm.toString());
        }
    }
}