package sorting.quicksort;

import java.util.*;
import java.io.*;

public class Boj11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int k = Integer.parseInt(st.nextToken()); // k번째 수
        int[] arr = new int[n]; // 숫자 데이터 저장 배열

        st = new StringTokenizer(br.readLine());
        // arr 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1, k - 1); // quick sort 실행

        System.out.println(arr[k - 1]); // k번째 데이터 출력
    }

    private static void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(arr, start, end); // 피벗 구하기

            if (pivot == k) { // k번째 수가 pivot이면 더이상 구할 필요 없음
                return;
            } else if (pivot > k) { // k가 피벗보다 작으면 왼쪽 그룹만 정렬 수행
                quickSort(arr, start, pivot - 1, k);
            } else { // k가 피벗보다 크면 오른쪽 그룹만 정렬 수행
                quickSort(arr, pivot + 1, end, k);
            }
        }
    }

    private static int partition(int[] arr, int start, int end) {
        // 데이터가 두 개인 경우 두 데이터를 정렬
        if (start + 1 == end) {
            if (arr[start] > arr[end]) {
                swap(arr, start, end);
                return end;
            }
        }

        int m = (start + end) / 2; // 중앙값
        swap(arr, start, m); // 중앙값을 1번째 요소로 이동

        int pivot = arr[start]; // start 위치 값을 pivot으로 저장
        int i = start + 1; // 시작점
        int j = end; // 종료점

        while (i <= j) { // 시작점이 종료점보다 작거나 같을 때까지 반복
            while (j >= start && arr[j] > pivot) { // 피벗보다 작은 수가 나올 때까지 j--
                j--;
            }
            while (i <= end && arr[i] < pivot) { // 피벗보다 큰 수가 나올 때까지 i++
                i++;
            }
            if (i <= j) {
                swap(arr, i++, j--); // 피벗보다 큰 수 i++와 피벗보다 작은 수 j--를 swap
            }
        }

        arr[start] = arr[j]; // 경계 index값을 시작 위치에 저장
        arr[j] = pivot; // 피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기
        return j; // 경계 index 리턴
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}