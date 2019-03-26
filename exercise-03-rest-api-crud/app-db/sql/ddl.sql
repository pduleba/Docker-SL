CREATE TABLE IF NOT EXISTS players (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login    VARCHAR(25),
  password VARCHAR(25),
  level    VARCHAR(15),
  score    INT,
  email    VARCHAR(50)
) ENGINE=InnoDB;