/*
APPROACH (Using Minute Scale)

Instead of calculating angles directly,
convert both clock hands to positions on a 0-60 scale.

Minute Hand:
-------------
At 15 minutes -> position 15
At 30 minutes -> position 30
So,
minuteHand = minutes

Hour Hand:
-----------
Each hour corresponds to 5 minute marks.

12 -> 0
1  -> 5
2  -> 10
3  -> 15
...

Base Position:
hour * 5

The hour hand moves continuously.
In 60 minutes it moves 5 minute marks.

So in 'minutes' minutes it moves:

(5/60) * minutes
= minutes / 12

Therefore,

hourHand = hour * 5 + minutes / 12.0

Example:
---------
3:30

hourHand   = 3*5 + 30/12.0
           = 15 + 2.5
           = 17.5

minuteHand = 30

Find Gap:
----------
gap = abs(hourHand - minuteHand)

Since there are two angles between hands,
take the smaller gap:

gap = min(gap, 60 - gap)

Convert Gap to Degrees:
------------------------
60 minute marks = 360 degrees

1 minute mark = 6 degrees

angle = gap * 6

Time Complexity : O(1)
Space Complexity: O(1)
*/

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