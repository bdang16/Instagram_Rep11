create database instagram_rep11;

CREATE TABLE Role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    gender ENUM('male', 'female', 'other') NOT NULL, 
    phone_number VARCHAR(20),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Role(id)
);


CREATE TABLE Post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    user_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Comment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(1000), 
    user_id INT,
    post_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (post_id) REFERENCES Post(id)
);

CREATE TABLE Likes ( 
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    post_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (post_id) REFERENCES Post(id)
);

CREATE TABLE Media(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    url VARCHAR(100),
    post_id INT,
    user_id INT,
    FOREIGN KEY (post_id) REFERENCES Post(id),
    FOREIGN KEY (user_id) REFERENCES User(id)
);

