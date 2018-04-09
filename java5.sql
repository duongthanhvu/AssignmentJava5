-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2018 at 10:02 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java5`
--
CREATE DATABASE IF NOT EXISTS `java5` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `java5`;

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `ctdh_id` int(11) NOT NULL,
  `donhang_id` int(11) NOT NULL,
  `sanpham_id` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` decimal(10,0) NOT NULL,
  `chietkhau` int(11) NOT NULL,
  `tonggia` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `donhang_id` int(11) NOT NULL,
  `khachhang_id` int(11) NOT NULL,
  `ngaytao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ngaythanhtoan` datetime DEFAULT NULL,
  `trangthai` set('dathanhtoan','chuathanhtoan','dahuy') COLLATE utf8_unicode_ci NOT NULL,
  `phivanchuyen` decimal(10,0) NOT NULL,
  `tonggia` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `giatrithuoctinh`
--

CREATE TABLE `giatrithuoctinh` (
  `gttt_id` int(11) NOT NULL,
  `thuoctinh_id` int(11) NOT NULL,
  `giatri` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `giatrithuoctinh`
--

INSERT INTO `giatrithuoctinh` (`gttt_id`, `thuoctinh_id`, `giatri`) VALUES
(1, 1, 'M'),
(2, 1, 'L'),
(3, 2, 'Xanh'),
(4, 2, 'Đen');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `khachhang_id` int(11) NOT NULL,
  `ten` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tinhthanhpho` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `quanhuyen` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phuongxa` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `sodienthoai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ngaytao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `trangthai` bit(1) NOT NULL,
  `taikhoan_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`khachhang_id`, `ten`, `diachi`, `tinhthanhpho`, `quanhuyen`, `phuongxa`, `sodienthoai`, `ngaytao`, `trangthai`, `taikhoan_id`) VALUES
(1, 'Dương Nam', '43 sfdsdfs', 'adsfasdf', 'adsfasdfa', 'adsfsdf', '0981234234', '2018-03-04 23:43:45', b'1', 5),
(2, '', '', '', '', '', '', '2018-03-04 23:58:26', b'1', 12),
(3, 'Nguyễn Nguyễn', 'sdfasdfsadf', 'dak lak', 'bmt', 'tân thành', '0985990144', '2018-03-05 13:34:17', b'1', 15),
(4, 'sdfsdfs', '32', 'sdfsdf', 'ádfasfafas', 'adfsdfadsf', '0981234234', '2018-03-08 14:21:27', b'1', 16);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `sanpham_id` int(11) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` decimal(10,0) NOT NULL,
  `chietkhau` int(11) NOT NULL,
  `anh` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` bit(1) NOT NULL,
  `url` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`sanpham_id`, `ten`, `mota`, `soluong`, `gia`, `chietkhau`, `anh`, `trangthai`, `url`) VALUES
(1, 'Giày da P3232', 'Giày lười chất lượng, giá tốt dành cho nam', 21, '220000', 5, 'product_5.png', b'1', 'giay-luoi-gia-tot-cho-nam'),
(2, 'Áo thun tay dài', 'adfksahdfsifdiljdsfiljdfjfsdljsfd', 33, '12000', 12, '', b'0', 'fefeefeef'),
(3, 'Áo khoác', 'áo khoác nam nữ', 2, '800000', 12, 'product_1.png', b'1', 'ao-khoac'),
(4, 'Áo thun sì tai', 'áo thun chất vl', 23, '80000', 0, 'banner_1.jpg', b'0', 'dia-chi-cua-san-pham');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `taikhoan_id` int(11) NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ngaytao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `quyen` set('admin','khachhang','nhanvien') COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` set('chuakichhoat','dakichhoat','dakhoa') COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`taikhoan_id`, `username`, `password`, `email`, `ngaytao`, `quyen`, `trangthai`) VALUES
(1, 'adfasdf', '123456', 'happy@gmail.com', '2018-03-04 23:24:16', 'khachhang', 'dakichhoat'),
(5, 'admin', '123456', 'happygggg@gmail.com', '2018-03-04 23:43:45', 'admin', 'dakichhoat'),
(12, '', '', '', '2018-03-04 23:58:26', 'khachhang', 'dakichhoat'),
(15, 'test', '123456', 'fasdfasd@fsdfsdf.com', '2018-03-05 13:34:17', 'khachhang', 'dakichhoat'),
(16, '123456', 'gggggg', 'vsfsd@radf', '2018-03-08 14:21:27', 'khachhang', 'dakichhoat');

-- --------------------------------------------------------

--
-- Table structure for table `thuoctinh`
--

CREATE TABLE `thuoctinh` (
  `thuoctinh_id` int(11) NOT NULL,
  `ten` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thuoctinh`
--

INSERT INTO `thuoctinh` (`thuoctinh_id`, `ten`) VALUES
(1, 'Kích thước'),
(2, 'Màu sắc');

-- --------------------------------------------------------

--
-- Table structure for table `thuoctinhsanpham`
--

CREATE TABLE `thuoctinhsanpham` (
  `ttsp_id` int(11) NOT NULL,
  `gttt_id` int(11) NOT NULL,
  `sanpham_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thuoctinhsanpham`
--

INSERT INTO `thuoctinhsanpham` (`ttsp_id`, `gttt_id`, `sanpham_id`) VALUES
(1, 1, 1),
(3, 4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`ctdh_id`),
  ADD KEY `donhang_id` (`donhang_id`),
  ADD KEY `sanpham_id` (`sanpham_id`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`donhang_id`),
  ADD KEY `khachhang_id` (`khachhang_id`);

--
-- Indexes for table `giatrithuoctinh`
--
ALTER TABLE `giatrithuoctinh`
  ADD PRIMARY KEY (`gttt_id`),
  ADD KEY `thuoctinh_id` (`thuoctinh_id`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`khachhang_id`),
  ADD KEY `taikhoan_id` (`taikhoan_id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`sanpham_id`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`taikhoan_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `thuoctinh`
--
ALTER TABLE `thuoctinh`
  ADD PRIMARY KEY (`thuoctinh_id`);

--
-- Indexes for table `thuoctinhsanpham`
--
ALTER TABLE `thuoctinhsanpham`
  ADD PRIMARY KEY (`ttsp_id`),
  ADD KEY `gttt_id` (`gttt_id`),
  ADD KEY `sanpham_id` (`sanpham_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `ctdh_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `donhang_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `giatrithuoctinh`
--
ALTER TABLE `giatrithuoctinh`
  MODIFY `gttt_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `khachhang_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `sanpham_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `taikhoan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `thuoctinh`
--
ALTER TABLE `thuoctinh`
  MODIFY `thuoctinh_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `thuoctinhsanpham`
--
ALTER TABLE `thuoctinhsanpham`
  MODIFY `ttsp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`donhang_id`) REFERENCES `donhang` (`donhang_id`),
  ADD CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`sanpham_id`) REFERENCES `sanpham` (`sanpham_id`);

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`khachhang_id`) REFERENCES `khachhang` (`khachhang_id`);

--
-- Constraints for table `giatrithuoctinh`
--
ALTER TABLE `giatrithuoctinh`
  ADD CONSTRAINT `giatrithuoctinh_ibfk_1` FOREIGN KEY (`thuoctinh_id`) REFERENCES `thuoctinh` (`thuoctinh_id`);

--
-- Constraints for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`taikhoan_id`) REFERENCES `taikhoan` (`taikhoan_id`);

--
-- Constraints for table `thuoctinhsanpham`
--
ALTER TABLE `thuoctinhsanpham`
  ADD CONSTRAINT `thuoctinhsanpham_ibfk_1` FOREIGN KEY (`gttt_id`) REFERENCES `giatrithuoctinh` (`gttt_id`),
  ADD CONSTRAINT `thuoctinhsanpham_ibfk_2` FOREIGN KEY (`sanpham_id`) REFERENCES `sanpham` (`sanpham_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
