package greedy;

import java.util.*;

public class Boj1715 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드 묶음 개수
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 우선순위 큐 선언
        int sum = 0; // 누적된 비교 횟수

        for (int i = 0; i < n; i++) { // n만큼 반복
            queue.offer(sc.nextInt()); // 우선순위 큐에 데이터 저장
        }

        while (queue.size() != 1) { // 우선순위 큐 크기가 1이 될 때까지 반복
            // 2개의 카드 묶음을 큐에서 뽑음
            int data1 = queue.poll();
            int date2 = queue.poll();

            sum += data1 + date2; // 2개 카드 묶음을 합치는 데 필요한 비교 횟수를 sum에 더함
            queue.offer(data1 + date2); // 2개 카드 묶음의 합을 우선순위 큐에 다시 넣음
        }

        System.out.println(sum); // 누적된 비교 횟수 출력
    }
}
