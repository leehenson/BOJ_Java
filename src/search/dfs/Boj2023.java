package search.dfs;

import java.util.*;

public class Boj2023 {

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 자릿수

        // 숫자 2, 3, 5, 7만 일의 자리의 소수이기 때문에 해당 수로 탐색 시작, 일의 자리 시작이므로 자릿수는 1
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    // dfs 구현
    private static void dfs(int num, int digit) {
        if (digit == n) { // 자릿수가 n이고
            if (isPrime(num)) { // num이 소수이면
                System.out.println(num); // num 출력
            }
            return; // 탐색 종료
        }

        for (int i = 1; i <= 9; i += 2) { // 짝수면 소수가 될 수 없기 때문에 홀수만 일의 자리에 추가
            if (isPrime(num * 10 + i)) { // 뒤에 붙는 수가 홀수이면서 소수일 때
                dfs(num * 10 + i, digit + 1); // 재귀 함수로 자릿수를 늘리면서 dfs 실행
            }
        }
    }

    // 소수 구하는 메서드
    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) { // 2부터 num / 2까지 나누기
            if (num % i == 0) { // 나머지가 0이면 소수가 아님
                return false;
            }
        }
        return true; // 끝까지 나머지가 0이 아니면 소수
    }
}
