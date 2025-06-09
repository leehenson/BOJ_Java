package datastructure.prefixsum;

import java.util.*;

public class Boj10986 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] sumArr = new long[n]; // 합 배열
        long[] counts = new long[m]; // 나머지당 갯수 배열
        long answer = 0; // 정답 갯수

        sumArr[0] = sc.nextLong(); // 맨 처음 입력값 저장
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextLong(); // 이전 값(이전까지의 합) + 현재 값으로 합 배열 초기화
        }

        for (int i = 0; i < n; i++) {
            int remainder = (int) (sumArr[i] % m); // 합 배열 값의 나머지 계산
            if (remainder == 0) { // 합 배열 값의 나머지가 0이면 처음부터 해당 값까지의 합의 나머지가 0으로 떨어지기 때문에 answer값 증가
                answer++;
            }
            counts[remainder]++; // m으로 나눈 나머지의 갯수 증가
        }

        for (int i = 0; i < m; i++) {
            if (counts[i] > 1) { // 나머지가 같은 수가 2개 이상이면
                answer = answer + (counts[i] * (counts[i] - 1) / 2); // 나머지가 같은 수의 갯수에서 2개씩을 뽑는 조합 계산하여 정답에 추가
            }
        }

        System.out.println(answer); // 정답 출력
    }
}
