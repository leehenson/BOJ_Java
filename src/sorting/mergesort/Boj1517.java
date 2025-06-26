package sorting.mergesort;

import java.util.*;
import java.io.*;

public class Boj1517 {

    private static int[] arr, tmp;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정렬할 개수
        arr = new int[n]; // 정렬할 배열 선언
        tmp = new int[n]; // 임시 배열 선언
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 정렬할 배열에 데이터 저장
        }

        mergeSort(0, n - 1); // 병합 정렬 실행

        // 결괏값 출력
        System.out.println(result);

        br.close();
    }

    private static void mergeSort(int start, int end) {
        // 종료점이 시작점보다 작거나 같으면 바로 리턴
        if (end - start < 1) {
            return;
        }

        int median = start + (end - start) / 2; // 중간점

        // 재귀 함수 형태로 두 그룹으로 나눠서 병합 정렬 실행
        mergeSort(start, median);
        mergeSort(median + 1, end);

        // 임시 배열에 정렬할 배열의 값 저장
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int k = start; // 정렬할 배열의 정렬된 데이터의 인덱스
        int index1 = start; // 왼쪽 그룹의 포인터
        int index2 = median + 1; // 오른쪽 그룹의 포인터

        // 투 포인터 개념을 사용하여 두 그룹을 병합하는 로직
        while (index1 <= median && index2 <= end) {
            // 두 그룹의 포인터가 가리키는 값을 비교하여 더 작은 수를 선택해 정렬할 배열에 저장하고, 선택된 데이터의 포인터를 오른쪽으로 한 칸 이동
            if (tmp[index1] > tmp[index2]) {
                arr[k] = tmp[index2];
                result = result + index2 - k; // 오른쪽 그룹 데이터 값이 더 작아 선택될 때 swap이 일어났다고 가정하고, 현재 남아 있는 왼쪽 그룹 데이터 개수만큼 결괏값에 더함
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        // 한쪽 그룹을 모두 선택한 후에 남은 데이터 저장
        while (index1 <= median) {
            arr[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= end) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
