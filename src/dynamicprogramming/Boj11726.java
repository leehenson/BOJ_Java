package dynamicprogramming;

import java.util.*;

public class Boj11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1001];

        arr[1] = 1; // n = 1일 때 타일 채우는 경우의 수
        arr[2] = 2; // n = 2일 때 타일 채우는 경우의 수

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007; // 바텀-업 방식으로 점화식 사용
        }

        System.out.println(arr[n]);
    }
}
