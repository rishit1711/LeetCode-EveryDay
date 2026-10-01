class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        int[] result = new int[n];
        for(int i = n-1;i>=0;i--){
            st.push(arr[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                result[i]=-1;
            }
            else result[i]=st.peek();
                st.push(arr[i]);

        }
        return result;
    }
}