/* ユーザマスタのデータ（管理者権限） */
INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('kento75@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', 'タカノケント', '1993-07-05', 25, false, 'ROLE_ADMIN');

/* ユーザマスタのデータ（一般権限） */
INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('test@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', 'テストタロウ', '1995-04-02', 23, false, 'ROLE_GENERAL');


/* 顧客マスタ */
INSERT INTO customer (customer_id, customer_name, address, updated_at)
VALUES(1, '有限会社A', '世田谷区...', '2012-04-01 12:34:56');
INSERT INTO customer (customer_id, customer_name, address, updated_at)
VALUES(2, 'B社', '千葉市...', '2012-07-01 12:34:56');
INSERT INTO customer (customer_id, customer_name, address, updated_at)
VALUES(3, 'C社', '名古屋市...', '2015-05-01 12:34:56');


/* 売上テーブル */
INSERT INTO sales (sales_id, customer_id, sales_date, sales_amount)
VALUES(1, 1, '2014-03-15', 5000000);
VALUES(2, 1, '2014-04-15', 3000000);
VALUES(3, 1, '2014-06-15', 250000);
VALUES(4, 1, '2014-07-15', 5000000);
VALUES(5, 2, '2014-09-15', 3000000);
VALUES(6, 3, '2015-06-15', 250000);
VALUES(7, 2, '2015-03-15', 700000);
VALUES(8, 2, '2016-04-15', 130000);
VALUES(9, 3, '2016-06-15', 1250000);
