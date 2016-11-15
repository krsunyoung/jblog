--sequence

drop SEQUENCE users_seq;

create SEQUENCE users_seq
start with 1
increment by 1
maxvalue 999999999;

drop SEQUENCE category_seq;

create SEQUENCE category_seq
start with 1
increment by 1
maxvalue 999999999;

drop SEQUENCE post_seq;

create SEQUENCE post_seq
start with 1
increment by 1
maxvalue 999999999;

drop SEQUENCE comments_seq;

create SEQUENCE comments_seq
start with 1
increment by 1
maxvalue 999999999;
