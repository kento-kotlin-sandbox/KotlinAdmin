/* ユーザマスタのデータ（管理者権限） */
INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('kento75@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', 'タカノケント', '1993-07-05', 25, false, 'ROLE_ADMIN');

/* ユーザマスタのデータ（一般権限） */
INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('test@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', 'テストタロウ', '1995-04-02', 23, false, 'ROLE_GENERAL');
