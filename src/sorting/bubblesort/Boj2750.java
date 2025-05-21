package sorting.bubblesort;

import java.util.*;

public class Boj2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 입력될 수의 개수
        int[] arr = new int[n]; // 입력될 수를 담을 배열 선언

        for (int i = 0; i < n; i++) { // 배열에 수 담기
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) { // 현재 인덱스의 수와 다음 인덱스의 수를 비교하기 때문에 마지막 인덱스까지 갈 필요가 없어 n-1
            int swap = 0; // swap 횟수
            for (int j = 0; j < n - 1 - i; j++) { // 맨 뒤의 인덱스는 오름차순으로 정렬된 수이기에 n-1-i로 반복할 범위를 줄인다.
                if (arr[j] > arr[j + 1]) { // 앞의 수가 뒤의 수보다 크면 스왑해준다.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) break; // 스왑 횟수가 0이면 모두 정렬된 것이기 때문에 루프를 멈춘다.
        }

        for (int i : arr) { // 정렬된 배열 출력
            System.out.println(i);
        }
    }
}
