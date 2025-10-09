package numbertheory.eulerphi;

import java.util.*;

public class Boj11689 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // 어떤 수
        long result = n; // 결괏값

        for (int i = 2; i <= Math.sqrt(n); i++) { // 2부터 n의 제곱근까지 반복
            if (n % i == 0) { // 현재 값이 소인수라면
                result -= result / i; // 결괏값 = 결괏값 - 결괏값 / 현재값
            }

            // n에서 현재 소인수 내역을 제거
            while (n % i == 0) {
                n /= i;
            }
        }

        if (n > 1) { // n이 마지막 소인수일 때
            // 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
            result -= result / n; // 결괏값 = 결괏값 - 결괏값 / 현재값
        }

        System.out.println(result); // 결괏값 출력
    }
}
