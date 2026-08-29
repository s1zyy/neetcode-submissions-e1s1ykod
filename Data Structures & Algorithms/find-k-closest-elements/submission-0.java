class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length-1;
        while(right-left+1 > k) {
            if(Math.abs(x-arr[left]) > Math.abs(arr[right]-x)){
                left++;
            } else {
                right--;
            }
        }
        for(int i = left; i < right+1; i++){
            list.add(arr[i]);
        }
        return list;
        
    }
}