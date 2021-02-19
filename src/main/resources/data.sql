CREATE TABLE IF NOT EXISTS `produto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NOT NULL,
  `price` DOUBLE NOT NULL,
  `score` INT(11) NOT NULL,
  `image` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));

CREATE TABLE IF NOT EXISTS `carrinho` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `quantity` INT(11) NOT NULL,
  `produto_id` INT(11) NOT NULL,
  `token` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `produto_token` (`produto_id` ASC, `token` ASC),
  CONSTRAINT `fk_carrinho_produto`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
INSERT INTO produto (id, name, price, score, image) VALUES (1, 'Super Mario Odyssey', 197.88, 100, 'super-mario-odyssey.png');
INSERT INTO produto (id, name, price, score, image) VALUES (2, 'Call Of Duty Infinite Warfare', 49.99, 80, 'call-of-duty-infinite-warfare.png');
INSERT INTO produto (id, name, price, score, image) VALUES (3, 'The Witcher III Wild Hunt', 119.5, 250, 'the-witcher-iii-wild-hunt.png');
INSERT INTO produto (id, name, price, score, image) VALUES (4, 'Call Of Duty WWII', 249.99, 205, 'call-of-duty-wwii.png');
INSERT INTO produto (id, name, price, score, image) VALUES (5, 'Mortal Kombat XL', 69.99, 150, 'mortal-kombat-xl.png');
INSERT INTO produto (id, name, price, score, image) VALUES (6, 'Shards of Darkness', 71.94, 400, 'shards-of-darkness.png');
INSERT INTO produto (id, name, price, score, image) VALUES (7, 'Terra Média: Sombras de Mordor', 79.99, 50, 'terra-media-sombras-de-mordor.png');
INSERT INTO produto (id, name, price, score, image) VALUES (8, 'FIFA 18', 195.39, 325, 'fifa-18.png');
INSERT INTO produto (id, name, price, score, image) VALUES (9, 'Horizon Zero Dawn', 115.8, 290, 'horizon-zero-dawn.png');