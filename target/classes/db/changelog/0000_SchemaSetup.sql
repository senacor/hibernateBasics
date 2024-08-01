
CREATE SCHEMA hibernate_basics;

--- one to one
CREATE TABLE IF NOT EXISTS hibernate_basics.book
(
    id                                 text NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS hibernate_basics.review
(
    id                                 text NOT NULL,
    book_id                            text not null,
    CONSTRAINT review_pkey PRIMARY KEY (id),
    CONSTRAINT fk_book FOREIGN KEY (book_id)
    REFERENCES hibernate_basics.book (id)
);

--- one to one MapsId
CREATE TABLE IF NOT EXISTS hibernate_basics.cbook
(
    id SERIAL PRIMARY KEY
);


CREATE TABLE hibernate_basics.creview (
    id BIGINT PRIMARY KEY,
    CONSTRAINT fk_c_book FOREIGN KEY (id) REFERENCES hibernate_basics.cbook (id) ON DELETE CASCADE
);

--- blog without entity graph
CREATE TABLE IF NOT EXISTS hibernate_basics.user
(
    id SERIAL PRIMARY KEY,
    email varchar(255)
);

CREATE TABLE IF NOT EXISTS hibernate_basics.post
(
    id SERIAL PRIMARY KEY,
    user_id integer not null,
    CONSTRAINT fk_post_user FOREIGN KEY (user_id) REFERENCES hibernate_basics.user (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS hibernate_basics.comment
(
    id SERIAL PRIMARY KEY,
    post_id integer not null,
    user_id integer not null,
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES hibernate_basics.user (id) ON DELETE CASCADE,
    CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES hibernate_basics.user (id) ON DELETE CASCADE
);

INSERT INTO hibernate_basics.user (ID,EMAIL) VALUES (1,'user1@test.com');
INSERT INTO hibernate_basics.user (ID,EMAIL) VALUES (2,'user2@test.com');
INSERT INTO hibernate_basics.user (ID,EMAIL) VALUES (3,'user3@test.com');
INSERT INTO hibernate_basics.post (ID,USER_ID) VALUES (1,1);
INSERT INTO hibernate_basics.comment (ID,POST_ID,USER_ID) VALUES (1,1,2);
INSERT INTO hibernate_basics.comment (ID,POST_ID,USER_ID) VALUES (2,1,3);

--- blog with entity graph
CREATE TABLE IF NOT EXISTS hibernate_basics.usereg
(
    id SERIAL PRIMARY KEY,
    email varchar(255)
    );

CREATE TABLE IF NOT EXISTS hibernate_basics.posteg
(
    id SERIAL PRIMARY KEY,
    user_id integer not null,
    CONSTRAINT fk_egpost_user FOREIGN KEY (user_id) REFERENCES hibernate_basics.usereg (id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS hibernate_basics.commenteg
(
    id SERIAL PRIMARY KEY,
    post_id integer not null,
    user_id integer not null,
    CONSTRAINT fk_egcomment_user FOREIGN KEY (user_id) REFERENCES hibernate_basics.usereg (id) ON DELETE CASCADE,
    CONSTRAINT fk_egcomment_post FOREIGN KEY (post_id) REFERENCES hibernate_basics.posteg (id) ON DELETE CASCADE
    );

INSERT INTO hibernate_basics.usereg (ID,EMAIL) VALUES (1,'user1@test.com');
INSERT INTO hibernate_basics.usereg (ID,EMAIL) VALUES (2,'user2@test.com');
INSERT INTO hibernate_basics.usereg (ID,EMAIL) VALUES (3,'user3@test.com');
INSERT INTO hibernate_basics.posteg (ID,USER_ID) VALUES (1,1);
INSERT INTO hibernate_basics.commenteg (ID,POST_ID,USER_ID) VALUES (1,1,2);
INSERT INTO hibernate_basics.commenteg (ID,POST_ID,USER_ID) VALUES (2,1,3);