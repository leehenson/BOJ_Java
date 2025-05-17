package datastructure.stackandqueue;

import java.util.*;

public class Boj1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 수열의 개수
        int[] arr = new int[n]; // 수열 선언
        Stack<Integer> stack = new Stack<>(); // 빈 스택 생성
        int num = 1; // 시작값
        boolean possible = true; // 스택 구조인지 확인
        StringBuilder sb = new StringBuilder(); // 정답을 답을 StringBuilder

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 수열 담기
        }

        for (int i = 0; i < arr.length; i++) {
            int e = arr[i]; // 수열에서 값을 꺼닌다.
            if (e >= num) { // 꺼낸 값이 현재의 num값 보다 크거나 같다면
                while (e >= num) { // num값이 꺼낸 값과 크거나 같아질 때까지
                    stack.push(num++); // num값을 스택에 담아주고, num을 1 증가시킨다.
                    sb.append("+\n"); // 그리고 sb에 "+"를 추가한다.
                }
                stack.pop(); // num이 꺼낸 값과 같아졌기 때문에 stack에서 값을 꺼내준다.
                sb.append("-\n"); // sb에 "-"를 추가해준다.
            } else { // num이 꺼낸 값보다 작다면
                int t = stack.pop(); // 스택에서 값을 pop한다.
                if (t != e) { // pop한 값이 수열에서 꺼낸 값과 다르다면
                    System.out.println("NO"); // 스택 구조에 어긋에 나기 때문에 NO를 출력하고
                    possible = false; // 스택 구조가 아니라는 뜻의 possible를 false로 변환한다.
                    break; // 반복문을 중단한다.
                } else {
                    sb.append("-\n"); // pop한 값이 수열에서 꺼낸 값과 같다면, 정답에 "-"를 추가한다.
                }
            }
        }
        if (possible) { // 스택 구조가 올바르다면
            System.out.println(sb); // 정답을 출력한다.
        }
    }
}
