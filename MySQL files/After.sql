
-- Q3
select h.tag_name, count(distinct u.state) Number_Of_States, group_concat(distinct u.state) as States 
from hashtags h, users u, tweet t
where h.tid = t.tid and t.posting_user = u.screen_name and year(t.posted) = 2016 and u.state != "na" and u.state != ""
group by h.tag_name
order by Number_Of_States desc limit 5;

-- Q7
select count(t.tid) as tweet_count, u.screen_name, u.category
from hashtags h, users u, tweet t
where h.tid = t.tid and t.posting_user = u.screen_name and h.tag_name = "GOPDebate" and u.state = "NC" and month(t.posted) = 2 and year(t.posted) = 2016
group by u.screen_name
order by count(t.tid) desc limit 5;

-- Q9
select u.screen_name, u.subCategory, u.numFollowers
from users u
where u.subCategory = "Democrat"
order by u.numFollowers desc limit 5;

-- Q16
select u.user_name, u.category, t.textbody, t.retweet_count, ur.address
from users u, urls ur, newtweet t
where t.tid = ur.tid and t.posting_user = u.screen_name and t.month_posted = 2 and t.year_posted = 2016
order by t.retweet_count desc limit 5;

-- Q18
select m.screen_name as mentionedUser, u1.state as mentionedUserState, group_concat(distinct u.screen_name) as postingUsers 
from (((users u 
inner join tweet t on u.subCategory = "GOP" and t.posting_user = u.screen_name)
inner join mentions m on t.tid = m.tid and month(t.posted) = 1 and year(t.posted) = 2016)
inner join users u1 on u1.screen_name = m.screen_name )
group by m.screen_name
order by count(m.tid) desc limit 5;

-- Q23
select h.tag_name as name, count(distinct h.tid) as num_uses
from hashtags h, users u, tweet t
where t.posting_user = u.screen_name and u.subCategory = "GOP" and h.tid = t.tid and month(t.posted) in (1,2,3) and year(t.posted) = 2016
group by h.tag_name
order by count(h.tid) desc limit 5;

-- ----------------------------------------------------------------------------------------------------------------
drop index subCatQ9 on users;
drop index hastagName on hashtags;
