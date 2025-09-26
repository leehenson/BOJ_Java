package greedy;

import java.util.*;

public class Boj1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 회의 개수
        int[][] arr = new int[n][2]; // 회의 시간 정보
        int count = 0; // 진행할 수 있는 회의 수
        int end = -1; // 회의의 종료 시간

        // 회의 시간 정보 저장
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 회의 시간 정보 정렬
        Arrays.sort(arr, (s, e) -> {
            if (s[1] == e[1]) { // 종료 시간이 같으면
                return s[0] - e[0]; // 시작 시간 기준 정렬
            }

            return s[1] - e[1]; // 종료 시간 기준으로 정렬
        });

        // 회의 개수만큼 반복
        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) { // 현재 회의와 겹치지 않는 다음 회의가 나온 경우
                end = arr[i][1]; // 종료 시간 업데이트
                count++; // 진행할 수 있는 회의 수 증가
            }
        }

        System.out.println(count); // 진행할 수 있는 회의 수 출력
    }
}
