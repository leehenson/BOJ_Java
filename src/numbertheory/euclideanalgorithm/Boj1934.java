package numbertheory.euclideanalgorithm;

import java.util.*;

public class Boj1934 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스

        for (int i = 0; i < t; i++) { // t만큼 반복
            int a = sc.nextInt(); // 1번째 수
            int b = sc.nextInt(); // 2번째 수
            int result = a * b / gcd(a, b); // 결괏값

            System.out.println(result); // 결괏값 출력
        }
    }

    // 최대공약수를 구하는 메서드
    private static int gcd(int a, int b) {
        if (b == 0) { // b가 0이면
            return a; // a가 최대 공약수
        } else {
            return gcd(b, a % b); // 재귀 함수 형태로 구현
        }
    }
}
