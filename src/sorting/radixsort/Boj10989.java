package sorting.radixsort;

import java.io.*;

public class Boj10989 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 정렬할 수 개수
        arr = new int[n]; // 정렬할 배열 선언

        for (int i = 0; i < n; i++) { // n의 개수만큼 반복
            arr[i] = Integer.parseInt(br.readLine()); // arr 배열 저장
        }

        br.close();

        radixSort(arr, 5); // 기수 정렬 메서드 수행

        // 정렬된 arr 배열 출력
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] arr, int maxSize) {
        int[] output = new int[arr.length]; // 임시 정렬을 위한 배열
        int digit = 1; // 현재 자릿수를 표현하는 수
        int count = 0;

        while (count != maxSize) { // 최대 자릿수만큼 반복하기
            int[] bucket = new int[10]; // 현재 자릿수들의 분포를 합 배열의 형태로 알려 주는 배열

            // 현재 기준 자릿수를 기준으로 arr 배열 데이터를 bucket에 count
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / digit) % 10]++; // 일의 자리부터 시작
            }

            // 합 배열 공식으로 bucket을 합 배열 형태로 변경
            for (int i = 1; i < 10; i++) { // 합 배열을 이용해 index 계산
                bucket[i] += bucket[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) { // n - 1에서 0까지 감소하면서 반복문 실행
                output[bucket[(arr[i] / digit % 10)] - 1] = arr[i]; // bucket값을 이용해 현재 기준 자릿수로 데이터를 정렬, output 배열에 저장하기
                bucket[(arr[i] / digit) % 10]--;
            }

            for (int i = 0; i < arr.length; i++) { // n의 개수만큼 반복
                arr[i] = output[i]; // 다음 자릿수 이동을 위해 arr 배열에 output 데이터 저장
            }

            digit = digit * 10; // 자릿수 증가
            count++;
        }
    }
}
