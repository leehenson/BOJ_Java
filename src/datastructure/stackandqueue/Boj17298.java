package datastructure.stackandqueue;

import java.util.*;
import java.io.*;

public class Boj17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1. 수열 개수
        int[] arr = new int[n]; // 1. 수열 배열
        int[] answers = new int[n]; // 1. 정답 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2. 수열 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 3. 처음에는 항상 스택이 비어 있으므로 최초 값을 push하여 초기화

        for (int i = 1; i < n; i++) { // 4. 최초 값 0은 넣었기 때문에 1부터 n까지 반복
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) { // 5. 스택이 비어 있지 않고, 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 때까지 반복
                answers[stack.pop()] = arr[i]; // 6. 현재 수열이 스택 top 인덱스가 가리키는 수열보다 크다면 현재 수열이 오큰수이기 때문에 정답 배열에 오큰수를 현재 수열로 저장하기
            }
            stack.push(i); // 7. 현재 수열을 스택에 넣기
        }
        while (!stack.isEmpty()) { // 8. 반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지
            answers[stack.pop()] = -1; // 9. 스택에 있는 index에 -1을 넣기
        }

        // 10. 정답 배열 출력
        for (int i = 0; i < n; i++) {
            System.out.print(answers[i] + " ");
        }

        br.close();
    }
}
