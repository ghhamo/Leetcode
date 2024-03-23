public class Main {
    public static void main(String[] args) {
        UF uf = new UF();
        uf.equationsPossible(new String[]{"f==a","a==b","f!=e","a==c","b==e","c==f"});
    }
}