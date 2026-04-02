class MedianFinder {

    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;
    public MedianFinder() {
        this.minQ = new PriorityQueue<>(Collections.reverseOrder());
        this.maxQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(minQ.size() > 0 ){
            if(minQ.peek() >= num) {
                minQ.add(num);
            } else {
                maxQ.add(num);
            }
        }else {
            System.out.println("Adding num: " + num);
            minQ.add(num);
        }

        if(minQ.size() == maxQ.size()) {
            return;
        }
        else if(minQ.size() < maxQ.size()){
            minQ.add(maxQ.poll());
        } else if (minQ.size() - maxQ.size() == 2) {
            maxQ.add(minQ.poll());
        }

        
    }
    
    public double findMedian() {
        if(minQ.size() == maxQ.size()){
            return (minQ.peek() + maxQ.peek()) / 2.0;
        } else {
            System.out.println("Median is: " + maxQ.peek() + 0.0);
            return minQ.peek().doubleValue();//todo
        }
        
    }
}
