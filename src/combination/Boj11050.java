package combination;

import java.util.*;

public class Boj11050 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];

        // 배열 초기화
        for (int i = 0; i <= n; i++) {
            arr[i][1] = i; // i개에서 i개를 선택하는 경우의 수는 i개
            arr[i][0] = 1; // i개에서 1개도 선택하지 않는 경우의 수는 1개
            arr[i][i] = 1; // i개에서 모두 선택하는 경우의 수는 1개
        }

        // 점화식으로 배열 완성
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]; // 조합을 구하는 점화식
            }
        }

        System.out.println(arr[n][k]);
    }
}
