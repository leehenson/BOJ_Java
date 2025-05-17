package datastructure.stackandqueue;

import java.util.*;

public class Boj11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 연산 횟수
        // 우선순위 큐 사용, 조건에 맞게 정렬하도록 Comparator를 람다로 전달
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
            // 절대값 작은 데이터 우선
            int firstAbs = Math.abs(n1);
            int secondAbs = Math.abs(n2);
            // 절대값이 같은 경우 음수 우선
            if (firstAbs == secondAbs) {
                return n1 > n2 ? 1 : -1;
            }
            return firstAbs - secondAbs;
        });

        for (int i = 0; i < n; i++) {
            int request = sc.nextInt(); // 입력된 값을 받는다
            if (request == 0) { // 입력된 값이 0이고
                if (queue.isEmpty()) { // 우선순위큐가 비어있다면
                    System.out.println(0); // 0을 출력
                } else { // 우선순위큐가 비어있지 않다면
                    System.out.println(queue.poll()); // 정렬된 우선순위 큐의 값을 poll()하여 출력
                }
            } else { // 입력된 값이 0이 아니면
                queue.add(request); // 우선순위큐에 입력된 값 삽입
            }
        }
    }
}
