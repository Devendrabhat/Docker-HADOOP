-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 31, 2017 at 03:04 AM
-- Server version: 5.7.18-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resume`
--

-- --------------------------------------------------------

--
-- Table structure for table `hreg`
--

CREATE TABLE `hreg` (
  `hid` int(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mn` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `add` varchar(50) DEFAULT NULL,
  `uname` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `cname` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hreg`
--

INSERT INTO `hreg` (`hid`, `name`, `email`, `mn`, `nationality`, `add`, `uname`, `pass`, `cname`) VALUES
(1, 'devendra', 'devendra.bhat2@gmail.com', '9158662495', 'Indian', 'hjksdbm', 'dev', 'dev', 'mmit');

-- --------------------------------------------------------

--
-- Table structure for table `reg`
--

CREATE TABLE `reg` (
  `uid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mn` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `add` varchar(50) DEFAULT NULL,
  `uname` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `resume` varchar(50) DEFAULT NULL,
  `from` varchar(50) DEFAULT NULL,
  `date_upload` varchar(50) DEFAULT NULL,
  `flag` varchar(50) DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg`
--

INSERT INTO `reg` (`uid`, `name`, `email`, `mn`, `nationality`, `add`, `uname`, `pass`, `resume`, `from`, `date_upload`, `flag`) VALUES
(13, 'dev', 'em@jdkf', '993489783', 'dfhdjk', 'dfkjdksvnkd', 'dev', '1234', 'nilesh.txt', 'shine', '18-Apr-2017', '0'),
(1, 'sandesh', 'sandesh.srccode@gmail.com', '9087654321', 'i', 'lll', 'sandesh', 'sandesh', 'a.txt', 'shine', '19-Apr-2018', '0'),
(2, 'Devendra', 'dev@gmail.com', '9876543210', 'india', 'kjdfkldsjfklds', 'dev', '9158662495', 'interm1.txt', 'naukri', '20-Apr-2017', '0'),
(3, 'unne', 'devendra.bhat2@gmail.com', '0987654321', 'Indian', 'jdfksdjlf', 'unne', 'root', 'akash 1.txt', 'monster', '13-Apr-2012', '1'),
(4, 'julie', 'julie.jeswani8805@gmail.com', '9503417580', 'Indian', 'hdssaw', 'abcd', 'abcd', 'akash.txt', 'indeed', '22-Apr-2017', '2'),
(5, 'ambika', 'julie.jeswani8805@gmail.com', '9875432255', 'Indian', 'svhjvj', 'efgh', 'efgh', 'ambika.txt', 'shine', '21-Apr-2016', '2'),
(6, 'amit', 'julie.jeswani8805@gmail.com', '4548459264', 'indian', 'dfgrf', 'hhhhhh', 'hhhhh', 'amit.txt', 'shine', '10-Apr-2014', '0'),
(7, 'b', 'devendra.bhat@mmit.edu.in', '9876543210', 'nationalitym,', 'addressknkl', 'uname', 'uname', 'b.txt', 'shine', '01-Apr-2009', '0'),
(8, 'hello', 'devendra.bhat@mmit.edu.in', '9876543210', 'dkfklsdkjl', 'kdnfkjdnvklds', 'kkkkkk', 'kkkkkk', 'nilesh.txt', 'indeed', '01-Apr-2010', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hreg`
--
ALTER TABLE `hreg`
  ADD PRIMARY KEY (`hid`);

--
-- Indexes for table `reg`
--
ALTER TABLE `reg`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hreg`
--
ALTER TABLE `hreg`
  MODIFY `hid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `reg`
--
ALTER TABLE `reg`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
