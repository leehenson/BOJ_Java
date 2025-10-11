package numbertheory.euclideanalgorithm;

import java.util.*;
import java.io.*;

public class Boj1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()); // 1번째 수
        long b = Long.parseLong(st.nextToken()); // 2번째 수
        long result = gcd(a, b); // 결괏값

        // 결괏값만큼 1을 반복해 출력(출력 횟수가 많기 때문에 BufferedWriter 사용)
        while (result > 0) {
            bw.write("1");
            result--;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 최대 공약수를 구하는 메서드 구현
    private static long gcd(long a, long b) {
        if (b == 0) { // b가 0이면 a가 최대 공약수
            return a;
        } else {
            return gcd(b, a % b); // 재귀 함수 형태로 최대 공약수 찾기
        }
    }
}
