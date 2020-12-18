
-- Q3
drop procedure if exists question3;
create procedure question3(in k int, in yr int)
	select count(distinct u.state) as statenum, group_concat(distinct u.state) as states, h.tag_name as name
	from hashtags h, users u, tweet t
	where h.tid = t.tid and t.posting_user = u.screen_name and year(t.posted) = yr and u.state != "na" and u.state != ""
	group by h.tag_name
	order by statenum desc limit k;
-- call question3(5, 2016);

-- Q7
drop procedure if exists question7;
create procedure question7(in k int, in givenHashTag text, in givenState text, in givenMonth int, in givenYear int)
	select count(t.tid) as tweet_count, u.screen_name, u.category
	from hashtags h, users u, tweet t
	where h.tid = t.tid and t.posting_user = u.screen_name and h.tag_name = givenHashTag and u.state = givenState and month(t.posted) = givenMonth and year(t.posted) = givenYear
	group by u.screen_name
	order by count(t.tid) desc limit k;
-- call question7(5, "GOPDebate", "North Carolina", 2, 2016);

-- Q9
drop procedure if exists question9;
create procedure question9(in k int, in givenParty text)
	select u.screen_name, u.subCategory, u.numFollowers
	from users u
	where u.subCategory = givenParty
	order by u.numFollowers desc limit k;
-- call question9(5,"GOP");

-- Q16
drop procedure if exists question16;
create procedure question16(in k int, in givenMonth int, in givenYear int)
	select u.user_name, u.category, t.textbody, t.retweet_count, ur.address
	from users u, urls ur, tweet t
	where t.tid = ur.tid and t.posting_user = u.screen_name and month(t.posted) = givenMonth and year(t.posted) = givenYear
	order by t.retweet_count desc limit k;
-- call question16(5, 2, 2016);users

-- Q18
drop procedure if exists question18;
create procedure question18(in k int, in givenParty text, in givenMonth int, in givenYear int)
	select m.screen_name as mentionedUser, u1.state as mentionedUserState, group_concat(distinct u.screen_name) as postingUsers 
	from users u, tweet t, mentions m, users u1
	where u.subCategory = givenParty and t.posting_user = u.screen_name and u1.screen_name = m.screen_name and t.tid = m.tid and month(t.posted) = givenMonth and year(t.posted) = givenYear
	group by m.screen_name
	order by count(m.tid) desc limit k;
-- call question18(5, "GOP", 1, 2016);

-- Q23
drop procedure if exists question23;
create procedure question23(in k int, in givenParty text, in monthList text, in givenYear int)
	select h.tag_name as name, count(distinct h.tid) as num_uses
	from hashtags h, users u, tweet t
	where t.posting_user = u.screen_name and u.subCategory = givenParty and h.tid = t.tid and find_in_set(month(t.posted), monthList) and year(t.posted) = givenYear
	group by h.tag_name
	order by count(h.tid) desc limit k;
-- call question23(5, "GOP", "1,2,3", 2016);