import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yinshu {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int relNum = num;
            boolean flag = false;
            int leftNum = -1;
            int rightNum = -1;
            for (int i = 2; i * i <= num; i++) {
                while (relNum % i == 0) {
                    if (flag) {
                        leftNum = -1;
                        break;
                    }
                    leftNum = i;
                    relNum /= i;
                    flag = true;
                }
            }
            if (leftNum != -1) {
                rightNum = num / leftNum;
            }
            System.out.println(leftNum + " " + rightNum);
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            String[] strArr = str.split(",");
            if (strArr.length == 0) {
                System.out.println("/");
            } else {
                String leftUrl = strArr[0];
                if (leftUrl.length() > 0 && '/'==(leftUrl.charAt(leftUrl.length() - 1))) {
                    leftUrl = leftUrl.substring(0, leftUrl.length()-1);
                }
                String rightUrl = "";
                if (strArr.length == 2) {
                    rightUrl = strArr[1];
                    if ('/' == rightUrl.charAt(0)) {
                        rightUrl = rightUrl.substring(1);
                    }
                }
                System.out.println(leftUrl + "/" + rightUrl);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            ArrayList<Integer> subList = new ArrayList<>();
            ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
            zhaoShui2(str, 0, subList, resultList);

            System.out.println(isShui(371));
        }
    }
    private static boolean flag = false;
    private static void zhaoShui2(String str, int index, ArrayList<Integer> subList, ArrayList<ArrayList<Integer>> resultList) {
        if (index == str.length()) {
            // 成功的递归结束
            resultList.add(new ArrayList<>(subList));
            subList.clear();
            flag = true;
        } else {
            int number = 0;
            for (int i = index; i < str.length(); i++) {
                number += (int) str.charAt(i);
                if (number < 100) {
                    continue;
                }
                if (number > 999) {
                    break;
                }
                if (isShui(number)) {
                    subList.add(i);
                    zhaoShui2(str, i + 1, subList, resultList);

                }
            }
            if (!flag && subList.size() > 0) {
                subList.remove(subList.size() - 1);
            }
        }
    }

    private static boolean isShui(int num) {
        int bnum = num / 100;
        int snum = (num - bnum * 100) / 10;
        int gnum = (num - bnum * 100 - snum * 10);

        if (Math.pow(bnum, 3) + Math.pow(snum, 3) + Math.pow(gnum, 3) == num) {
            return true;
        }
        return false;

    }
}
