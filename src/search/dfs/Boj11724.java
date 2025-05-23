package search.dfs;

import java.io.*;
import java.util.*;

public class Boj11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int m = Integer.parseInt(st.nextToken()); // 에지의 개수
        visited = new boolean[n + 1]; // 방문 기록 저장 배열
        list = new ArrayList[n + 1]; // 그래프 데이터 저장 인접 리스트
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>(); // list 인접 리스트의 각 ArrayList 초기화
        }
        for (int i = 0; i < m; i++) { // list 인접 리스트에 그래프 데이터 저장
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        int count = 0; // 연결 요소의 개수
        for (int i = 1; i < n; i++) { // n만큼 반복
            if (!visited[i]) { // 방문하지 않은 노드가 있으면
                count++; // 연결 요소 개수 증가
                dfs(i); // DFS 실행
            }
        }
        System.out.println(count); // 연결 요소 개수 출력
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return; // 현재 노드가 방문한 노드이면 return
        }
        visited[v] = true; // 현재 노드 방문 기록
        for (int i : list[v]) { // 현재 노드의 인접 리스트 중에서
            if (!visited[i]) { // 방문하지 않은 노드가 있다면
                dfs(i); // 방문하지 않은 노드를 재귀 호출
            }
        }
    }
}
