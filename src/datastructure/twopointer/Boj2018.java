package datastructure.twopointer;

import java.util.Scanner;

public class Boj2018 {

    // 최대 n의 수 10,000,000 제한 시간은 2초로 O(n log n)은 시간 초과가 나기 떄문에 O(log n) 혹은 O(n)을 사용해야 한다.
    // 연속된 값의 합이기에 O(n)의 시간 복잡도를 가진 투 포인터 알고리즘을 사용한다.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1; // n도 연속된 값의 합이기에 미리 count를 1로 초기화한다.
        int sum = 1; // startIndex와 endIndex가 1부터 시작하기에 두 인덱스의 값의 합인 1로 sum을 초기화한다.
        int startIndex = 1;
        int endIndex = 1;

        while (endIndex != n) {
            if (sum == n) { // n과 startIndex부터 endIndex까지의 연속된 값의 합인 sum이 같은 경우
                count++; // count 값 1 더하기
                endIndex++; // endIndex 값 1 더하기
                sum += endIndex; // sum에 endIndex 값 더하기
            } else if (sum > n) { // sum이 n보다 작을 경우
                sum -= startIndex; // sum에 현재 startIndex의 값을 빼기
                startIndex++; // startIndex 1 더하기
            } else { // sum이 n 보다 작을 경우
                endIndex++; // endIndex 1 더하기
                sum += endIndex; // sum에 endIndex 값 더하기
            }
        }

        System.out.println(count);
    }
}
