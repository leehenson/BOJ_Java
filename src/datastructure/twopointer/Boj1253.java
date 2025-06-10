package datastructure.twopointer;

import java.io.*;
import java.util.*;

public class Boj1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수의 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n]; // 수를 담을 배열 선언
        int result = 0; // 좋은 수의 갯수

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순 정렬 O(n log n)

        for (int k = 0; k < n; k++) {
            long find = arr[k]; // 두 수의 합이 될 수(찾는 값)
            int i = 0; // 양끝 중 맨앞에 위치할 포인터
            int j = n - 1; // 양끝 중 맨뒤에 위치할 포인터
            while(i < j) { // 두 포인터가 만나기 전까지 반복
                if (arr[i] + arr[j] == find) { // 두 포인터가 가르키는 값의 합이 찾는 값이고
                    if(i != k && j != k) { // 찾는 값과 다른 두 수의 합이여야 하기 때문에 두 수가 찾는 값도 아니라면
                        result++; // 좋은 수에 추가
                        break; // 좋은 수인 걸 알았기 때문에 반복문 중단
                    } else if (i == k) { // 포인터 i의 값이 찾는 값이면 조건에 안 맞기 때문에
                        i++; // 포인터를 오른쪽으로 이동
                    } else { // 포인터 j의 값이 찾는 값이면 조건에 안 맞기 때문에
                        j--; // 포인터를 왼쪽으로 이동
                    }
                } else if (arr[i] + arr[j] < find) { // 두 수의 합이 찾는 값보다 작으면
                    i++; // 포인터 i를 오른쪽으로 이동
                } else { // 두 수의 합이 찾는 값보다 크면
                    j--; // 포인터 j를 왼쪽으로 이동
                }
            }
        }
        System.out.println(result); // 좋은 수의 갯수 출력
        br.close();
    }
}
