public class Test {
    public static void main (String[] args) {
        Key c = new Key("C", false);
        System.out.println("C"+":\t" + c.toString());
        Key cm = new Key("C", true);
        System.out.println("C"+":\t" + cm.toString());
        Key csharp = new Key("C#", false);
        System.out.println("C#"+":\t" + csharp.toString());

    }
}