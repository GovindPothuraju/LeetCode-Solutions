# Write your MySQL query statement below

select 
    w1.id as Id
from Weather as w
join Weather as w1
on DATEDIFF(w1.recordDate, w.recordDate) = 1
and w.temperature < w1.temperature;