# Write your MySQL query statement below
select round(sum(ordered=prefered)/count(distinct customer_id) *100,2) as  immediate_percentage
from (
    select customer_id ,
    min( order_date ) as ordered,
    min(customer_pref_delivery_date) as prefered
    from Delivery
    group by customer_id 
) as t;