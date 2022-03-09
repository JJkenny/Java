import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

    private static List<LinkedList<Integer>> ans = new LinkedList<>();
    private static int temp = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        char[] str = s.toCharArray();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(str, p,  path);
        System.out.println(ans);
        int min = 0;
        for (LinkedList<Integer> a: ans) {
            int strLen = a.getLast() - a.getFirst() + 1 - p.length();
            if (min == 0) {
                min = strLen;
            } else {
                min = Math.min(strLen, min);
            }
        }
        System.out.println(min);
    }
    private static void dfs(char[] s, String p, LinkedList<Integer> path) {
        if (path.size() == p.length()) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] != p.charAt(temp) || (! path.isEmpty() && i <= path.getLast())) {
                continue;
            }
            path.add(i);
            temp++;
            dfs(s, p, path);
            path.removeLast();
            temp--;
        }
    }
}
