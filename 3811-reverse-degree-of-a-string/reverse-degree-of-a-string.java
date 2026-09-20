class Solution {
    public int reverseDegree(String s) {
        
        int res = 0;

        for(int i=0 ; i<s.length() ; i++){

            int string_index = i+1;
            int reversed_index = 26 - ((int) s.charAt(i) % 97);

            res += string_index * reversed_index;

        }

        return res;

    }
}