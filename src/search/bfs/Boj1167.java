package search.bfs;

import java.util.*;

public class Boj1167 {

    private static boolean[] visited;
    private static int[] distance;
    private static List<Node>[] edgeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        edgeList = new ArrayList[n + 1]; // 그래프 데이터 저장 인접 리스트

        for (int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>(); // 인접 리스트에 각 ArrayList 초기화
        }

        // 인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();

            while (true) {
                int e = sc.nextInt();

                if (e == -1) {
                    break;
                }

                int v = sc.nextInt();
                edgeList[s].add(new Node(e, v));
            }
        }

        distance = new int[n + 1]; // 거리 배열 초기화
        visited = new boolean[n + 1]; // 방문 기록 배열 초기화

        bfs(1); // 임의 노드를 시작점으로 bfs 실행

        int max = 1;

        // 거리 배열에서 가장 큰 값을 지니고 있는 노드를 시작점으로 저장
        for (int i = 2; i <= n; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[n + 1]; // 거리 배열 초기화
        visited = new boolean[n + 1]; // 방문 기록 배열 초기화

        bfs(max); // 거리 배열에서 가장 큰 값을 지니고 있는 노드를 시작점으로 bfs 실행

        Arrays.sort(distance); // 거리 배열 오름차순 정렬

        System.out.println(distance[n]); // 거리 배열에서 가장 큰 수 출력
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>(); // 큐 자료구조 생성
        queue.offer(index); // 큐에 시작 노드 삽입
        visited[index] = true; // 현재 노드 방문 기록

        while (!queue.isEmpty()) { // 큐가 비어 있을 때까지 반복
            int now = queue.poll(); // 큐에서 노드 데이터 꺼내기

            for (Node n : edgeList[now]) { // 현재 노드의 연결 노드 중
                int next = n.next;
                int value = n.value;

                if (!visited[next]) { // 방문하지 않은 노드는
                    visited[next] = true; // 방문 기록
                    queue.add(next); // 큐에 데이터 삽입
                    distance[next] = distance[now] + value; // 현재 노드의 거리 + 에지의 가중치로 방문하지 않은 노드 거리 배열 업데이트
                }
            }
        }
    }

    // 노드 클래스 구현
    static class Node {
        int next; // 목적지 노드
        int value; // 에지의 가중치

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }
}
