class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // Next Smallest Left
        int[] NSL = new int[n];
        // Next Smallest Right
        int[] NSR = new int[n];

        for(int i=0 ; i<n ; i++){
            NSL[i] = -1;
            NSR[i] = n;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            while(!stack.empty() && heights[stack.peek()] > heights[i]){
                NSR[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = 0 ; i < n ; i++){
            while(!stack.empty() && heights[stack.peek()] > heights[i]){
                stack.pop();
            }
            if(!stack.empty()){
                NSL[i] = stack.peek();
            }

            stack.push(i);
        }

        int max_area = 0;

        for(int i=0 ; i<n ; i++){
            int curr_height = heights[i];
            int width = NSR[i] - NSL[i] - 1;
            int curr_area = curr_height * width;

            if(curr_area>max_area){
                max_area = curr_area;
            }

        }


        return max_area;
        
    }
}