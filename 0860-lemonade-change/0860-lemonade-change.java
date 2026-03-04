class Solution {
    public boolean lemonadeChange(int[] bills) {
        // using hashmap
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<bills.length;i++){
        //     if(bills[i]==10){
        //         if(hm.containsKey(5) && hm.get(5)>=1){
        //             hm.put(5,hm.get(5)-1);
        //             if(hm.get(5)==0){
        //                 hm.remove(5);
        //             }
        //         }else{
        //             return false;
        //         }
        //     }else if(bills[i]==20){
        //         if(hm.containsKey(10) && hm.containsKey(5) && hm.get(10)>=1 && hm.get(5)>=1){
        //             hm.put(10,hm.get(10)-1);
        //             if(hm.get(10)==0){
        //                 hm.remove(10);
        //             }
        //             hm.put(5,hm.get(5)-1);
        //             if(hm.get(5)==0){
        //                 hm.remove(5);
        //             }
        //         }else if(hm.containsKey(5) &&hm.get(5)>=3){
        //             hm.put(5,hm.get(5)-3);
        //             if(hm.get(5)==0){
        //                 hm.remove(5);
        //             }
        //         }else{
        //             return false;
        //         }

        //     }
        //     hm.put(bills[i],hm.getOrDefault(bills[i],0)+1);
        // }
        // return true;

        // greedy approach
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==10){
                if(five>=1){
                    five--;
                }else{
                    return false;
                }
            }
            else if(bills[i]==20){
                if(ten>=1 && five>=1){
                    ten--;
                    five--;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }

            if(bills[i]==5)five++;
            else if(bills[i]==10)ten++;
        }
        return true;
    }
}