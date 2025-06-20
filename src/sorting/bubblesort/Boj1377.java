package sorting.bubblesort;

import java.util.*;
import java.io.*;

public class Boj1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 메모리 초과로 인해 BufferedReader 사용
        int n = Integer.parseInt(br.readLine()); // 데이터 개수
        Data[] data = new Data[n]; // 데이터 배열

        // 데이터 배열 저장
        for (int i = 0; i < n; i++) {
            data[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(data); // 데이터 배열 정렬, 시간 복잡도 = O(n log n)

        int max = 0; // 왼쪽 이동 최댓값 선언

        for (int i = 0; i < n; i++) {
            if (max < data[i].index - i) {
                max = data[i].index - i; // 데이터 배열의 [정렬 전 index - 정렬 후 index] 계산의 최댓값 저장
            }
        }

        System.out.println(max + 1); // 최댓값 + 1 출력

        br.close();
    }
}

class Data implements Comparable<Data> {

    int index;
    int value;

    public Data(int index, int value) {
        super();
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value; // value 기준으로 오름차순 정렬
    }
}
