import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        System.out.println(tiling(n));
    }

    public static int tiling(int num) {
        // Top-Down 방식
        // A[n] = 2*n 직사각형을 타일로 채우는 방법의 수
        // 점화식 : A[n] = A[n-1] + A[n-2]*2 (세로로 하나 놓았을 때 + 가로로 2개 놓았을 때와 2*2타일을 1개 놓았을 때)
        if (num < 2) { // 예외처리
            return memo[num];
        }
        if (memo[num-1] == 0) { // 푼 적 없는 부분 문제의 경우
            memo[num-1] = tiling(num-1);
        }
        if (memo[num-2] == 0) { // 푼 적 없는 부분 문제의 경우
            memo[num-2] = tiling(num-2);
        }
        memo[num] = memo[num-1] + memo[num-2]*2;
        memo[num] %= 10007;
        return memo[num];
    }
}
