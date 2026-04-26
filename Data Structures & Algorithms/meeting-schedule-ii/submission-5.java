/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int size = intervals.size();
        if(size == 0) return 0;
        if(size == 1) return 1;

        int[] starts = new int[size];
        int[] ends = new int[size];

        for (int i = 0; i < size; i++) {
            Interval cur = intervals.get(i);
            starts[i] = cur.start;
            ends[i] = cur.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int counter = 0;

       
        int s = 0; 
        int e = 0;
        int max = 0;

        while (s < size) {
            if(starts[s] < ends[e]) {
                counter++;
                s++;
            } else if(starts[s] >= ends[e]){
                counter--;
                e++;
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}
