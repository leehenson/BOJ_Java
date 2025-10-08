package numbertheory.primenumber;

import java.util.*;

public class Boj1016 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong(); // 최솟값
        long max = sc.nextLong(); // 최댓값

        // 최댓값과 최솟값의 차이만큼 배열 선언
        boolean[] check = new boolean[(int) (max - min + 1)]; // min ~ max 사이에 제곱수 판별 배열
        int count = 0; // 제곱이 아닌 수 카운트

        // 2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복
        for (long i = 2; i * i <= max; i++) { // 단순 탐색이 아닌 제곱수 형태로 증가
            long pow = i * i; // 제곱수
            long start = min / pow; // 시작 인덱스

            if (min % pow != 0) { // 나머지가 0이 아니면
                start++; // 시작 인덱스 1 증가, 나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작됨
            }

            for (long j = start; pow * j <= max; j++) { // 제곱수의 배수 형태로 탐색
                // j * pow가 max보다 작을 때 최솟값, 최댓값 사이의 제곱수이므로 check 배열에 저장
                check[(int) ((j * pow) - min)] = true; // 제곱수를 true로 변경
            }
        }

        for (int i = 0; i <= max - min; i++) { // 0부터 (max - min)까지 탐색
            if (!check[i]) { // check 배열에 제곱이 아닌 수라면
                count++; // count 증가
            }
        }

        System.out.println(count); // count 출력
    }
}
