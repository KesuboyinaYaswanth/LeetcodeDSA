class MyCalendar {
    TreeMap<Integer,Integer> mp;
    public MyCalendar() {
        mp=new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer pre=mp.floorKey(startTime);
        Integer nxt=mp.ceilingKey(startTime);
        if((pre == null || mp.get(pre)<=startTime) && (nxt==null || nxt>=endTime)){
            mp.put(startTime,endTime);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */