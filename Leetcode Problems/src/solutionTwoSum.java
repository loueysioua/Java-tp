public class solutionTwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] indexes = new int[2];
        for(int i=0 ; i<nums.length ; i++){
            for(int j=0 ; j<nums.length ; j++){
                if ( (nums[i] + nums[j] == target) && (j!=i) ){
                    indexes[0]=i ; indexes[1]=j;
                    return(indexes);
                }
            }
        }
        return(indexes);
    }
}
