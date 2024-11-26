# AwesomePasswordChecker

Project made in Java during the class of __Code Review__ by lelenglet and EvanC2611

## Table of content

* [Summary](#summary)
* [Tecnologies](#tecnologies)
* [Setup](#setup)
* [Usage](#usage)
* [Licence et Checkstyle](#licence-et-checkstyle)
* [Améliorations](#amélioration)

## Summary

AwesomePasswordChecker is a library with 2 features

- Allow to check the security level of a password
- Allow to encrypt a password using MD5

## Tecnologies

- Java 21
- Maven 3.6.1

## Setup

To download the library :

download the _.jar_ file in the project.

## Usage

### Check Password Security Level

First instanciate the class with :
```
AwesomePasswordChecker APC;
APC = AwesomePasswordChecker.getInstance();
or
APC = AwesomePasswordChecker.getInstance(f);
```
where _f_ is a file containing values seperated by ','

Then you can use it with :
```
Double resul = APC.getDistance(password);
```
where _password_ is a String with your password.

### Encrypt with MD5

To do so :
```
String passwordMD5 = AwesomePasswordChecker.ComputeMD5(string);
```
where _password_ is a String with your password.

## Licence et Checkstyle

We used the licence and checkstyle used by __Michelin__ for their projects.

## Amélioration

- Implémenter des tests de performances pour ComputeMD5
- Faire en sorte que le deploy fonctionne
- Faire en sorte que la javadoc se publie automatiquement