package search.binarysearch;

import java.util.*;

public class Boj2343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 레슨 개수
        int m = sc.nextInt(); // 블루레이 개수
        int[] arr = new int[n]; // 기타 레슨 데이터 저장 배열
        int start = 0; // 이진 탐색 시작 인덱스
        int end = 0; // 이진 탐색 종료 인덱스

        for (int i = 0; i < n; i++) { // n의 개수만큼 반복
            arr[i] = sc.nextInt(); // arr 배열 저장
            if (start < arr[i]) {
                start = arr[i]; // 레슨 최댓값을 시작 인덱스로 저장
            }
            end += arr[i]; // 모든 레슨의 총합을 종료 인덱스로 저장
        }

        while (start <= end) {
            int mid = (start + end) / 2; // 중간 인덱스
            int sum = 0; // 레슨 합
            int count = 0; // 현재 사용한 블루레이 개수

            for (int i = 0; i < n; i++) { // n의 개수만큼 반복하며 mid값으로 모든 레슨을 저장할 수 있는지 확인
                if (sum + arr[i] > mid) { // 만약 sum + 현재 레슨 시간 > 중간 인덱스이면
                    count++; // count값을 올리고
                    sum = 0; // sum을 0으로 리셋
                } // 현재 블루레이에 저장할 수 없어 새로운 블루레이로 교체한다는 의미

                sum += arr[i]; // sum에 현재 레슨 시간값 더하기
            }

            if (sum != 0) { // sum이 0이 아니면 블루레이가 1개 더 필요하므로 더함
                count++; // count값 올리기
            }

            if (count > m) { // count가 m보다 크면 중간 인덱스 값으로 모든 레슨 저장 불가능
                start = mid + 1; // 시작 인덱스 = 중간 인덱스 + 1
            } else { // 중간 인덱스 값으로 모든 레슨 저장 가능
                end = mid - 1; // 종료 인덱스 = 중앙 인덱스 - 1
            }
        }

        System.out.println(start); // 시작 인덱스 출력
    }
}
