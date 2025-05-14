package datastructure.arrayandlist;

import java.io.*;
import java.util.*;

public class Boj11659 {

    public static void main(String[] args) throws IOException {
        // 한 줄에 최대 10만개의 많은 숫자가 들어올 수 있기 때문에 BufferedReader와 StringTokenizer를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCount = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int questionCount = Integer.parseInt(st.nextToken()); // 질의의 개수

        long[] sumArr = new long[numCount + 1]; // 합 배열 선언, 0번째 인덱스를 없는 거라 생각하기 위해 +1를 해준다.

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken()); // 이전 합 배열의 값과 현재의 값을 더하여 할당
        }

        // 입력된 합 배열 j의 값에 합 배열 i-1의 값을 빼면 된다.
        for (int q = 0; q < questionCount; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[j] - sumArr[i - 1]);
        }
    }
}
