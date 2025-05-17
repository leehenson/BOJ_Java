package datastructure.stackandqueue;

import java.util.*;

public class Boj2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드 개수
        Queue<Integer> queue = new LinkedList<>(); // 큐 생성

        for (int i = 1; i <= n; i++) {
            queue.add(i); // 1부터 n까지의 카드 큐에 담기
        }

        while (queue.size() != 1) { // 카드의 수가 1이 될 때까지 반복
            queue.poll(); // 맨 위의 카드 버림
            queue.add(queue.poll()); // 그 다음 카드는 맨 아래에 넣기
        }

        System.out.println(queue.poll()); // 마지막 남은 카드 출력
    }
}
