package graph.topologicalsort;

import java.util.*;

public class Boj2252 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 수
        int m = sc.nextInt(); // 에지의 수
        // 인접 리스트 선언
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        // 진입 차수 배열 선언
        int[] inDegree = new int[n + 1];

        // 인접 리스트, 진입 차수 배열 초기화
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt(); // 시작 노드
            int end = sc.nextInt(); // 도착 노드
            list.get(start).add(end); // 시작 노드가 가리키는 도착 노드를 인접 리스트에 넣기
            inDegree[end]++; // 도착 노드를 가리키는 노드의 수 증가
        }

        // 위상 정렬 실행
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            // 진입 차수 배열의 값이 0인 노드를 큐에 넣기
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) { // 큐가 빌 떄까지 반복
            int now = queue.poll(); // 큐에서 노드 꺼내기
            System.out.print(now + " "); // 노드 출력
            for (int next : list.get(now)) { // 꺼낸 노드와 인접한 노드 하나씩 꺼내서
                inDegree[next]--; // 꺼낸 노드를 가리키는 노드의 수 감소
                if (inDegree[next] == 0) { // 감소된 노드의 수가 0이면
                    queue.offer(next); // 큐에 넣기
                }
            }
        }
    }
}
