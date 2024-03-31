import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> listList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("johnsmith@mail.com");
        list.add("john_newyork@mail.com");
        listList.add(list);
        list = new ArrayList<>();
        list.add("John");
        list.add("johnsmith@mail.com");
        list.add("john00@mail.com");
        listList.add(list);
        list = new ArrayList<>();
        list.add("Mary");
        list.add("mary@mail.com");
        listList.add(list);
        list = new ArrayList<>();
        list.add("John");
        list.add("johnnybravo@mail.com");
        listList.add(list);
        Solution solution = new Solution();
        solution.accountsMerge(listList);
    }
}