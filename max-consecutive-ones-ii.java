//https://leetcode.com/problems/max-consecutive-ones-ii/
class max-consecutive-ones-ii {
    // tc -> n, sc-> 1
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0, end = 0;
        int max = 0, zeroIndex=0;
        while(end < nums.length){
            if(nums[end]==0){
                zeroIndex++;
            }
            end++;
            while(zeroIndex>1){
                if(nums[start]==0)
                zeroIndex--;
                start++;
            }            
            max = Math.max(max, end-start);            
        }
        return max;
    }

    //To handle scalability
    // tc -> n, sc-> n
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0, end = 0;
        int max = 0, zeroIndex=0;
        Queue<Integer> q = new LinkedList<>();        
        while(end < nums.length){
            if(nums[end]==0){
                q.offer(end);
            }
            end++;
            while(q.size()>1){
                start = q.poll()+1;
            }            
            max = Math.max(max, end-start);            
        }
        return max;
    }
}
