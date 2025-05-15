package datastructure.arrayandlist;

import java.util.*;

public class Boj1940 {

    // 배열의 값이 유니크하고, 사용된 값은 더 이상 사용하지 못한다면, 배열의 양 끝에 포인터를 두는 투포인터 알고리즘을 사용할 수 있다.
    // 투포인터 알고리즘은 O(n)의 시간 복잡도를 갖지만, 정렬이 필요하기에 정렬할 값들의 O(n log n)의 값을 확인한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 재료의 수
        int m = sc.nextInt(); // 재료 번호의 합
        int[] arr = new int[n]; // 재료의 번호을 담을 배열 선언
        int i = 0; // 배열 맨 앞의 첫 번째 포인터
        int j = arr.length - 1; // 배열 맨 뒤의 두 번째 포인터
        int count = 0; // 갑옷의 수

        for (int k = 0; k < n; k++) {
            arr[k] = sc.nextInt(); // 재료의 번호를 배열에 담는다.
        }

        Arrays.sort(arr); // 배열을 정렬한다.

        while (i < j) { // 첫 번째 포인터와 두 번째 배열이 만나기 전까지 반복
            int sum = arr[i] + arr[j]; // 두 포인터의 값의 합
            if (sum == m) { // 합이 m과 같으면
                count ++; // count 증가
                i++; // 사용된 값은 더 이상 사용을 못하기 떄문에 첫 번째 포인터 증가
                j--; // 두 번째 포인터 감소
            } else if (sum > m) {
                j--; // 합이 m보다 크면 두 번째 포인터 감소
            } else {
                i++; // 합이 m보다 작으면 첫 번째 포인터 증가
            }
        }

        System.out.println(count);
    }
}
