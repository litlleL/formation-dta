# formation-dta

* *Author* : ASDRUBAL Livio
* *Technologies* : Java 
* *Summary* : Projet Maven

## projet multi modules basé sur une base de gestion de menu de pizzeria

Le projet est cindé en deux parties:
  * La première partie livio-pizzeria-parent:
    * un projet parent (pom.xml) qui mutualise de la configuration entre
les différents projets enfants(modules).
  * La deuxième partie séparé en trois sous projet maven:
    * un projet livio-pizzeria-console contenant la partie ihm de l'application
    * un projet livio-pizzeria-dao contenant la partie donnée
    * un projet livio-pizzeria-model contenant le modèle Pizza sur lequel l'application est basé.
 
 ## Test
 
* Pour tester en utilisant la base de donnée fichier 
   * mvn clean install -Pfichier
   * java -jar livio-pizzeria-console\target\pizzeria.jar 
  
* Pour tester en utilisant la base de donnée tableau
   * mvn clean install -Ptableau
   * java -jar livio-pizzeria-console\target\pizzeria.jar 
 
 ## Bugs
 
 ## Developpers
 
* ASDRUBAL Livio
