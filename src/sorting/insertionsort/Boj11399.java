package sorting.insertionsort;

import java.util.*;

public class Boj11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람 수
        int[] arr = new int[n]; // 걸리는 시간을 저장한 배열
        int[] sumArr = new int[n]; // 각 사람이 인출을 완료하는 데 필요한 시간을 저장한 배열

        for (int i = 0; i < n; i++) { // arr 배열 저장
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) { // n만큼 반복
            int insertPoint = i; // 삽입 위치
            int insertValue = arr[i]; // 현재 데이터

            // 현재 범위에서 십입 위치 찾기
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    insertPoint = j + 1;
                    break;
                }
                if (j == 0) {
                    insertPoint = 0;
                }
            }

            // 삽입을 위해 삽입 위치에서 i까지 데이터를 한 킨씩 뒤로 밀기
            for (int j = i; j > insertPoint; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insertPoint] = insertValue; // 삽입 위치에 현재 데이터 넣기
        }

        // 합 배열 sumArr 만들기
        sumArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        int sum = 0;

        // sumArr 배열의 각 데이터 값을 모두 합해 총 걸리는 시간 구하기
        for (int i = 0; i < n; i++) {
            sum = sum + sumArr[i];
        }

        System.out.println(sum);
    }
}