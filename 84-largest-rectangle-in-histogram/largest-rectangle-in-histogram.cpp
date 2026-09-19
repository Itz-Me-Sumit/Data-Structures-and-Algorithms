class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        int n = heights.size();
        int max_area = 0;
        stack<int> stack;

        for(int i=0 ; i<n ; i++){
            
            while(!stack.empty() && heights[stack.top()] > heights[i] ){
                int curr_height = heights[stack.top()];
                int NSR = i;
                int NSL;
                stack.pop();
                if(stack.empty()){
                    NSL = -1;
                }
                else{
                    NSL = stack.top();
                }

                int curr_area = curr_height * (NSR - NSL - 1);
                if(curr_area > max_area){
                    max_area = curr_area;
                }

            }
            stack.push(i);

        }

        while(!stack.empty()){
            int NSR = n;
            int NSL;

            int curr_height = heights[stack.top()];

            stack.pop();
            if(stack.empty()){
                NSL = -1;
            }
            else{
                NSL = stack.top();
            }

            int curr_area = curr_height * (NSR - NSL - 1);
            
            if(curr_area > max_area){
                max_area = curr_area;
            }
        }

        return max_area;

    }
};