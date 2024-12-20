# Rapport TP2 Code Review

## 1. Recuperer la clé pour ouvrir le fichier Secret.ks

La première chose que j'ai faites a été d'ouvrir l'archive JAR *"com.michelin.ACO.crypto-2.0.0.jar"* à l'aide de l'outil JDUnit utilisable avec la commande :

```console
java -jar jd-gui-1.6.6.jar
```

En parcourant les noms des classes contenu dans le JAR, on trouve deux noms qui ressortent : *"CryptoConverter"* et *"SimpleCryptoHandler"*

La première des deux semblent n'être utile que pour établir une connexion avec le framework EclipseLink qui sert juste à stocker des objets Java dans une base de données relationnelle.

La deuxième cependant est un peu plus énigmatique. On remarque qu'il utilise 2 classe mC et mE et en regardant dans la classe mC on trouve cette partie de code :

```java
public static mC a(String paramString1, String paramString2) {
    if (paramString1 == null) {
      paramString1 = "data/key.ks";
```

paramString1 semble être le nom d'un fichier .ks et paramString2 semble être la clé pour ouvrir ce fichier, donc ce qu'on recherche.

Cette méthode est appelé dans SimpleCryptoHandler :
```java
public SimpleCryptoHandler(String paramString) {
```
```java
      String str = (String)method2.invoke(object, new Object[0]);
      this.facade = mC.a(paramString, str);
```

donc str est le string de la clé qu'on recherche. 

Pour récupérer sa valeur on copie-colle le code donné par JDUnit dans un nouveau fichier java (par exemple TP2.java), on corrige les erreurs dù à l'interprétation de JDUnit et on rajoute cette ligne.
```java
System.out.println(str);
```

On rajoute un main où on instancie un nouveau SimpleCryptoHandler avec en paramètre "Secret.ks"

```java
public class TP2 {
  public static void main(String[] args) throws Exception {
    SimpleCryptoHandler sch = new SimpleCryptoHandler("Secret.ks");
  }
}
```

Ceci nous affiche le string : aM#2uT)@e1*A

On peut tester si c'est la clé en executant la commande la commande

```commande
keytool -list -keystore Secret.ks
```

Ce qui après avoir rentré la clé, nous donne

```commande
Entrez le mot de passe du fichier de clés :  
Type de fichier de clés : JCEKS
Fournisseur de fichier de clés : SunJCE

Votre fichier de clés d'accès contient 1 entrée

supersecret, 1 déc. 2024, SecretKeyEntry, 

Warning:
Le fichier de clés JCEKS utilise un format propriétaire. Il est recommandé de migrer vers PKCS12, qui est un format standard de l'industrie en utilisant "keytool -importkeystore -srckeystore Secret.ks -destkeystore Secret.ks -deststoretype pkcs12".
```

## 2. Securisation du keystore

Une technique apparente pour protéger la lecture du code pour les potentiels hackers est l'obfuscation du code que ce soit par le nom des classes que dans le code lui même.

En remontant dans la liste des méthodes appelée par le programme on trouve dans la classe mD que la clé a été encodé sous AES ou Advanced Encryption Standard. Cette algorithme de chiffrement symétrique permet d'encrypter la clé de manière quasi incassable.