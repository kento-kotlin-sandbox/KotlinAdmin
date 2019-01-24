/* ユーザマスタ */
CREATE TABLE IF NOT EXISTS m_user (
  user_id VARCHAR(50) PRIMARY KEY,
  password VARCHAR(100),
  user_name VARCHAR(50),
  birthday DATE,
  age INT,
  marriage BOOLEAN,
  role VARCHAR(50)
);


/* 顧客マスタ */
CREATE TABLE IF NOT EXISTS customer (
  customer_id   smallint
, customer_name varchar(256)    --会社名
, address       varchar(256)    --住所
, updated_at    timestamp       --更新日時
, delete_flg    boolean         --論理削除フラグ
);


/* 売上テーブル */
CREATE TABLE IF NOT EXISTS sales (
  sales_id      smallint
, customer_id   smallint
, sales_date    date        --売上日
, sales_amount  bigint      --売上額
);
