package search.binarysearch;

import java.util.*;
import java.io.*;

public class Boj1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정수의 갯수
        int[] arr = new int[n]; // 정수의 갯수만큼 배열 선언

        st = new StringTokenizer(br.readLine());
        // 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 오름차순 정렬 O(n log n)
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 타겟의 갯수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) { // 타켓의 수 만큼 반복
            boolean find = false; // 타켓을 찾았는지 확인하는 flag 변수
            int target = Integer.parseInt(st.nextToken()); // target의 값
            int start = 0; // 시작 인덱스
            int end = arr.length - 1; // 마지막 인덱스
            while (start <= end) { // 시작 인덱스와 종료 인덱스의 범위가 좁혀지기 떄문에 시작 인덱스가 마지막 인덱스보다 작거나 같을 때까지만 반복
                int mid = (start + end) / 2; // 중앙값이 위치한 인덱스
                if (arr[mid] > target) { // 중앙값이 타겟보다 크다면
                    end = mid - 1; // 마지막 인덱스를 중앙값의 인덱스 - 1
                } else if (arr[mid] < target) { // 중앙값이 타켓보다 작다면
                    start = mid + 1; // 시작 인덱스를 중앙값 인덱스 + 1
                } else { // 타겟을 찾았다면
                    find = true; // flag 변수 true로 변경
                    break; // 더 탐색할 필요가 없기 때문에 반복문 중단
                }
            }
            if (find) { // target을 찾았으면 1 출력
                System.out.println(1);
            } else { // target이 없으면 0 출력
                System.out.println(0);
            }
        }

        br.close();
    }
}
