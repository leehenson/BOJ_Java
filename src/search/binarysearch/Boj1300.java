package search.binarysearch;

import java.util.Scanner;

public class Boj1300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 배열의 크기
        int k = sc.nextInt(); // 구하고자 하는 index
        long start = 1; // 시작 인덱스
        long end = k; // 종료 인덱스
        long answer = 0; // 정답

        // 이진 탐색 수행
        while (start <= end) { // 시작 인덱스가 종료 인덱스보다 작거나 같으면 반복
            long mid = (start + end) / 2; // 중간 인덱스
            long count = 0; // 중앙값보다 작은 수

            // 중앙값보다 작은 수는 몇개인지 계산
            for (int i = 1; i <= n; i++) { // n의 개수만큼 반복
                count += Math.min(mid / i, n); // count에 중앙 인덱스를 i로 나눈 값과 n중 작은 값을 더함, 작은 수를 카운트하는 핵심 로직
            }

            if (count < k) { // 현재 중앙값보다 작은 수의 개수가 k보다 작으면
                start = mid + 1; // 시작 인덱스를 중간 인덱스 + 1로 변경
            } else { // 현재 중앙값보다 작은 수의 개수가 k보다 크거나 같으면
                answer = mid; // 정답 변수에 현재 단계의 중앙값을 저장
                end = mid - 1; // 종료 인덱스를 중간 인덱스 - 1로 변경
            }
        }

        System.out.println(answer); // 정답 출력
    }
}
