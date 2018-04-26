CREATE TABLE factor (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64)  DEFAULT NULL,
  `desc`      VARCHAR(256) DEFAULT NULL,
  script_id   BIGINT       DEFAULT NULL,
  gmt_created DATETIME     DEFAULT now(),
  gmt_updated DATETIME     DEFAULT now() ON UPDATE now()
);

CREATE TABLE script (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64) DEFAULT NULL,
  content     TEXT        DEFAULT NULL,
  gmt_created DATETIME    DEFAULT now(),
  gmt_updated DATETIME    DEFAULT now() ON UPDATE now()
);

CREATE TABLE template (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64) DEFAULT NULL,
  gmt_created DATETIME    DEFAULT now(),
  gmt_updated DATETIME    DEFAULT now() ON UPDATE now()
);

CREATE TABLE factor_template_relation (
  id          BIGINT PRIMARY KEY AUTO_INCREMENT,
  template_id   BIGINT,
  factor_id   BIGINT,
  gmt_created DATETIME DEFAULT now(),
  gmt_updated DATETIME DEFAULT now() ON UPDATE now()
);