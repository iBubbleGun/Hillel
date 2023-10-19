CREATE TABLE homework
(
    id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE lesson
(
    id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    updatedAt   TIMESTAMP,
    homework_id INT          NOT NULL,
    FOREIGN KEY (homework_id) REFERENCES homework (id)
);

CREATE TABLE schedule
(
    id        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    updatedAt TIMESTAMP
);

CREATE TABLE schedule_lesson
(
    schedule_id INT NOT NULL,
    lesson_id   INT NOT NULL,
    FOREIGN KEY (schedule_id) REFERENCES schedule (id),
    FOREIGN KEY (lesson_id) REFERENCES lesson (id),
    PRIMARY KEY (schedule_id, lesson_id)
);
