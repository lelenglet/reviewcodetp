# Rapport : Recherche de la Clé pour le Fichier Secret.ks
**Auteur :** Lenglet Léa
**Date :** 20 décembre 2024
## Introduction
L'objectif de cette investigation était de trouver une clé capable d'ouvrir le fichier donné `Secret.ks`. Pour atteindre ce but, une approche analytique a été adoptée en utilisant des outils d'exploration de fichiers Java et une compréhension des mécanismes d'encryptage déployés.

---

## Étapes

### 1. Recherche de mots-clés au sein du fichier JAR avec JD-GUI
L'analyse initiale a consisté à explorer les fichiers contenus dans le fichier `com.michelin.ACO.crypto-2.0.0.jar` à l'aide de l'outil JD-GUI. Cet outil a permis de décompiler et de visualiser les classes Java afin d'identifier des indices liés à la clé ou à la logique d'encryptage.

### 2. Identification de la classe `SimpleCryptoHandler.java`
Lors de cette recherche, la classe `SimpleCryptoHandler.java` a été identifiée comme contenant la logique d'encryptage. Une analyse plus approfondie a révélé que cette classe manipulait une valeur cryptée, potentiellement liée à la clé recherchée.

### 3. Test sur la classe avec ajout d'un `main`
Pour tester la classe et extraire la clé, un point d'entrée a été ajouté sous forme d'une méthode `main`. Un objet de type `SimpleCryptoHandler` a été initialisé pour exécuter les méthodes pertinentes et afficher les valeurs cryptées et décryptées.
```java
public static void main(String[] argv) {
        SimpleCryptoHandler secret = new SimpleCryptoHandler("Secret.ks");
}
```

La ligne suivante nous indique que `str` est une chaine qui pouvait être non cryptée et en l'affichant la clé a été découverte.
```
String str = (String) method2.invoke(object, new Object[0]);
System.out.println(str);
```
La clé découverte est donc `aM#2uT)@e1*A`

---

## Validation de la clé
Pour valider la clé et accéder au contenu du fichier `Secret.ks`, la commande suivante a été utilisée :

```bash
keytool -list -keystore Secret.ks
```

En entrant la clé découverte, le fichier a pu être ouvert avec succès, confirmant ainsi l'efficacité de la procédure.
On vérifie que la commande fonctionne correctement en entrant un autre mot de passe qui nous refuse l'accès au fichier.

---
## Méthode de cryptographie 

La classe `mE` implémente une méthode de cryptographie personnalisée qui repose principalement sur des transformations de données via des nombres aléatoires et des opérations de type XOR. Voici les points clés de cette méthode :

### Encodage et transformation des données 
- La classe utilise l'encodage UTF-8 pour convertir des chaînes de caractères en tableaux de bytes.
- Des opérations de transformation sont appliquées à ces bytes pour les convertir en long.

### Utilisation de nombres aléatoires 
- La méthode de chiffrement génère des nombres aléatoires à l'aide de la classe `Random` pour mélanger les données.
- Chaque segment de 8 bytes de la chaîne de caractères est transformé par un nombre aléatoire généré à chaque itération via l'opération XOR.

### Opération XOR 
- L'opération XOR est utilisée pour altérer les données d'entrée en les combinant avec des nombres aléatoires, rendant la transformation difficile à inverser sans la clé ou les mêmes valeurs aléatoires.
 
---
# Sécurité du code 
On remarque en parcourant le code que la clé est sécurisée grâce à l'algorithme Advanced Encryption Standard, qui est un chiffrement symétrique qui rend le décryptage quasiment impossible.

Le code est également protégé. En effet, une technique couramment utilisée pour augmenter la difficulté d'accès au code par des hackers est l'obfuscation. Cette approche rend le code moins lisible, en modifiant par exemple les noms des classes et en altérant le contenu même du code.
On a remarqué l'utilisation de cette méthode sur la classe `SimpleCryptoHandler` qui contenait dans ces appels de fonctions des virgules supplémentaires.


