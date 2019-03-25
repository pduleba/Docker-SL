CREATE TABLE IF NOT EXISTS players (
  id       INT AUTO_INCREMENT NOT NULL,
  login    VARCHAR(25),
  password VARCHAR(25),
  rank     VARCHAR(15),
  score    INT,
  email    VARCHAR(50),
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;