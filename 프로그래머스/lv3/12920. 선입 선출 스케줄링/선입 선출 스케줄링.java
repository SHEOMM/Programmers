import java.util.*;

class Solution {
    public int N;
    public int[] C;
    public int INF = 987654321;

    public int check(int t) {
        List<Integer> zeroList = new ArrayList<>();

        int insertCnt = 0;

        for (int i = 0; i < C.length; i++) {
            insertCnt += (t / C[i] + 1);
            if (t % C[i] == 0)
                zeroList.add(i + 1);
        }

        if (insertCnt < N) return INF;
        else if (N <= insertCnt - zeroList.size()) return -INF;
        //마지막 작업 코어 번호 리턴
        else {
            return zeroList.get(N - (insertCnt - zeroList.size()) - 1);
        }
    }

    public int solution(int n, int[] cores) {

        N = n;
        C = cores;
        int maxT = 0;
        for (int i = 0; i < C.length; i++)
            maxT = Math.max(maxT, C[i]);

 
        int hi = N * maxT / C.length + 1;
        int lo = 0;

        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int res = check(mid);

            if (res == INF) lo = mid;
            else if (res == -INF) hi = mid;
            else return res;
        }
        return 0;
    }
}