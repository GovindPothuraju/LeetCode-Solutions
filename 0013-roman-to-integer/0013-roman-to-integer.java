class Solution {
    /* hashmap with o(n) and o(1) space 
    
    public int romanToInt(String s) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("I",1);
        hm.put("V",5);
        hm.put("X",10);
        hm.put("L",50);
        hm.put("C",100);
        hm.put("D",500);
        hm.put("M",1000);
        hm.put("IV",4);
        hm.put("IX",9);
        hm.put("XL",40);
        hm.put("XC",90);
        hm.put("CD",400);
        hm.put("CM",900);
        int n=s.length();
        int i=0;
        int res=0;
        while(i<n){
            if(i<=n-2 && hm.containsKey(s.substring(i,i+2))){
                res+=hm.get(s.substring(i,i+2));
                i++;
            }else{
                res+=hm.get(s.substring(i,i+1));
            }
            i++;
        }
        System.out.println(res);
        return res;
    }*/

    public int romanToInt(String s) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("I",1);
        hm.put("V",5);
        hm.put("X",10);
        hm.put("L",50);
        hm.put("C",100);
        hm.put("D",500);
        hm.put("M",1000);

        int res=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            int curr=hm.get(s.substring(i,i+1));
            int next= (i+1<n) ? hm.get(s.substring(i+1,i+2)) :0 ;
            if(curr<next){
                res-=curr;
            }else{
                res+=curr;
            }
        }
        return res;
    }
}