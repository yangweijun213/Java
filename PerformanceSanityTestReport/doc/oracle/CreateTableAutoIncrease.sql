CREATE TABLE NEWS
(
  NEWSID       NUMBER(38),
  NEWSTITLE    VARCHAR2(50 BYTE) NOT NULL,
  NEWSCONTENT  VARCHAR2(500 BYTE),
  NEWSSTATUS  VARCHAR2(50 BYTE),
  NEWSTYPE     VARCHAR2(50 BYTE),
  CREATETIME   DATE
);
ALTER TABLE NEWS ADD CONSTRAINT NEWS_PK PRIMARY KEY ( NEWSID );

CREATE SEQUENCE sequence_news
    increment by 1    -- 每次递增1
    start with 1       -- 从1开始
    nomaxvalue      -- 没有最大值
    minvalue 1       -- 最小值=1
    NOCYCLE;      -- 不循环


CREATE OR REPLACE TRIGGER trigger_news
    BEFORE INSERT ON NEWS
    FOR EACH ROW
    BEGIN
      SELECT sequence_news.nextval INTO :new.NEWSID FROM dual;
    END;
