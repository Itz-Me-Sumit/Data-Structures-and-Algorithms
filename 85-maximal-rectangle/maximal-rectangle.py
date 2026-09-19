class Solution:
    def maximalRectangle(self, matrix: list[list[str]]) -> int:
        
        rows = len(matrix)
        cols = len(matrix[0])
        n = cols
        max_area = 0

        heights = [0] * cols

        for row in range(rows):
            for col in range(cols):
                if(matrix[row][col] == '0'):
                    heights[col] = 0
                else:
                    heights[col]+=1
            
            stack = []

            for i in range(n):
                while(stack and heights[i]<heights[stack[-1]]):

                    curr_height = heights[stack[-1]]
                    stack.pop()

                    NSR = i
                    NSL = -1
                    if stack:
                        NSL = stack[-1]
                    
                    max_area = max(
                        max_area,
                        curr_height * (NSR - NSL - 1)
                    )
                stack.append(i)
            while(stack):
                
                curr_height = heights[stack[-1]]
                stack.pop()
                NSR = n
                NSL = -1
                if stack:
                    NSL = stack[-1]
                max_area = max(
                    max_area,
                    curr_height * (NSR - NSL - 1)
                )

        return max_area
