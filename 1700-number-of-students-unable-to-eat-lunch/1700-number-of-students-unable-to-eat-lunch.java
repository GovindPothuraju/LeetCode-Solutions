class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<students.length;i++){
            q.offer(students[i]);
        }
        System.out.println(q);

        Stack<Integer> st=new Stack<>();
        for(int i=sandwiches.length-1 ; i>=0 ;i--){
            st.push(sandwiches[i]);
        }
        System.out.println(st);

        int n=students.length;
        int count=0;
        while(!st.isEmpty() && !q.isEmpty()){
            if(st.peek()==q.peek()){
                st.pop();
                q.poll();
                count=0;
            }
            else{
                int ele=q.poll();
                q.offer(ele);
                count++;
                if(count==q.size()){
                    break;
                }
            }
        }
        return q.size();
    }
}