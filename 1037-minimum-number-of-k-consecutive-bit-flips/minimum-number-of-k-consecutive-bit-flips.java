class Solution {
    public int minKBitFlips(int[] nums, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int flip = 0;
        int n = nums.length;

        for(int i=0 ; i<n ; i++){
            if(!queue.isEmpty() && queue.peek() < i){
                queue.poll();
            }
            if(queue.size() % 2 == nums[i]){
                if(i+k-1 >= n){
                    return -1;
                }
                queue.add(i+k-1);
                flip++;
            }
        }

        return flip;

    }
}