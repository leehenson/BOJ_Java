package search.dfs;

import java.util.*;

public class Boj13023 {

    private static List<Integer>[] edgeList;
    private static boolean[] visited;
    private static boolean arrive;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        int m = sc.nextInt(); // 에지 개수
        edgeList = new ArrayList[n]; // 그래프 데이터 저장 인접 리스트
        visited = new boolean[n]; // 방문 기록 저장 배열
        arrive = false; // 도착 확인 변수

        for (int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>(); // 인접 리스트에 각 ArrayList 초기화
        }

        // 인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edgeList[a].add(b); // 방향성이 없기 때문에 양쪽에 저장
            edgeList[b].add(a);
        }

        for (int i = 0; i < n; i++) { // 노드 수만큼 반복
            dfs(i, 1); // 각 노드마다 dfs 실행 depth 1부터 시작

            if (arrive) { // depth가 5에 도달한 적이 있다면
                break; // 반복문 종료
            }
        }

        if (arrive) { // depth가 5에 도달한 적이 있다면
            System.out.println(1); // 1 출력
        } else { // depth가 5에 도달한 적이 없다면
            System.out.println(0); // 0 출력
        }
    }

    // dfs 구현
    private static void dfs(int now, int depth) {
        if (depth == 5 || arrive) { // 현재 depth가 5이거나 5에 도달한 적이 있다면
            arrive = true; // 도착 확인 변수 true
            return; // dfs 종료
        }

        visited[now] = true; // 방문 배열에 현재 노드 방문 기록

        // 현재 노드의 연결 노드 중 방문하지 않은 노드로 dfs 실행
        for (int i : edgeList[now]) {
            if (!visited[i]) {
                dfs(i, depth + 1); // 재귀 호출마다 depth는 1씩 증가
            }
        }

        visited[now] = false; // 각 노드마다 depth를 확인해야 되기 때문에 방문 기록 되돌리기
    }
}
