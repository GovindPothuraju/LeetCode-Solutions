class Solution {
    public String frequencySort(String s) {
        int[] arr=new int[128];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch]++;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(max>0){
           for(int i=0;i<arr.length;i++){
                if(arr[i]==max){
                    int temp=max;
                    while(temp>0){
                        sb.append((char)(i));
                        temp--;
                    }
                }
            }
            max--;
        }
        return sb.toString();
    }
}