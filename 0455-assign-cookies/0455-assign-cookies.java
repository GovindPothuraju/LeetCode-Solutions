class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res=0;
        int i=0;
        int j=0;
        while(i<g.length && j<s.length){
            if(g[i]>s[j]){
                j++;
            }else{
                res++;
                i++;
                j++;
            }
        }
        return res;
    }
}