package greedy;

import java.util.Scanner;

public class Boj11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 동전의 종류 수
        int k = sc.nextInt(); // 가격
        int[] arr = new int[n]; // 동전의 종류를 담을 배열

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0; // 필요한 동전 갯수
        for (int i = n - 1; i >= 0; i--) { // 동전의 가치가 큰 순서대로 계산
            if (k >= arr[i]) { // 동전의 가치가 k보다 작거나 같으면
                count += k / arr[i]; // k를 동전의 가치로 나눈 몫을 count에 더한다.
                k = k % arr[i]; // k의 값을 동전의 가치로 나눈 나머지로 변경한다.
                if (k <= 0) {
                    break; // k가 0보다 작거나 같으면 반복문을 멈춘다.
                }
            }
        }

        System.out.println(count); // 필요한 동전 갯수 출력
    }
}
