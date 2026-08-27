class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int counter = 0;
        int left = 0; int right = people.length-1;
        while(left<=right) {
            if(people[right] + people[left] > limit){
                counter++;
                right--;
            } else {
                left++;
                right--;
                counter++;
            }
        }
        return counter;

    }
}