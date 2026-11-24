class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();

        int n = s.length();

        // i need numRows arrays
        for(int i=0 ; i<numRows ; i++){
            arr.add(new ArrayList<>());
        }
        // boolean for forward or reverse
        boolean direction = true;
        int temp = 0;
        for(int i=0 ; i<n ; i++){
            char ch = s.charAt(i);
            arr.get(temp).add(ch);
            
            if(temp == numRows-1){
                direction = false;
            }else if(temp == 0){
                direction = true;
            }

            temp += direction ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<numRows ; i++){
            int len = arr.get(i).size();
            for(int j=0 ; j<len ; j++){
                sb.append(arr.get(i).get(j));
            }
        }
        return sb.toString();
    }
}