package sorting.selectionsort;

import java.util.*;

public class Boj1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 문자열로 숫자를 받는다.
        int[] arr = new int[str.length()]; // 문자열 길이만큼 정수 배열을 만든다.

        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1)); // substring(i, i+1)로 문자열을 숫자로 변환하여 배열에 담는다.
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int max = i; // i값을 최대값으로 둔다.
            for (int j = i + 1; j < arr.length; j++) { // i의 다음 값부터 반복을 한다.
                if (arr[j] > arr[max]) { // 다음 수가 지금의 수보다 크다면
                    max = j; // 최댓값을 바꿔준다.
                }
            }
            if (max != i) { // 최댓값이 바꼈다면, i의 수와 최댓값의 수를 swap한다.
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }

        for (int i : arr) {
            System.out.print(i);
        }
    }
}
