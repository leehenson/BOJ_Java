package numbertheory.primenumber;

import java.util.*;

public class Boj1747 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 어떤 수
        int[] arr = new int[10000001]; // 소수 배열

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i; // 인덱스를 자기 값으로 소수 배열 초기화
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) { // 소수 배열 길이의 제곱근까지 반복
            if (arr[i] == 0) { // 소수가 아니면 넘어감
                continue;
            }

            for (int j = i + i; j < arr.length; j += i) { // 소수의 배수 값을 10000001까지 탐색
                arr[j] = 0; // 소수의 배수는 소수가 아니라는 것을 표시 (배수 지우기)
            }
        }

        while (true) { // n부터 1씩 증가시키면서 소수와 펠린드롬 수가 맞는지 확인
            if (arr[n] != 0) { // n 이상의 배열 값이 소수이면

                if (isPalindrome(arr[n])) { // 펠린드롬 판별 메서드로 펠린드롬 수인지 확인
                    System.out.println(arr[n]); // 펠린드롬 수이면 출력
                    break; // 반복문 종료
                }
            }
            n++; // 소수 배열 인덱스 증가
        }
    }

    // 펠린드롬 판별 메서드
    private static boolean isPalindrome(int result) {
        char[] temp = String.valueOf(result).toCharArray(); // int값을 char 배열로 변환
        int s = 0; // 시작 인덱스
        int e = temp.length - 1; // 끝 인덱스

        while (s < e) { // 시작 인덱스가 끝 인덱스보다 작을 때까지 반복
            if (temp[s] != temp[e]) { // 만약 시작과 끝 인덱스에 해당하는 값이 다르면
                return  false; // false 반환
            }

            s++; // 시작 인덱스 증가
            e--; // 끝 인덱스 감소
        }

        return true; // 펠린드롬 수이면 true 반환
    }


}
