import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Allocation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i < t + 1; i++) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int costs[] = new int[n];
            for (int j = 0; j < n; j++) {
                costs[j] = sc.nextInt();
            }
            int res = solve(n, b, costs);
            System.out.println(String.format("Case #%d: %d", i, res));
        }
    }

    static int solve(int n, int b, int[] costs) {
        int[] sol = new int[b+1];
        for (int i = 1; i < n+1; i++) {
            int[] old = new int[b+1];
            for (int k = 0; k < b + 1; k++) {
                old[k] = sol[k];
            }
            for (int j = 1; j < b+1; j++) {
                int c1 = 0;
                if(j - costs[i-1] >= 0) {
                    c1 = old[j - costs[i-1]] + 1;
                }
                int c2 = old[j];
                sol[j] = Math.max(c1, c2);
            }
        }
        return sol[b];
    }
}
