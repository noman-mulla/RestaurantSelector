-- phpMyAdmin SQL Dump
-- version 4.3.8
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 08, 2018 at 11:18 PM
-- Server version: 5.5.51-38.2
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mnomaan_restaurant_selector`
--

-- --------------------------------------------------------

--
-- Table structure for table `menuitem`
--

CREATE TABLE IF NOT EXISTS `menuitem` (
  `menu_item_id` int(11) NOT NULL,
  `item_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `menuitem`
--

INSERT INTO `menuitem` (`menu_item_id`, `item_name`) VALUES
(1, 'coffee');

-- --------------------------------------------------------

--
-- Table structure for table `menutype`
--

CREATE TABLE IF NOT EXISTS `menutype` (
  `menu_id` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `restaurant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menutype`
--

INSERT INTO `menutype` (`menu_id`, `type`, `restaurant_id`) VALUES
(0, 'breakfast', 2);

-- --------------------------------------------------------

--
-- Table structure for table `menu_menuitem`
--

CREATE TABLE IF NOT EXISTS `menu_menuitem` (
  `menu_id` int(11) DEFAULT NULL,
  `menu_item_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `menu_menuitem`
--

INSERT INTO `menu_menuitem` (`menu_id`, `menu_item_id`) VALUES
(0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE IF NOT EXISTS `restaurant` (
  `restaurant_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `rname` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`restaurant_id`, `address`, `rname`, `rating`) VALUES
(2, '730 South May Street', 'ML', 4),
(3, '730 South May Street', 'ML Kitchen', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menuitem`
--
ALTER TABLE `menuitem`
  ADD PRIMARY KEY (`menu_item_id`);

--
-- Indexes for table `menutype`
--
ALTER TABLE `menutype`
  ADD PRIMARY KEY (`menu_id`), ADD KEY `FK_kqs71m86lblxt4owpytjyyxcj` (`restaurant_id`);

--
-- Indexes for table `menu_menuitem`
--
ALTER TABLE `menu_menuitem`
  ADD KEY `FK_ao5g7m129wthd7mvr7oa12pg0` (`menu_item_id`), ADD KEY `FK_ogev027fdpg8nohiy25sc7ktu` (`menu_id`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`restaurant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menuitem`
--
ALTER TABLE `menuitem`
  MODIFY `menu_item_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `menutype`
--
ALTER TABLE `menutype`
ADD CONSTRAINT `FK_kqs71m86lblxt4owpytjyyxcj` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`);

--
-- Constraints for table `menu_menuitem`
--
ALTER TABLE `menu_menuitem`
ADD CONSTRAINT `FK_ogev027fdpg8nohiy25sc7ktu` FOREIGN KEY (`menu_id`) REFERENCES `menutype` (`menu_id`),
ADD CONSTRAINT `FK_ao5g7m129wthd7mvr7oa12pg0` FOREIGN KEY (`menu_item_id`) REFERENCES `menuitem` (`menu_item_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
