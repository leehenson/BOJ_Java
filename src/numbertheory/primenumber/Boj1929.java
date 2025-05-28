package numbertheory.primenumber;

import java.util.*;

public class Boj1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n + 1]; // 인덱스는 0부터 시작하기 때문에 숫자와 인덱스 번호를 맞추기 위해 배열의 크기를 n+1로 설정

        for (int i = 2; i < arr.length; i++) { // 1은 소수가 아니기 때문에 2부터 n까지 초기화 해준다.
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) { // n의 범위까지 소수를 구할 때 n보다 작은 숫자는 항상 n의 제곱근보다 작은 약수를 갖기 떄문에 n의 제곱근까지만 반복한다.
            if (arr[i] == 0) { // 배열의 숫자가 0이면(소수가 아니면)
                continue; // 건너뛰기
            }
            for (int j = i + i; j < arr.length; j = j + i) { // i의 배수들을 탐색하면서
                arr[j] = 0; // 모두 0으로 변경(소수가 아님을 체크)
            }
        }

        for (int i = m; i < arr.length; i++) { // m부터 n까지 반복
            if (arr[i] != 0) { // 소수이면
                System.out.println(arr[i]); // 출력
            }
        }
    }
}
