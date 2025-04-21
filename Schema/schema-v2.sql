CREATE TABLE `User`(
    `user_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `phone_number` VARCHAR(15) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `birthday` DATE NULL,
    `job` VARCHAR(50) NULL,
    `credit_limit` DECIMAL(10, 2) NULL DEFAULT '0',
    `interests` TEXT NULL,
    `is_admin` TINYINT(1) NOT NULL
);
ALTER TABLE
    `User` ADD INDEX `user_email_index`(`email`);
ALTER TABLE
    `User` ADD UNIQUE `user_email_unique`(`email`);
CREATE TABLE `UserAddress`(
    `address_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NULL,
    `state` ENUM(
        'Alexandria',
        'Aswan',
        'Asyut',
        'Beheira',
        'Beni Suef',
        'Cairo',
        'Dakahlia',
        'Damietta',
        'Fayoum',
        'Gharbia',
        'Giza',
        'Ismailia',
        'Kafr El-Sheikh',
        'Luxor',
        'Matrouh',
        'Minya',
        'Monufia',
        'New Valley',
        'North Sinai',
        'Port Said',
        'Qalyubia',
        'Qena',
        'Red Sea',
        'Sharqia',
        'Sohag',
        'South Sinai',
        'Suez'
    ) NOT NULL,
    `city` VARCHAR(255) NOT NULL,
    `street` TEXT NOT NULL,
    `department_number` BIGINT NULL
);
CREATE TABLE `Product`(
    `product_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `description` TEXT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    `quantity` INT NOT NULL,
    `photo` VARCHAR(255) NULL,
    `brand` VARCHAR(255) NOT NULL,
    `size` VARCHAR(255) NOT NULL,
    `gender` ENUM('Men', 'Women', 'Unisex') NOT NULL DEFAULT 'Unisex'
);
CREATE TABLE `ShoppingCart`(
    `user_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    `added_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP(), PRIMARY KEY(`user_id`));
ALTER TABLE
    `ShoppingCart` ADD PRIMARY KEY(`product_id`);
CREATE TABLE `Order`(
    `order_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `total_amount` DECIMAL(10, 2) NULL DEFAULT '0',
    `order_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP(), `address_id` INT NOT NULL);
CREATE TABLE `OrderItems`(
    `order_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY(`order_id`)
);
ALTER TABLE
    `OrderItems` ADD PRIMARY KEY(`product_id`);
ALTER TABLE
    `Product` ADD CONSTRAINT `product_product_id_foreign` FOREIGN KEY(`product_id`) REFERENCES `OrderItems`(`product_id`);
ALTER TABLE
    `Order` ADD CONSTRAINT `order_address_id_foreign` FOREIGN KEY(`address_id`) REFERENCES `UserAddress`(`address_id`);
ALTER TABLE
    `UserAddress` ADD CONSTRAINT `useraddress_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`);
ALTER TABLE
    `Order` ADD CONSTRAINT `order_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`);
ALTER TABLE
    `Order` ADD CONSTRAINT `order_order_id_foreign` FOREIGN KEY(`order_id`) REFERENCES `OrderItems`(`order_id`);
ALTER TABLE
    `Product` ADD CONSTRAINT `product_product_id_foreign` FOREIGN KEY(`product_id`) REFERENCES `ShoppingCart`(`product_id`);
ALTER TABLE
    `User` ADD CONSTRAINT `user_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `ShoppingCart`(`user_id`);