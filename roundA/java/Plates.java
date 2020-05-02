import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.Math.max;

public class Plates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int m = 1; m < t + 1; m++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();

            int stacks[][] = new int[n][k];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    stacks[i][j] = sc.nextInt();
                }
                int curr = 0;
                for (int j = 0; j < k; j++) {
                    stacks[i][j] += curr;
                    curr = stacks[i][j];
                }
            }

            int res = solve(n, k, p, stacks);
            System.out.println(String.format("Case #%d: %d", m, res));
        }
    }

    private static int solve(int n, int k, int p, int[][] stacks) {
        int sol[][] = new int[p + 1][n * k + 1];
        for (int i = 1; i < p + 1; i++) {
            sol[i][0] = -1;
        }
        for (int i = 1; i < n * k + 1; i++) {
            for (int j = 1; j < p + 1; j++) {
                int c1, c2 = -1;
                c1 = sol[j][i - 1];
                int val = (i - 1) % k + 1;
                int num = (i - 1) / k;
                int left = j - val;
                if (left >= 0) {
                    c2 = sol[left][i - val];
                }
                if (c2 != -1) {
                    c2 += stacks[num][val - 1];
                }
                sol[j][i] = max(c1, c2);
            }
        }
        return sol[p][n * k];
    }
}
