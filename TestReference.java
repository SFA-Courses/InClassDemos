public class TestReference {
    public static void main(String[] args) {
        int p = 5;
        int q = 5;
        System.out.println(p==q);

        Integer x = new Integer(5);
        Integer y = new Integer(5);
        System.out.println(x==y);
        System.out.println(x.equals(y));
        Integer z = x;
        System.out.println(x==z);
        System.out.println(x.equals(z));
    }
}
