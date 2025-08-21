import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();

            if (data > 1) {
                plusQueue.offer(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusQueue.offer(data);
            }
        }

        while (plusQueue.size() > 1) {
            int first = plusQueue.poll();
            int second = plusQueue.poll();

            sum += first * second;
        }

        if (!plusQueue.isEmpty()) {
            sum += plusQueue.poll();
        }

        while (minusQueue.size() > 1) {
            int first = minusQueue.poll();
            int second = minusQueue.poll();

            sum += first * second;
        }

        if (!minusQueue.isEmpty()) {
            if (zero == 0) {
                sum += minusQueue.poll();
            }
        }

        sum += one;
        System.out.println(sum);
    }
}