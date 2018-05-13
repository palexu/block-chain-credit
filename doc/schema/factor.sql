CREATE TABLE factor (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64)        DEFAULT NULL,
  `desc`      VARCHAR(256)       DEFAULT NULL,
  content     TEXT               DEFAULT NULL,
  script_id   BIGINT             DEFAULT NULL,
  gmt_created DATETIME           DEFAULT now(),
  gmt_updated DATETIME           DEFAULT now() ON UPDATE now()
);

CREATE TABLE template (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64)        DEFAULT NULL,
  biz_type    VARCHAR(64)        DEFAULT NULL,
  gmt_created DATETIME           DEFAULT now(),
  gmt_updated DATETIME           DEFAULT now() ON UPDATE now()
);

CREATE TABLE factor_template_relation (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  template_id BIGINT,
  factor_id   BIGINT,
  gmt_created DATETIME           DEFAULT now(),
  gmt_updated DATETIME           DEFAULT now() ON UPDATE now()
);

CREATE TABLE biztype (
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR(64)        DEFAULT NULL,
  code          VARCHAR(64)        DEFAULT NULL,
  `description` VARCHAR(1024)      DEFAULT NULL,
  gmt_created   DATETIME           DEFAULT now(),
  gmt_updated   DATETIME           DEFAULT now() ON UPDATE now()
);

CREATE TABLE provider_biztype_relation (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  pname       VARCHAR(64)        DEFAULT NULL,
  bname       VARCHAR(64)        DEFAULT NULL,
  template_id BIGINT             DEFAULT NULL,
  price       BIGINT             DEFAULT NULL,
  count       BIGINT             DEFAULT NULL,
  gmt_created DATETIME           DEFAULT now(),
  gmt_updated DATETIME           DEFAULT now() ON UPDATE now()
);

CREATE TABLE provider (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64)        DEFAULT NULL,
  description VARCHAR(1024)      DEFAULT NULL,
  address     VARCHAR(128)       DEFAULT NULL,
  gmt_created DATETIME           DEFAULT now(),
  gmt_updated DATETIME           DEFAULT now() ON UPDATE now()
);

CREATE TABLE mmall_user (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  username    VARCHAR(128)        DEFAULT NULL,
  password    VARCHAR(256)        DEFAULT NULL,
  email       VARCHAR(128)        DEFAULT NULL,
  phone       VARCHAR(18)         DEFAULT NULL,
  question    VARCHAR(128)        DEFAULT NULL,
  answer      VARCHAR(128)        DEFAULT NULL,
  role        INTEGER             DEFAULT NULL,
  create_time TIMESTAMP           DEFAULT now(),
  update_time TIMESTAMP           DEFAULT now() ON UPDATE now()
);