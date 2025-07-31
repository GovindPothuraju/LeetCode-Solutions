class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       /* o(n*m);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            hm.put(nums2[i],i);
        }
        int n=nums1.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=-1;
        }
        for(int i=0;i<n;i++){
            int temp=nums1[i];
            int index=hm.get(temp);
            for(int j=index+1;j<nums2.length;j++){
                if(nums2[j]>temp){
                    res[i]=nums2[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return res;*/
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            // If stack top is smaller, it's the next greater for that number
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;

    }
}