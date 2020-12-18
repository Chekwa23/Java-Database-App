-- show variables like 'secure_file_priv';
USE `Group78`;

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/tweets.csv' 
into table group78.tweet
fields terminated by ';' OPTIONALLY ENCLOSED BY '"' 
lines terminated by '\n'
ignore 1 lines
(tid,textbody,retweet_count,retweeted,@col7,posting_user)
set posted = @col7, created_at = UNIX_TIMESTAMP(@col7) * 1000;

INSERT into group78.newtweet
SELECT tid, textbody, retweet_count, retweeted, day(posted), month(posted), year(posted), posting_user FROM group78.tweet;

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/tagged.csv' 
into table group78.hashtags
fields terminated by ';' OPTIONALLY ENCLOSED BY '"' 
lines terminated by '\n'
ignore 1 lines
(tid,tag_name);

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/urlused.csv' 
into table group78.urls
fields terminated by ';' OPTIONALLY ENCLOSED BY '"' 
lines terminated by '\n'
ignore 1 lines
(tid,address);

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/user.csv' 
into table group78.users
fields terminated by ';' OPTIONALLY ENCLOSED BY '"' 
lines terminated by '\n'
ignore 1 lines
(screen_name,user_name,subCategory,category,state,numFollowers,numFollowing);

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/mentioned.csv' 
into table group78.mentions
fields terminated by ';' OPTIONALLY ENCLOSED BY '"' 
lines terminated by '\n'
ignore 1 lines
(tid,screen_name);


