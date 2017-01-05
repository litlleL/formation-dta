
CREATE TABLE `pizza` (
  `ID` int(11) NOT NULL,
  `categoriePizza` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `urlImage` varchar(255) DEFAULT NULL
);

--
-- Contenu de la table `pizza`
--

INSERT INTO `pizza` (`ID`,  `categoriePizza`, `code`, `nom`, `prix`, `urlImage`) VALUES
(1,  'VIANDE', '4FRO', 'Pizza 4 fromage', 12.5, 'Pizza_4fromages.jpg'),
(2, 'SANS_VIANDE', '4SAI', 'Pizza 4 saisons', 15.2, 'Pizza_4saisons.jpg');

--
-- Index pour les tables exportÃ©es
--

--
-- Index pour la table `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`ID`);

