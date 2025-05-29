package graph;

import java.io.*;
import java.util.*;

public class Boj1707 {

    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) { // 주어진 테스트케이스만큼 반복
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]); // 노드의 개수
            int e = Integer.parseInt(s[1]); // 에지의 개수
            list = new ArrayList[v + 1]; // 인접 리스트 생성
            visited = new boolean[v + 1]; // 방문 배열 생성
            check = new int[v + 1]; // 집합 확인 배열 생성
            isEven = true; // 이분 그래프 확인 변수 생성

            for (int i = 1; i <= v; i++) { // 인접 리스트 초기화
                list[i] = new ArrayList<Integer>();
            }

            // 에지 데이터 저장
            for (int i = 0; i < e; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]); // 시작 노드
                int end = Integer.parseInt(s[1]); // 도착 노드
                // 방향성이 없기 때문에 양쪽에 추가
                list[start].add(end);
                list[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int i = 1; i <= v; i++) {
                if (isEven) { // 이분 그래프이면 dfs 실행
                    dfs(i);
                } else { // 이분 그래프가 아니면 반복 종료
                    break;
                }
            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true; // 방문 기록
        for (int i : list[start]) { // 인접 리스트로 받아서 start에서 연결된 모든 노드를 탐색하게 된다.
            if (!visited[i]) { // 방문하지 않은 노드면
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요
                check[i] = (check[start] + 1) % 2; // 0과 1로 집합 표시
                dfs(i); // 재귀 호출
            } else if (check[start] == check[i]) { // 인접 노드가 같은 집합이면
                isEven = false; // 이분 그래프가 아님
            }
        }
    }
}
