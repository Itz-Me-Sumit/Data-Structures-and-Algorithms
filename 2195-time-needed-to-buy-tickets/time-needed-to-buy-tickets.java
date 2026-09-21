class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int time = tickets[k];

        int kth = tickets[k];

        for(int i = 0 ; i < k ; i++){
            if(tickets[i] > kth){
                time+=kth;
            }
            else{
                time+=tickets[i];
            }
        }

        for(int i=k+1 ; i<tickets.length ; i++){
            
            if(tickets[i] > kth-1 ){
                time+=kth-1;
            }
            else{
                time+=tickets[i];
            }

        }

        return time;

    }
}