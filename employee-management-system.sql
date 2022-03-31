SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE ems;

USE ems;

CREATE TABLE `employee` (
  `name` varchar(25) DEFAULT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `education` varchar(15) DEFAULT NULL,
  `post` varchar(15) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL,
  `emp_id` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `employee` (`name`, `fname`, `age`, `dob`, `address`, `phone`, `email`, `education`, `post`, `aadhar`, `emp_id`) VALUES
('lakshman', 'rajeshwar', '20', '2000/03/21', 'hyderabad', '9648115458', 'lakshman@gamil.com', 'graguate', 'student', '4548564158', '1000'),
('ram', 'shyam', '50', '1970/08/08', 'hyderabad', '8788547238', 'ram@mail.com', 'college', 'student', '5452151', '1001');


CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin');
COMMIT;

