import java.util.*;

class Solution {
    public ArrayList<Integer> SB = new ArrayList<>();
    public ArrayList<Integer> DT = new ArrayList<>();
    public int INF = 987654321;
    public int[][] dp;

    public void init(int t) {
        //dp 초기화
        for (int i = 1; i <= t; i++)
            for (int j = 0; j < 1; j++)
                dp[i][j] = INF;

        //Single, Ball 숫자 넣어줌
        SB.add(50);
        for (int i = 1; i < 21;i++)
            SB.add(i);
        //Double, Tripple 숫자 넣어줌
        for (int i = 1; i < 21; i++) {
            for (int j = 2; j < 4; j++) {
                if (i * j <= 20) continue;
                DT.add(i*j);
            }
        }
    }

    public void setMin(int[] res, int[] comp) {
        if (res[0] > comp[0]) {
            res[0] = comp[0];
            res[1] = comp[1];
        } else if (res[0] == comp[0]) {
            if (res[1] < comp[1])
                res[1] = comp[1];
        }
    }

    public int[] solve(int remain) {
        //기저조건1. 0일 경우
        if (remain == 0) return new int[] {0, 0};
        //기저조건2. 0보다 작을 경우
        if (remain < 0) return new int[] {INF, INF};
        //기저조건3. dp에 존재할 경우
        if (dp[remain][0] != INF) return dp[remain];

        int[] result = new int[] {INF, INF};

        //Single, Ball 숫자 순회 tmpRes[0] + 1, tmpRes[0] + 1
        for (int i = 0; i < SB.size(); i++) {
            int[] tmpRes = solve(remain - SB.get(i));
            setMin(result, new int[] {tmpRes[0] + 1, tmpRes[1] + 1});
        }
        //Double, Tripple 숫자 순회
        for (int i = 0; i < DT.size(); i++) {
            int[] tmpRes = solve(remain - DT.get(i));
            setMin(result, new int[] {tmpRes[0] + 1, tmpRes[1]});;
        }

        dp[remain][0] = result[0];
        dp[remain][1] = result[1];
        return dp[remain];
    }

    public int[] solution(int target) {
        dp = new int[target + 1][2];
        init(target);
        return solve(target);
    }
}