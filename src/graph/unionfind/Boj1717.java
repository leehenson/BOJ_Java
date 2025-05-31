package graph.unionfind;

import java.util.*;

public class Boj1717 {

    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 개수 -1
        int m = sc.nextInt(); // 질의의 개수
        parent = new int[n + 1]; // 대표 배열 선언

        // 대표 노드 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 질의 계산
        for (int i = 0; i < m; i++) {
            int question = sc.nextInt(); // 질의의 종류 0 or 1
            int a = sc.nextInt(); // 첫 번째 노드
            int b = sc.nextInt(); // 두 번째 노드

            if (question == 0) {
                union(a, b); // 첫 번째 노드와 두 번째 노드를 연결
            } else { // 두 원소가 같은 집합인지 확인
                if (find(a) == find(b)) { // union 연산을 통해 경로 압축을 하였기 때문에 같은 집합이라면 두 노드의 대표 노드가 같아야 한다.
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // 주어진 두 노드를 연결 (합집합 연산)
    private static void union(int a, int b) {
        a = find(a); // 첫 번째 노드의 대표 노드
        b = find(b); // 두 번째 노드의 대표 노드
        if (a != b) { // 두 대표 노드가 다르다면 (같은 집합이 아니라면)
            parent[b] = a; // 두 번째 노드의 대표 노드의 대표 노드를 첫 번째 노드의 대표 노드로 변경
        }
    }

    // 대표 노드를 찾는다.
    private static int find(int a) {
        if (parent[a] == a) { // 노드의 인덱스와 값이 같으면
            return a; // 해당 노드가 대표 노드이기 때문에 해당 노드를 그대로 반환
        }
        // 노드의 인덱스와 값이 다르면 해당 노드는 대표 노드가 아니기 때문에
        parent[a] = find(parent[a]); // 재귀 호출을 통해 대표 노드를 찾고, 해당 노드의 대표 노드를 찾은 대표 노드로 변경
        return parent[a]; // 찾은 대표 노드를 반환
    }
}
