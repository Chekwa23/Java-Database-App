use group78;
SELECT @@innodb_buffer_pool_size/1024/1024/1024 ;

-- Q3
-- Increased buffer pool size 
SET GLOBAL innodb_buffer_pool_size=402653184;

-- Q7
-- Created an index on tag_name attribute of the hashtags relation
create index hastagName on hashtags (tag_name);

-- Q9
-- Created an index on subCatergory attribute of the users relation
-- so instead of a full table scan it uses an index lookup
create index subCatQ9 on users (subCategory);

-- Q16
-- I rewrote the query by using a similar table there by discarding the use of functions on the left hand side
-- of the operator (month() = 3).

-- Q18 
-- I rewrote the query using inner joins instead of cartesian joins

-- Q23
-- Increased buffer pool size 
SET GLOBAL innodb_buffer_pool_size=402653184;

