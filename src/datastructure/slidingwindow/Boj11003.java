package datastructure.slidingwindow;

import java.io.*;
import java.util.*;

public class Boj11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 데이터 개수
        int l = Integer.parseInt(st.nextToken()); // 최솟값을 구하는 범위
        Deque<Node> deque = new LinkedList<>(); // 데이터를 담을 덱 자료구조

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) { // n만큼 반복
            int now = Integer.parseInt(st.nextToken()); // 현재 데이터 값

            // 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while (!deque.isEmpty() && deque.getLast().value > now) { // 덱의 마지막 위치에서부터 now보다 큰 값은
                deque.removeLast(); // 덱에서 제거
            }

            deque.addLast(new Node(i, now)); // 덱의 마지막 위치에 now값 저장하기

            if (deque.getFirst().index <= i - l) { // 덱의 첫 번째 노드의 index가 l의 범위를 벗어난 값(index <= i - l)이면
                deque.removeFirst(); // 덱에서 제거
            }

            bw.write(deque.getFirst().value + " "); // 덱의 첫 번째 데이터 출력하기
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node { // 덱에 저장할 노드 클래스 별도 생성
        public int index; // 자신의 위치
        public int value; // 자신의 값

        public Node(int index, int value) { // 생성자로 받아서 저장
            this.index = index;
            this.value = value;
        }
    }
}
