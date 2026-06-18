class Solution {
    public double angleClock(int hour, int minutes) {

        double hoursHand =(5*hour) + (minutes / 12.0);
        int minutesHand = minutes;
        double gap = Math.abs(hoursHand - minutesHand);

        double minMinutes= Math.min(gap, 60-gap);
        double res = 6* minMinutes;
        return res;
    }
}