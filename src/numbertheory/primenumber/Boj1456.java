package numbertheory.primenumber;

import java.util.*;

public class Boj1456 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(); // 시작 수
        long b = sc.nextLong(); // 종료 수
        long[] arr = new long[10000001]; // 소수 배열
        int count = 0; // 정답값

        for (int i = 2; i < arr.length; i++) { // 10의 14제곱의 제곱근인 1000000까지 반복
            arr[i] = i; // 각각의 인덱스값으로 초기화
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) { // 1000000의 제곱근까지만 수행
            if (arr[i] == 0) { // 소수가 아니면 넘어감
                continue;
            }

            for (int j = i + i; j < arr.length; j += i) { // 소수의 배숫값을 1000000까지 탐색
                arr[j] = 0; // 이 수가 소수가 아니라는 것을 표시 (배수 지우기)
            }
        }

        for (int i = 2; i < arr.length; i++) { // 1000000까지 반복
            if (arr[i] != 0) { // 소수 배열에서 소수인 값일 때
                long temp = arr[i]; // 현재 소수를 temp에 저장

                // 현재 소수의 제곱근이 b보다 작을 때를 기준으로 하지만 곱셈이 long의 범위를 넘어갈 수 있어 이항 정리로 처리
                while ((double) arr[i] <= (double) b / (double) temp) {
                    if ((double) arr[i] >= (double) a / (double) temp) {
                        count++; // 정답값 증가
                    }

                    temp *= arr[i]; // temp에 현재 소수 곱하기
                }
            }
        }

        System.out.println(count); // 정답 출력
    }
}
