-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 18 fév. 2019 à 08:51
-- Version du serveur :  5.7.21
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `siobank`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `CodeClient` int(11) NOT NULL AUTO_INCREMENT,
  `NomClient` varchar(50) NOT NULL,
  `PrenomClient` varchar(50) NOT NULL,
  `AdresseClient` varchar(50) NOT NULL,
  `VilleClient` varchar(50) NOT NULL,
  `MailClient` varchar(50) NOT NULL,
  `TelClient` varchar(50) NOT NULL,
  `idVille` int(11) NOT NULL,
  PRIMARY KEY (`CodeClient`),
  KEY `idVille` (`idVille`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`CodeClient`, `NomClient`, `PrenomClient`, `AdresseClient`, `VilleClient`, `MailClient`, `TelClient`, `idVille`) VALUES
(1, 'Leuridan', 'Alexandre', '19 Avenue de Nailloux', 'Auterive', 'alexandre.leuridan@gmail.com', '0770351502', 0),
(2, 'Vanhooland', 'Gaëlle', '14 rue des inconnus', 'Montauban', 'gaelle@wanadoo.fr', '0770658293', 0),
(3, 'Deleplaire', 'Jérémy', '3 rue Alsace Lorraine', 'Toulouse', 'deleplaire.jeremy@yahoo.fr', '0658923465', 0),
(4, 'Leuridan', 'Catherine', '15 Rue Henri Dunant', 'Toulouse', 'cathery@live.fr', '0668244406', 0),
(5, 'Sevrin', 'Jules', '56 rue de Balma', 'Toulouse', 'sevrin.jules@gmail.com', '0656869452', 0),
(6, 'Leuridan', 'Aurore', '20 Place des Pradettes', 'Montauban', 'aurore.leuridan@gmail.com', '0685967419', 0),
(7, 'Febreau', 'Cécilia', '19 Avenue de Nailloux', 'Auterive', 'ceciliafebreau@hotmail.fr', '0654789123', 0),
(8, 'Sevrin', 'Guillaume', '19 rue de laude', 'Toulouse', 'sevrin.guillaume@live.fr', '0621478595', 0),
(9, 'Deleplaire', 'Herve', '87 Chemin de la dourdouille', 'Carbonne', 'd.herve@gmail.com', '0628586937', 0),
(10, 'Leuridan', 'Aymeric', '20 Route de Toulouse', 'Seysses', 'aymeric.leuridan@gmail.com', '0619284577', 0),
(11, 'Boussaid', 'Sara', 'Route de Muret', 'Seysses', 'sara.boussaid@gmail.com', '0659487612', 0),
(12, 'Leuridan', 'Aurore', '22 avenue des Pradettes', 'Toulouse', 'aurore.leuridan@laposte.net', '0645124512', 0),
(13, 'Point', 'Julien', '15 Impasse Napoléon', 'Carbonne', 'j.point@wanadoo.fr', '0678948521', 0),
(14, 'Moreau', 'Sylvain', '99 chemin rapeau', 'Toulouse', 'sylvain.m@gmail.com', '0788965423', 1),
(15, 'Darmani', 'Paul', '15 Rue Denier', 'Langon', 'darmani.paul@gmail.com', '0641524857', 4);

-- --------------------------------------------------------

--
-- Structure de la table `comptes`
--

DROP TABLE IF EXISTS `comptes`;
CREATE TABLE IF NOT EXISTS `comptes` (
  `NumeroCompte` int(11) NOT NULL AUTO_INCREMENT,
  `DateCreation` date NOT NULL,
  `SoldeCompte` double NOT NULL,
  `LimiteRetrait` int(11) NOT NULL,
  `CodeClient` int(11) NOT NULL,
  `idTypeCompte` int(11) NOT NULL,
  PRIMARY KEY (`NumeroCompte`),
  KEY `CodeClient` (`CodeClient`),
  KEY `idTypeCompte` (`idTypeCompte`)
) ENGINE=InnoDB AUTO_INCREMENT=1033 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptes`
--

INSERT INTO `comptes` (`NumeroCompte`, `DateCreation`, `SoldeCompte`, `LimiteRetrait`, `CodeClient`, `idTypeCompte`) VALUES
(1000, '2018-07-13', 1500, 300, 1, 1),
(1001, '2018-07-15', 967, 350, 1, 1),
(1002, '2018-03-01', 965, 150, 2, 1),
(1003, '2018-07-23', 2636, 100, 2, 1),
(1004, '2018-07-02', 1423.56, 300, 3, 1),
(1005, '2018-07-16', 23.97, 100, 3, 1),
(1006, '2018-07-15', 4390, 500, 1, 2),
(1022, '2018-08-10', 2300, 400, 2, 2),
(1023, '2018-07-23', 1244, 250, 3, 2),
(1024, '2018-07-02', 1423.56, 300, 3, 3),
(1025, '2018-07-02', 1423.56, 300, 3, 3),
(1026, '2018-07-18', 1100, 350, 1, 3),
(1027, '2018-07-15', 1300, 400, 1, 1),
(1030, '2018-07-20', 800, 300, 2, 1),
(1031, '2018-03-01', 769.3, 300, 2, 1),
(1032, '2018-07-23', 1480, 100, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `modepaiement`
--

DROP TABLE IF EXISTS `modepaiement`;
CREATE TABLE IF NOT EXISTS `modepaiement` (
  `idMode` int(11) NOT NULL AUTO_INCREMENT,
  `mode` varchar(15) NOT NULL,
  PRIMARY KEY (`idMode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `modepaiement`
--

INSERT INTO `modepaiement` (`idMode`, `mode`) VALUES
(1, 'Carte Bleue'),
(2, 'Chèque'),
(3, 'Virement');

-- --------------------------------------------------------

--
-- Structure de la table `operations`
--

DROP TABLE IF EXISTS `operations`;
CREATE TABLE IF NOT EXISTS `operations` (
  `NumeroOperation` int(11) NOT NULL AUTO_INCREMENT,
  `motifOperation` varchar(20) NOT NULL,
  `DebitOperation` double DEFAULT NULL,
  `CreditOperation` double DEFAULT NULL,
  `MontantOperation` double NOT NULL,
  `DateOperation` date NOT NULL,
  `NumeroCompte` int(11) NOT NULL,
  `idType` int(11) NOT NULL,
  `idMode` int(11) NOT NULL,
  PRIMARY KEY (`NumeroOperation`),
  KEY `NumeroCompte` (`NumeroCompte`),
  KEY `idMode` (`idMode`),
  KEY `idType` (`idType`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `operations`
--

INSERT INTO `operations` (`NumeroOperation`, `motifOperation`, `DebitOperation`, `CreditOperation`, `MontantOperation`, `DateOperation`, `NumeroCompte`, `idType`, `idMode`) VALUES
(1, 'Gazole', 50, NULL, 50, '2018-08-01', 1001, 1, 1),
(2, 'Espèces', NULL, 40, 40, '2018-08-02', 1001, 2, 3),
(3, 'LaFoirFouille', 160, NULL, 160, '2018-08-03', 1002, 0, 0),
(4, 'GIFI', 80, NULL, 80, '2018-12-15', 1002, 1, 3),
(5, 'Remboursement CAF', NULL, 250, 250, '2018-12-16', 1002, 2, 1),
(6, 'Crédit Voiture', 160, NULL, 160, '2018-12-16', 1002, 1, 3),
(7, 'Retrait', 20, NULL, 20, '2018-12-16', 1001, 1, 2),
(8, 'Retrait', 50, NULL, 50, '2018-12-16', 1001, 1, 1),
(9, 'Pizzeria', 38, NULL, 38, '2018-12-16', 1001, 1, 1),
(10, 'Pole-emploi', NULL, 86, 86, '2018-12-16', 1001, 2, 2),
(11, 'Espèces', NULL, 2, 2, '2018-12-16', 1001, 2, 3),
(12, 'Espèces', NULL, 10, 10, '2018-12-16', 1001, 2, 2),
(13, 'Carrefour', 28, NULL, 28, '2018-12-16', 1001, 1, 2),
(14, 'Marie Blachere', 15, NULL, 15, '2018-12-16', 1001, 1, 1),
(15, 'Loyer', 468, NULL, 468, '2018-12-16', 1002, 1, 2),
(16, 'Gazole', 41, NULL, 41, '2018-12-16', 1002, 1, 2),
(17, 'Remboursement', NULL, 32, 32, '2018-12-16', 1002, 2, 3),
(18, 'Crédit Voiture', 258, NULL, 258, '2018-12-16', 1002, 1, 2),
(19, 'CAF', NULL, 89, 89, '2019-01-19', 1003, 2, 3),
(20, 'Boulangerie', 25, NULL, 25, '2019-01-19', 1003, 1, 2),
(21, 'Loyer', 463, NULL, 463, '2019-01-19', 1003, 1, 3),
(22, 'Essence', 80, NULL, 80, '2019-01-19', 1003, 1, 1),
(23, 'Revenu', NULL, 965, 965, '2019-01-19', 1003, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `typecompte`
--

DROP TABLE IF EXISTS `typecompte`;
CREATE TABLE IF NOT EXISTS `typecompte` (
  `idTypeCompte` int(11) NOT NULL AUTO_INCREMENT,
  `libelleType` varchar(60) NOT NULL,
  PRIMARY KEY (`idTypeCompte`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typecompte`
--

INSERT INTO `typecompte` (`idTypeCompte`, `libelleType`) VALUES
(1, 'Personnel'),
(2, 'Entreprise'),
(3, 'Associatif');

-- --------------------------------------------------------

--
-- Structure de la table `typeoperation`
--

DROP TABLE IF EXISTS `typeoperation`;
CREATE TABLE IF NOT EXISTS `typeoperation` (
  `idType` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeoperation`
--

INSERT INTO `typeoperation` (`idType`, `type`) VALUES
(1, 'Débit'),
(2, 'Crédit');

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `idVille` int(11) NOT NULL AUTO_INCREMENT,
  `libelleVille` varchar(60) NOT NULL,
  `idZoneGeo` int(11) NOT NULL,
  PRIMARY KEY (`idVille`),
  KEY `idZoneGeo` (`idZoneGeo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`idVille`, `libelleVille`, `idZoneGeo`) VALUES
(1, 'Toulouse', 1),
(2, 'Carbonne', 1),
(3, 'Meyzieu', 3),
(4, 'Echirolles', 3),
(5, 'St-Etienne', 2),
(6, 'Roanne', 2),
(7, 'Tarbes', 1),
(8, 'Langon', 4);

-- --------------------------------------------------------

--
-- Structure de la table `zonegeo`
--

DROP TABLE IF EXISTS `zonegeo`;
CREATE TABLE IF NOT EXISTS `zonegeo` (
  `idZoneGeo` int(11) NOT NULL AUTO_INCREMENT,
  `libelleZoneGeo` varchar(60) NOT NULL,
  PRIMARY KEY (`idZoneGeo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `zonegeo`
--

INSERT INTO `zonegeo` (`idZoneGeo`, `libelleZoneGeo`) VALUES
(1, 'Haute-Garonne'),
(2, 'Loire'),
(3, 'Rhône'),
(4, 'Aquitaine');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `comptes`
--
ALTER TABLE `comptes`
  ADD CONSTRAINT `comptes_ibfk_1` FOREIGN KEY (`CodeClient`) REFERENCES `clients` (`CodeClient`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `operations`
--
ALTER TABLE `operations`
  ADD CONSTRAINT `operations_ibfk_1` FOREIGN KEY (`NumeroCompte`) REFERENCES `comptes` (`NumeroCompte`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `ville`
--
ALTER TABLE `ville`
  ADD CONSTRAINT `ville_ibfk_1` FOREIGN KEY (`idZoneGeo`) REFERENCES `zonegeo` (`idZoneGeo`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
