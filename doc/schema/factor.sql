CREATE TABLE factor (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64)        DEFAULT NULL,
  `desc`      VARCHAR(256)       DEFAULT NULL,
  script_id   BIGINT             DEFAULT NULL,
  gmt_created DATETIME           DEFAULT now(),
  gmt_updated DATETIME           DEFAULT now() ON UPDATE now()
);

CREATE TABLE script (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64)        DEFAULT NULL,
  content     TEXT               DEFAULT NULL,
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