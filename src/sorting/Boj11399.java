package sorting;

import java.util.*;
import java.io.*;

public class Boj11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람의 수
        int[] arr = new int[n]; // 인출 필요 시간 배열 선언
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인출 필요 시간 배열 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬 O(n log n)
        Arrays.sort(arr);

        int sum = 0; // 총 인출 필요 시간
        int answer = 0; // 총 인출 소요 시간

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // 총 인출 필요 시간 계산
            answer += sum; // 총 인출 소요 시간 계산
        }

        System.out.println(answer); // 출력
    }
}