package search.bfs;

import java.util.*;

public class Boj1260 {

    private static List<Integer>[] edgeList;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        int m = sc.nextInt(); // 에지 개수
        int v = sc.nextInt(); // 시작점
        edgeList = new ArrayList[n + 1]; // 그래프 데이터 저장 인접 리스트

        for (int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>(); // 인접 리스트에 각 ArrayList 초기화
        }

        // 인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            edgeList[s].add(e);
            edgeList[e].add(s);
        }

        // 방문할 수 있는 노드가 여러 개일 경우에는 번호가 작은 것을 먼저 방문하기 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(edgeList[i]); // 각 노드와 관련된 에지를 정렬
        }

        visited = new boolean[n + 1]; // 방문 기록 저장 배열 초기화
        dfs(v); // dfs 실행
        System.out.println(); // 개행

        visited = new boolean[n + 1]; // 방문 기록 저장 배열 초기화
        bfs(v); // bfs 실행
        System.out.println(); // 개행
    }

    private static void dfs(int start) {
        System.out.print(start + " "); // 현재 노드 출력
        visited[start] = true; // 방문 기록 저장 배열에 현재 노드 방문 기록

        // 현재 노드의 연결 노드 중 방문하지 않은 노드로 dfs 실행(재귀 함수 형태)
        for (int i : edgeList[start]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>(); // 큐 자료구조 생성
        queue.offer(start); // 큐에 시작 노드 삽입
        visited[start] = true; // 방문 기록 저장 배열에 현재 노드 방문 기록

        while (!queue.isEmpty()) { // 큐가 비어있을 때까지
            int now = queue.poll(); // 큐에서 노드 데이터 꺼내기
            System.out.print(now + " "); // 꺼낸 노드 출력

            // 꺼낸 노드의 연결 노드 중 미방문 노드를 큐에 삽입하고 방문 배열에 기록
            for (int i : edgeList[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
