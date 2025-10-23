package numbertheory.euclideanalgorithm;

import java.util.*;

public class Boj1033 {

    private static List<Node>[] edgeList;
    private static long lcm;
    private static boolean[] visited;
    private static long[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 재료 개수
        edgeList = new ArrayList[n]; // 인접 리스트
        visited = new boolean[n]; // dfs를 탐색할 때 탐색 여부 저장 배열
        distance = new long[n]; // 각 노드값 저장 배열
        lcm = 1; // 최소 공배수

        // 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) { // 에지 개수만큼 반복
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            // 인접 리스트 배열에 에지 정보를 저장
            edgeList[a].add(new Node(b, p, q));
            edgeList[b].add(new Node(a, q, p));

            lcm *= (p * q / gcd(p, q)); // 최소 공배수 업데이트 (최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것)
        }

        distance[0] = lcm; // 0번 노드에 최소 공배수 저장
        dfs(0); // 0번에서 dfs 탐색 수행

        long mgcd = distance[0]; // 최대 공약수

        // dfs를 이용해 업데이트된 distance 배열의 값들의 최대 공약수를 계산
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, distance[i]);
        }

        // distance 배열의 각 값들을 최대 공약수로 나눠 정답 출력
        for (int i = 0; i < n; i++) {
            System.out.print(distance[i] / mgcd + " ");
        }
    }

    // 촤대 공약수 gcd() 함수 구현
    private static long gcd(long a, long b) {
        if (b == 0) { // b가 0이면
            return a; // a가 최대 공약수
        } else {
            // 재귀 함수 형태로 구현
            return gcd(b, a % b);
        }
    }

    // 깊이 우선 탐색 함수 구현
    private static void dfs(int num) {
        visited[num] = true; // visited 배열에 현재 노드 방문 기록

        for (Node n : edgeList[num]) { // 현재 노드의 연결 노드 중
            int next = n.getB();

            if (!visited[next]) { // 방문하지 않은 노드로
                // 주어진 비율로 다음 노드값 갱신
                distance[next] = distance[num] * n.getQ() / n.getP(); // 다음 노드 값 = 현재 노드 값 * 비율로 저장
                dfs(next); // 재귀 형태의 dfs 실행
            }
        }
    }

    static class Node {

        int b; // 다음 노드
        int p; // 비율 1
        int q; // 비율 2

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
