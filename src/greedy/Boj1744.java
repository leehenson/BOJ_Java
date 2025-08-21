package greedy;

import java.util.*;

public class Boj1744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수의 개수

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder()); // 양수 우선순위 큐(내림차순 정렬)
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>(); // 음수 우선순위 큐
        int one = 0; // 1의 개수 카운트
        int zero = 0; // 0의 개수 카운트

        for (int i = 0; i < n; i++) { // n만큼 반복
            int data = sc.nextInt();

            // 데이터를 4개의 그룹에 분리 저장
            if (data > 1) {
                plusQueue.offer(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusQueue.offer(data);
            }
        }

        int sum = 0; // 결괏값

        while (plusQueue.size() > 1) { // 양수 우선순위 큐 크기가 2보다 작을 때까지 반복
            // 수 2개를 큐에서 뽑음
            int first = plusQueue.poll();
            int second = plusQueue.poll();

            sum += first * second; // 2개의 수를 곱한 값을 결괏값에 더함
        }

        if (!plusQueue.isEmpty()) { // 양수 우선순위 큐에 데이터가 남이있으면
            sum += plusQueue.poll(); // 이 데이터를 결괏값에 더함
        }

        while (minusQueue.size() > 1) { // 음수 우선순위 큐 크기가 2보다 작을 때까지 반복
            // 수 2개를 큐에서 뽑음
            int first = minusQueue.poll();
            int second = minusQueue.poll();

            sum += first * second; // 2개의 수를 곱한 값을 결괏값에 더함
        }

        if (!minusQueue.isEmpty()) { // 음수 우선순위 큐에 데이터가 남이있고
            if (zero == 0) { // 데이터 0이 1개도 없으면
                sum += minusQueue.poll(); // 이 데이터를 결괏값에 더함
            }
        }

        sum += one; // 숫자 1의 개수를 결괏값에 더함
        System.out.println(sum); // 결괏값 출력
    }
}
