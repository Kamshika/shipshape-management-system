-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2024 at 06:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shipshape`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` text DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `name`, `address`, `mobile`, `email`) VALUES
(1, 'Raymond', 'Colombo', '07773546346', 'test@gmail.com'),
(2, 'Victor', 'Mumbai', '+914534667454', 'victor@gmail.com'),
(3, 'Global Shipping Co.', '123 Maritime St, Los Angeles, CA, USA', '+1234567890', 'contact@globalshipping.com'),
(4, 'Atlantic Traders', '456 Ocean Blvd, Miami, FL, USA', '+1987654321', 'info@atlantictraders.com'),
(5, 'Pacific Shippers', '789 Harbor Rd, San Francisco, CA, USA', '+1123456789', 'support@pacificshippers.com'),
(6, 'Seaway Logistics', '321 Shipyard Ave, Houston, TX, USA', '+1098765432', 'services@seawaylogistics.com'),
(7, 'Marine Solutions', '654 Nautical Ln, Seattle, WA, USA', '+1987654322', 'sales@marinesolutions.com'),
(8, 'Ocean Freight Co.', '987 Deepwater Dr, New York, NY, USA', '+1456789234', 'contact@oceanfreight.com'),
(9, 'ShipMasters Inc.', '123 Dockside St, Norfolk, VA, USA', '+1765432987', 'info@shipmasters.com'),
(10, 'Blue Wave Shipping', '456 Pier Pl, San Diego, CA, USA', '+1654327890', 'support@bluewaveshipping.com'),
(11, 'Nautical Ventures', '789 Sailor Way, Boston, MA, USA', '+1345678921', 'services@nauticalventures.com'),
(12, 'Maritime Enterprises', '321 Anchor Dr, Charleston, SC, USA', '+1098765423', 'sales@maritimeenterprises.com');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `address` text DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `schedule` text DEFAULT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employee_id`, `title`, `first_name`, `last_name`, `username`, `address`, `mobile`, `email`, `password`, `schedule`, `role_id`) VALUES
(1, 'Mr.', 'John', 'Alfred', 'john', 'Sri Lanka', '0777123456', 'kamshika236@gmail.com', 'john', 'Mon-Fri 9-5', 4),
(2, 'Mr.', 'John', 'Doe', 'johndoe', '123 Maple Street', '123-456-7890', 'kamshika236@gmail.com', 'johndoe', 'Mon-Fri 9-5', 1),
(3, 'Ms.', 'Jane', 'Smith', 'janesmith', '456 Oak Avenue', '234-567-8901', 'kamshika236@gmail.com', 'password123', 'Mon-Fri 8-4', 2),
(4, 'Dr.', 'Jim', 'Beam', 'jimbeam', '789 Pine Road', '345-678-9012', 'kamshika236@gmail.com', 'password123', 'Tue-Sat 10-6', 3),
(5, 'Mrs.', 'Alice', 'Johnson', 'alicejohnson', '101 Birch Lane', '456-789-0123', 'kamshika236@gmail.com', 'password123', 'Mon-Fri 7-3', 4),
(6, 'Mr.', 'Bob', 'Brown', 'bob', '202 Cedar Boulevard', '567-890-1234', 'kamshika236@gmail.com', 'bob', 'Wed-Sun 12-8', 1),
(7, 'Miss', 'Clara', 'White', 'clarawhite', '303 Redwood Drive', '678-901-2345', 'clarawhite@example.com', 'password123', 'Mon-Fri 6-2', 1),
(8, 'Ms.', 'Diane', 'Green', 'dianegreen', '404 Elm Street', '789-012-3456', 'dianegreen@example.com', 'password123', 'Tue-Sat 8-4', 2),
(9, 'Dr.', 'Eve', 'Black', 'eveblack', '505 Fir Lane', '890-123-4567', 'eveblack@example.com', 'password123', 'Mon-Fri 9-5', 3),
(10, 'Mr.', 'Frank', 'Blue', 'frankblue', '606 Spruce Circle', '901-234-5678', 'frankblue@example.com', 'password123', 'Wed-Sun 1-9', 4),
(11, 'Mrs.', 'Grace', 'Yellow', 'graceyellow', '707 Hemlock Court', '012-345-6789', 'graceyellow@example.com', 'password123', 'Mon-Fri 10-6', 5),
(12, 'Dr.', 'Michael', 'Johnson', 'mjohnson', '789 Oak St', '9876543210', 'michael.johnson@example.com', 'password123', 'Wednesday-Sunday', 2);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL,
  `part_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inventory_id`, `part_id`, `quantity`, `location`) VALUES
(1, 1, 25, 'Warehoiuse'),
(2, 2, 20, 'Warehouse 2'),
(4, 3, 15, 'ware hoiuse2');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `job_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `job_description` text DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `assigned_date` date DEFAULT NULL,
  `job_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`job_id`, `order_id`, `employee_id`, `job_description`, `start_date`, `end_date`, `status`, `assigned_date`, `job_type_id`) VALUES
(1, 1, 2, 'Repair Service', '2024-06-10', '2024-06-11', 'Job Started', '2024-06-27', 1),
(2, 1, 1, 'Repaint Service', NULL, NULL, 'Job Started', '2024-06-27', 2),
(3, 2, 5, 'Repair Service', NULL, NULL, 'Job Created', '2024-06-28', 1),
(4, 2, 6, 'Repaint Service', NULL, NULL, 'Job Assigned', '2024-06-28', 2),
(5, 3, 3, 'Repair Service', NULL, NULL, 'Job Assigned', '2024-06-28', 1),
(6, 3, 6, 'Repaint Service', NULL, NULL, 'Job Assigned', '2024-06-28', 2);

-- --------------------------------------------------------

--
-- Table structure for table `jobtype`
--

CREATE TABLE `jobtype` (
  `job_type_id` int(11) NOT NULL,
  `type_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jobtype`
--

INSERT INTO `jobtype` (`job_type_id`, `type_name`) VALUES
(1, 'Repair'),
(2, 'Repaint');

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `notification_id` int(11) NOT NULL,
  `part_id` int(11) DEFAULT NULL,
  `min_quantity` int(11) DEFAULT NULL,
  `notify` tinyint(1) DEFAULT NULL,
  `part_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `is_repair` tinyint(1) DEFAULT NULL,
  `repair_service_fee` decimal(10,2) DEFAULT NULL,
  `is_repaint` tinyint(1) DEFAULT NULL,
  `repaint_service_fee` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `customer_id`, `order_date`, `status`, `total_price`, `is_repair`, `repair_service_fee`, `is_repaint`, `repaint_service_fee`) VALUES
(1, 6, '2024-06-27', NULL, 1000000.00, 1, 0.00, 1, 0.00),
(2, 1, '2024-06-28', NULL, 2775000.00, 1, 10000.00, 1, 15000.00),
(3, 2, '2024-06-28', NULL, 4500000.00, 1, 0.00, 1, 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `ordertype`
--

CREATE TABLE `ordertype` (
  `order_type_id` int(11) NOT NULL,
  `type_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ordertype`
--

INSERT INTO `ordertype` (`order_type_id`, `type_name`) VALUES
(1, 'Purchase'),
(2, 'Repair'),
(3, 'Repaint');

-- --------------------------------------------------------

--
-- Table structure for table `order_part`
--

CREATE TABLE `order_part` (
  `order_part_id` int(11) NOT NULL,
  `sales_date` date DEFAULT NULL,
  `part_id` int(11) DEFAULT NULL,
  `part_description` text DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `order_type_id` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_part`
--

INSERT INTO `order_part` (`order_part_id`, `sales_date`, `part_id`, `part_description`, `supplier_id`, `quantity`, `order_type_id`, `price`, `order_id`) VALUES
(1, '2024-06-27', 1, 'Paint', 1, 20, 1, 1000000.00, 1),
(2, '2024-06-28', 1, 'Paint', 1, 10, 2, 500000.00, 2),
(3, '2024-06-28', 2, 'Erosion Resistant Coating', 2, 15, 3, 2250000.00, 2),
(4, '2024-06-28', 1, 'Paint', 1, 45, 2, 2250000.00, 3),
(5, '2024-06-28', 2, 'Erosion Resistant Coating', 2, 15, 3, 2250000.00, 3);

-- --------------------------------------------------------

--
-- Table structure for table `parts`
--

CREATE TABLE `parts` (
  `part_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parts`
--

INSERT INTO `parts` (`part_id`, `name`, `description`, `price`, `supplier_id`) VALUES
(1, 'Paint', '100L', 50000.00, 1),
(2, 'Erosion Resistant Coating', '200L', 150000.00, 2),
(3, 'Life Jackets', 'Set of 20 adult life jackets', 3000.00, 5),
(4, 'Propeller', 'Bronze propeller, 1.5m diameter', 25000.00, 6),
(5, 'Marine Engine', 'Diesel engine, 2000 HP', 300000.00, 7),
(6, 'Ship Radar', 'High-precision marine radar', 40000.00, 8),
(7, 'Fuel Tank', '10000L capacity, stainless steel', 60000.00, 9),
(8, 'Emergency Raft', 'Inflatable emergency raft, 12 person', 15000.00, 10),
(9, 'Anchor Chain', 'High-strength steel chain, 100m', 12000.00, 3),
(10, 'Navigation System', 'Advanced marine GPS and radar', 75000.00, 4);

-- --------------------------------------------------------

--
-- Table structure for table `properties`
--

CREATE TABLE `properties` (
  `property_key` varchar(50) NOT NULL,
  `value` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `properties`
--

INSERT INTO `properties` (`property_key`, `value`, `type`) VALUES
('mail.debug', 'true', 'email'),
('mail.smtp.auth', 'true', 'email'),
('mail.smtp.host', 'smtp.gmail.com', 'email'),
('mail.smtp.port', '587', 'email'),
('mail.smtp.starttls.enable', 'true', 'email'),
('mail.transport.protocol', 'smtp', 'email'),
('password', 'uhwkzenjrjiyjcdo', 'email'),
('username', 'kamshika236@gmail.com', 'email');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'CLERK'),
(3, 'MANAGER'),
(4, 'OFFICER'),
(5, 'TECHNICIAN');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `supplier_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `contact_name` varchar(100) DEFAULT NULL,
  `contact_email` varchar(100) DEFAULT NULL,
  `contact_phone` varchar(20) DEFAULT NULL,
  `address` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`supplier_id`, `name`, `contact_name`, `contact_email`, `contact_phone`, `address`) VALUES
(1, 'HD Hyundai Marine', 'Akira', 'test@gmail.com', '+8382887299898', 'Japan'),
(2, 'SEA LINK MARINE', 'Mr Vishal Guptha', 'guptha@sealink.com', '+91688778773', 'Mumbai'),
(3, 'Oceanic Components', 'Lisa Miller', 'lisa@oceanic.com', '+12456789900', 'California, USA'),
(4, 'Maritime Parts Co.', 'Anna De Silva', 'john@maritimeparts.com', '+447123456789', 'London, UK'),
(5, 'Poseidon Supplies', 'Maria Sanchez', 'maria@poseidonsupplies.com', '+34912345678', 'Madrid, Spain'),
(6, 'Neptune Marine Supply', 'Hans Müller', 'hans@neptunemarine.de', '+491234567890', 'Hamburg, Germany'),
(7, 'Titanic Parts', 'Anna Ivanova', 'anna@titanicparts.ru', '+74951234567', 'Moscow, Russia'),
(8, 'Pacific Ship Parts', 'Chen Wei', 'chen@pacificshipparts.cn', '+8612345678901', 'Shanghai, China'),
(9, 'Atlantic Marine', 'Robert Johnson', 'robert@atlanticmarine.com', '+19876543210', 'New York, USA'),
(10, 'Arctic Marine Supplies', 'Kari Nieminen', 'kari@arcticmarinesupplies.fi', '+3581234567', 'Helsinki, Finland'),
(11, 'd', 'asd', 'as@gmail.com', '784566666', '11qwr road colombo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventory_id`),
  ADD UNIQUE KEY `unique_part_id` (`part_id`),
  ADD KEY `part_id` (`part_id`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`job_id`),
  ADD UNIQUE KEY `unique_order_jobtype` (`order_id`,`job_type_id`),
  ADD KEY `employee_id` (`employee_id`),
  ADD KEY `job_type_id` (`job_type_id`);

--
-- Indexes for table `jobtype`
--
ALTER TABLE `jobtype`
  ADD PRIMARY KEY (`job_type_id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`notification_id`),
  ADD UNIQUE KEY `unique_part_id` (`part_id`),
  ADD KEY `part_id` (`part_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `ordertype`
--
ALTER TABLE `ordertype`
  ADD PRIMARY KEY (`order_type_id`);

--
-- Indexes for table `order_part`
--
ALTER TABLE `order_part`
  ADD PRIMARY KEY (`order_part_id`),
  ADD UNIQUE KEY `unique_order_part` (`order_id`,`part_id`),
  ADD KEY `sales_fk_order_type_id` (`order_type_id`),
  ADD KEY `sales_fk_product_id` (`part_id`),
  ADD KEY `sales_fk_supplier_id` (`supplier_id`);

--
-- Indexes for table `parts`
--
ALTER TABLE `parts`
  ADD PRIMARY KEY (`part_id`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- Indexes for table `properties`
--
ALTER TABLE `properties`
  ADD PRIMARY KEY (`property_key`),
  ADD UNIQUE KEY `unique_property_key_type` (`property_key`,`type`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`),
  ADD UNIQUE KEY `role_name` (`role_name`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`supplier_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inventory_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `job_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `jobtype`
--
ALTER TABLE `jobtype`
  MODIFY `job_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `notification_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ordertype`
--
ALTER TABLE `ordertype`
  MODIFY `order_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order_part`
--
ALTER TABLE `order_part`
  MODIFY `order_part_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `parts`
--
ALTER TABLE `parts`
  MODIFY `part_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`);

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`part_id`) REFERENCES `parts` (`part_id`);

--
-- Constraints for table `jobs`
--
ALTER TABLE `jobs`
  ADD CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `jobs_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`),
  ADD CONSTRAINT `jobs_ibfk_3` FOREIGN KEY (`job_type_id`) REFERENCES `jobtype` (`job_type_id`);

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`part_id`) REFERENCES `parts` (`part_id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

--
-- Constraints for table `order_part`
--
ALTER TABLE `order_part`
  ADD CONSTRAINT `sales_fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `sales_fk_order_type_id` FOREIGN KEY (`order_type_id`) REFERENCES `ordertype` (`order_type_id`),
  ADD CONSTRAINT `sales_fk_product_id` FOREIGN KEY (`part_id`) REFERENCES `parts` (`part_id`),
  ADD CONSTRAINT `sales_fk_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`);

--
-- Constraints for table `parts`
--
ALTER TABLE `parts`
  ADD CONSTRAINT `parts_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
