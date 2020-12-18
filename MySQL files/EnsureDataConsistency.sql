use group78;

SET SQL_SAFE_UPDATES = 0;

update users set state = "AL" where state like "%Alabama%";

update users set state = "AK" where state like "%Alaska%";

update users set state = "AZ" where state like "%Arizona%";

update users set state = "AR" where state like "%Arkansas%";

update users set state = "CA" where state like "%California%";

update users set state = "CO" where state like "%Colorado%";

update users set state = "CT" where state like "%Connecticut%";

update users set state = "DE" where state like "%Delaware%";

update users set state = "DC" where state like "%District of Columbia%";

update users set state = "FL" where state like "%Florida%";

update users set state = "GA" where state like "%Georgia%";

update users set state = "HI" where state like "%Hawaii%";

update users set state = "ID" where state like "%Idaho%";

update users set state = "IL" where state like "%Illinois%";

update users set state = "IN" where state like "%Indiana%";

update users set state = "IA" where state like "%Iowa%";

update users set state = "KS" where state like "%Kansas%";

update users set state = "KY" where state like "%Kentucky%";

update users set state = "LA" where state like "%Louisiana%";

update users set state = "ME" where state like "%Maine%";

update users set state = "MD" where state like "%Maryland%";

update users set state = "MA" where state like "%Massachusetts%";

update users set state = "MI" where state like "%Michigan%";

update users set state = "MN" where state like "%Minnesota%";

update users set state = "MS" where state like "%Mississippi%";

update users set state = "MO" where state like "%Missouri%";

update users set state = "MT" where state like "%Montana%";

update users set state = "NE" where state like "%Nebraska%";

update users set state = "NV" where state like "%Nevada%";

update users set state = "NH" where state like "%New Hampshire%";

update users set state = "NJ" where state like "%New Jersey%";

update users set state = "NY" where state like "%New Mexico%";

update users set state = "NY" where state like "%New York%";

update users set state = "NC" where state like "%North Carolina%";

update users set state = "ND" where state like "%North Dakota%";

update users set state = "OH" where state like "%Ohio%";

update users set state = "OK" where state like "%Oklahoma%";

update users set state = "OR" where state like "%Oregon%";

update users set state = "PA" where state like "%Pennsylvania%";

update users set state = "RI" where state like "%Rhode Island%";

update users set state = "SC" where state like "%South Carolina%";

update users set state = "SD" where state like "%South Dakota%";

update users set state = "TN" where state like "%Tennessee%";

update users set state = "TX" where state like "%Texas%";

update users set state = "UT" where state like "%Utah%";

update users set state = "VT" where state like "%Vermont%";

update users set state = "VA" where state like "%Virginia%";

update users set state = "WA" where state like "%Washington%";

update users set state = "WV" where state like "%West Virginia%";

update users set state = "WI" where state like "%Wisconsin%";

update users set state = "WY" where state like "%Wyoming%";

update users set state = "PR" where state like "%Puerto Rico%";

SET SQL_SAFE_UPDATES = 1;

ALTER TABLE `tweet` ADD FOREIGN KEY (`posting_user`) REFERENCES users(`screen_name`) ON DELETE CASCADE;

