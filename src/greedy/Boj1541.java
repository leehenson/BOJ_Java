package greedy;

import java.util.*;

public class Boj1541 {

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine(); // 식 입력 받기
        String[] expressions = expression.split("-"); // 최소값을 구하기 위해서는 -의 뒤에 값이 커야하기에 - 기준으로 나누기

        for (int i = 0; i < expressions.length; i++) {
            int sum = mySum(expressions[i]); // 식들의 합
            if (i == 0) { // 첫 식은 더해준다.
                answer = answer + sum;
            } else { // 그 외에 식은 뺀다.
                answer = answer - sum;
            }
        }

        System.out.println(answer);
    }

    // -의 뒤의 수를 최댓값으로 만들기 위해 - 기준으로 나누어진 식의 합을 구하는 메서드
    private static int mySum(String expression) {
        int sum = 0;
        String[] numbers = expression.split("\\+"); // split 메서드를 사용할 때 regex에 "+"를 넣으면 에러 발생하기 떄문에 "\\+" 혹은 "[+]" 넣기
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
