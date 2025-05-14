package datastructure.arrayandlist;

import java.util.*;

public class Boj1546 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int scoreCount = sc.nextInt(); // 과목 수
        long max = 0; // 최대 점수
        long sum = 0; // 점수의 합

        for (int i = 0; i < scoreCount; i++) {
            int temp = sc.nextInt(); // 입력되는 점수
            if (temp > max) {
                max = temp; // 입력되는 점수를 비교하여 크면 최대 점수 변경
            }
            sum += temp; // 모든 점수를 sum 변수에 더하기
        }

        /**
         * 모든 점수를 최대 점수로 나누고, 100을 곱한 다음 평균을 구하는 식은
         * (전체 점수의 합) × 100 ÷ 최대점수 ÷ 과목 수
         * 위와 같이 변경할 수 있다.
         */
        System.out.println(sum * 100.0 / max / scoreCount);
    }
}
