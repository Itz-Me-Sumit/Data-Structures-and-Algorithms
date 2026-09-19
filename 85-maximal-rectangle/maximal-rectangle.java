class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int max_area = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = cols;
        int[] heights = new int[cols];

        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){

                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }
                else{
                    heights[j]++;
                }

            }

            Stack<Integer> stack = new Stack<>();

            for(int j=0 ; j<cols ; j++){

                while(!stack.empty() && heights[j]<heights[stack.peek()]){
                    int curr_height = heights[stack.peek()];
                    stack.pop();
                    int NSR = j;
                    int NSL;

                    if(stack.empty()){
                        NSL = -1;
                    }
                    else{
                        NSL = stack.peek();
                    }

                    int curr_area = curr_height * ( NSR - NSL - 1 );
                    if(curr_area > max_area){
                        max_area = curr_area;
                    }

                }
                stack.push(j);

            }

            while(!stack.empty()){
                int curr_height = heights[stack.peek()];
                stack.pop();
                int NSR = n;
                int NSL;
                if(stack.empty()){
                    NSL = -1;
                }
                else{
                    NSL = stack.peek();
                }

                int curr_area = curr_height * (NSR - NSL - 1);
                if(curr_area > max_area){
                    max_area = curr_area;
                }

            }

        }

        return max_area;

    }
}