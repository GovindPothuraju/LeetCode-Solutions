class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        if(n<7)return 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = text.charAt(i);
            if(ch=='b'||ch=='a'||ch=='l'||ch=='o'||ch=='n'){
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
        }
        System.out.println(hm);
        int count = 0;
        String temp = "balloon";
        while(hm.size() == 5){
            for(int i=0;i<temp.length();i++){
                char ch = temp.charAt(i);
                if(!hm.containsKey(ch)){
                    return count;
                }
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) == 0)hm.remove(ch);
            }
            count++;
        }
        return  count;
    }
}