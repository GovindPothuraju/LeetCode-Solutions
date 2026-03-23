class Solution {
    // 1)using difference array
    /*public int maximumPopulation(int[][] logs) {
        int[] years=new int[2051];
        for(int i=0;i<logs.length;i++){
            int birth=logs[i][0];
            int death=logs[i][1];
            years[birth]++;
            years[death]--;
        }
        int res=0;
        int max=0;
        int curr=0;
        for(int i=1950;i<2051;i++){
            curr+=years[i];
            if(curr > max){
                res=i;
                max=curr;
            }
        }

        return res;
    }*/

    // 2) using linesweep algorithm
    public int maximumPopulation(int[][] logs) {
        List<int[]> events = new ArrayList<>();

        // Step 1: Create events
        for (int[] log : logs) {
            events.add(new int[]{log[0], 1});  // birth
            events.add(new int[]{log[1], -1}); // death
        }

        // Step 2: Sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // +1 before -1
            return a[0] - b[0];
        });

        for (int[] e : events) {
            System.out.println(Arrays.toString(e));
        }
        int curr = 0;
        int maxPop = 0;
        int year = 0;

        // Step 3: Sweep
        for (int[] e : events) {
            curr += e[1];

            if (curr > maxPop) {
                maxPop = curr;
                year = e[0];
            }
        }

        return year;
    }
}