-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16/06/2021 às 16:36
-- Versão do servidor: 10.4.14-MariaDB
-- Versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `soccershirt`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `administrador`
--

CREATE TABLE `administrador` (
  `Senha` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `contem`
--

CREATE TABLE `contem` (
  `idTime` int(11) NOT NULL,
  `idNoticia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `gerencia`
--

CREATE TABLE `gerencia` (
  `hora` time NOT NULL,
  `data` date NOT NULL,
  `idAdm` varchar(100) NOT NULL,
  `idNoticia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `liga`
--

CREATE TABLE `liga` (
  `id` int(11) NOT NULL,
  `simbolo` longblob NOT NULL,
  `paisOrigem` varchar(100) NOT NULL,
  `nome` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `marca`
--

CREATE TABLE `marca` (
  `id` int(11) NOT NULL,
  `nome` varchar(500) NOT NULL,
  `logo` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `noticia`
--

CREATE TABLE `noticia` (
  `id` int(11) NOT NULL,
  `texto` text NOT NULL,
  `subtitulo` text DEFAULT NULL,
  `titulo` text NOT NULL,
  `dataC` date NOT NULL,
  `horaC` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `participa`
--

CREATE TABLE `participa` (
  `idLiga` int(11) NOT NULL,
  `idTime` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `time`
--

CREATE TABLE `time` (
  `id` int(11) NOT NULL,
  `camiseta` longblob NOT NULL,
  `nome` varchar(500) NOT NULL,
  `silaba` varchar(10) NOT NULL,
  `idMarca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`username`);

--
-- Índices de tabela `contem`
--
ALTER TABLE `contem`
  ADD KEY `idNoticia` (`idNoticia`),
  ADD KEY `idTime` (`idTime`);

--
-- Índices de tabela `gerencia`
--
ALTER TABLE `gerencia`
  ADD PRIMARY KEY (`idAdm`,`idNoticia`),
  ADD KEY `idNoticia` (`idNoticia`);

--
-- Índices de tabela `liga`
--
ALTER TABLE `liga`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `participa`
--
ALTER TABLE `participa`
  ADD PRIMARY KEY (`idLiga`),
  ADD KEY `idTime` (`idTime`);

--
-- Índices de tabela `time`
--
ALTER TABLE `time`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idMarca` (`idMarca`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `liga`
--
ALTER TABLE `liga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `noticia`
--
ALTER TABLE `noticia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `time`
--
ALTER TABLE `time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `contem`
--
ALTER TABLE `contem`
  ADD CONSTRAINT `contem_ibfk_1` FOREIGN KEY (`idNoticia`) REFERENCES `noticia` (`id`),
  ADD CONSTRAINT `contem_ibfk_2` FOREIGN KEY (`idTime`) REFERENCES `time` (`id`);

--
-- Restrições para tabelas `gerencia`
--
ALTER TABLE `gerencia`
  ADD CONSTRAINT `gerencia_ibfk_1` FOREIGN KEY (`idNoticia`) REFERENCES `noticia` (`id`),
  ADD CONSTRAINT `gerencia_ibfk_2` FOREIGN KEY (`idAdm`) REFERENCES `administrador` (`username`);

--
-- Restrições para tabelas `participa`
--
ALTER TABLE `participa`
  ADD CONSTRAINT `participa_ibfk_1` FOREIGN KEY (`idLiga`) REFERENCES `liga` (`id`),
  ADD CONSTRAINT `participa_ibfk_2` FOREIGN KEY (`idTime`) REFERENCES `time` (`id`);

--
-- Restrições para tabelas `time`
--
ALTER TABLE `time`
  ADD CONSTRAINT `time_ibfk_1` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
