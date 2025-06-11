package datastructure.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {

    static int[] checkArr = new int[4]; // 필요한 DNA 문자 최소 개수
    static int[] currentArr = new int[4]; // 현재 윈도우의 DNA 문자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int p = Integer.parseInt(st.nextToken()); // 윈도우의 길이
        char[] str = br.readLine().toCharArray(); // 문자열을 문자 배열로 받기
        int result = 0; // 결과

        // 필요한 DNA 문자 최소 개수 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우 초기화
        for (int i = 0; i < p; i++) {
            add(str[i]);
        }
        if (check()) result++; // 초기 윈도우에 정답이 있으면 카운트 올리기

        // 슬라이딩 윈도우
        for (int j = p; j < s; j++) {
            int i = j - p;
            add(str[j]);
            remove(str[i]);
            if (check()) result++;
        }

        System.out.println(result);
    }

    // 들어오는 문자에 따라 현재 윈도우의 DNA 문자 개수 더하기
    private static void add(char c) {
        if (c == 'A') currentArr[0]++;
        if (c == 'C') currentArr[1]++;
        if (c == 'G') currentArr[2]++;
        if (c == 'T') currentArr[3]++;
    }

    // 들어오는 문자에 따라 현재 윈도우의 DNA 문자 개수 빼기
    private static void remove(char c) {
        if (c == 'A') currentArr[0]--;
        if (c == 'C') currentArr[1]--;
        if (c == 'G') currentArr[2]--;
        if (c == 'T') currentArr[3]--;
    }

    // 현재 윈도우가 조건에 충족하는지 검사
    private static boolean check() {
        for (int i = 0; i < checkArr.length; i++) {
            if (currentArr[i] < checkArr[i]) {
                return false;
            }
        }
        return true;
    }
}
