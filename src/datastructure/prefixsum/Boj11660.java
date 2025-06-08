package datastructure.prefixsum;

import java.io.*;
import java.util.*;

public class Boj11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1]; // 원본 배열 선언
        int[][] sumArr = new int[n + 1][n + 1]; // 합 배열 선언

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 원본 배열 초기화
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + arr[i][j]; // 합 배열 초기화
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1]); // 구간 합 출력
        }
    }
}
