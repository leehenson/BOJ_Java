package search.bfs;

import java.io.*;
import java.util.*;

public class Boj2178 {

    static int[] dx = {0, 0, -1, 1}; // 상하좌우 x방향
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우 y방향
    static boolean[][] visited; // 방문 기록을 담는 배열
    static int[][] edgeList; // 미로를 담는 배열
    static int n, m; // 미로의 세로, 가로 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 미로의 세로 길이
        m = Integer.parseInt(st.nextToken()); // 미로의 가로 길이
        visited = new boolean[n][m]; // 방문 기록 배열 생성
        edgeList = new int[n][m]; // 미로 배열 생성

        // 입력값을 받아 미로 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                edgeList[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        bfs(0, 0); // bfs 시작
        System.out.println(edgeList[n - 1][m - 1]); // 도착 위치의 값(최단 거리) 출력
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j}); // 시작점 좌표를 큐에 저장
        visited[i][j] = true; // 시작점 좌표 방문 기록
        while (!queue.isEmpty()) { // 큐에 값이 없을 때까지 반복
            int[] now = queue.poll(); // 큐에 값을 꺼내서 현재 좌표에 저장
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k]; // 현재 좌표에서 상하좌우의 x좌표
                int y = now[1] + dy[k]; // 현재 좌표에서 상하좌우의 y좌표
                if (x >= 0 && y >= 0 && x < n && y < m) { // 이동한 좌표가 미로의 범위를 넘어서면 안되고
                    if (edgeList[x][y] != 0 && !visited[x][y]) { // 0이여서 갈 수가 없거나 방문한 곳이면 안됨
                        visited[x][y] = true; // 이동 가능한 좌표를 방문 기록
                        edgeList[x][y] = edgeList[now[0]][now[1]] + 1; // 시작점에서 이동 가능한 좌표까지의 최대 거리를 저장
                        queue.offer(new int[]{x, y}); // 이동 가능한 좌표를 큐에 저장
                    }
                }
            }
        }
    }
}
