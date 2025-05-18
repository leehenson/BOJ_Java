package datastructure.stackandqueue;

import java.io.*;
import java.util.*;

public class Boj10811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1; // i의 값은 실제 인덱스보다 1 크기 때문에 -1를 해준다.
            int j = Integer.parseInt(st.nextToken()) - 1; // j의 값은 실제 인덱스보다 1 크기 때문에 -1를 해준다.

            while (i < j) { // 투포인터 알고리즘으로 i는 1씩 증가 j는 1씩 감소시킬 것이기 때문에 i가 j보다 작을 떄까지 반복한다.
                int temp = arr[i]; // 배열의 i값을 temp 변수에 담아둔다.
                arr[i] = arr[j]; // 배열의 i값과 배열의 j값을 바꾼다.
                arr[j] = temp; // 배열의 i값에 temp 값을 넣어준다.
                i++; // i의 값을 1 증가시킨다.
                j--; // j의 값을 1 감소시킨다.
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // 배열의 값을 출력한다.
        }
    }
}
