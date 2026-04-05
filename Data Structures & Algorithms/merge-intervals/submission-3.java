class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        LinkedList<int[]> result = new LinkedList<>();

        int[] currentInt = intervals[0];
        result.add(currentInt);

        for(int[] inter : intervals) {
            int endOfCur = currentInt[1];
            int newStart = inter[0];
            int newEnd = inter[1];

            if(endOfCur >= newStart) {
                currentInt[1] = Math.max(currentInt[1], newEnd);
            } else {
                currentInt = inter;
                result.add(currentInt);
            }            
        }
        return result.toArray(new int[result.size()][result.size()]);
    }
}
