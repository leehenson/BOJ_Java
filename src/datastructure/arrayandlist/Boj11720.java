package datastructure.arrayandlist;

import java.util.*;

public class Boj11720 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCount = sc.nextInt(); // 필요 없는 값
        String number = sc.next(); // 최대 100자리 수까지 들어올 수 있어 int형이나 long형을 사용할 수 없기 때문에 String형으로 받는다.

        String[] numbers = number.split(""); // number을 split 메서드로 한글자씩 나누어 문자열 배열에 담는다.

        int sum = 0; // 숫자들의 합을 0으로 초기화

        for (String num : numbers) { // 각 숫자가 담긴 문자열 배열을 반복한다.
            sum += Integer.parseInt(num); // 배열의 모든 값을 숫자로 변환하여 sum 변수에 더한다.
        }

        System.out.println(sum);
    }
}
