# AwesomePasswordChecker

- [![cov](https://lelenglet.github.io/reviewcodetp/badges/coverage.svg)](https://github.com/lelenglet/reviewcodetp/actions)

Project made in Java during the class of **Code Review** by lelenglet and EvanC2611

## Table of content

- [AwesomePasswordChecker](#awesomepasswordchecker)
  - [Table of content](#table-of-content)
  - [Summary](#summary)
  - [Tecnologies](#tecnologies)
  - [Setup](#setup)
  - [Usage](#usage)
    - [Check Password Security Level](#check-password-security-level)
    - [Encrypt with MD5](#encrypt-with-md5)
  - [Licence et Checkstyle](#licence-et-checkstyle)
  - [Amélioration](#amélioration)
  - [SCM](#scm)
    - [Secutity.md](#secutitymd)
    - [Issues templates](#issues-templates)
    - [Pull request template](#pull-request-template)
    - [Protected Branches policies et Pull request policy](#protected-branches-policies-et-pull-request-policy)

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

We used the licence and checkstyle used by **Michelin** for their projects.

## Amélioration

- Implémenter des tests de performances pour ComputeMD5
- Faire en sorte que le deploy fonctionne
- Faire en sorte que la javadoc se publie automatiquement

## SCM

### Secutity.md

Dans le fichier `security.md` nous avons renseigné les versions de langage supporté par le projet pour éviter les conflits de version. Nous avons également spécifié les démarches à suivre lors de la découverte de bug au sein du projet. Si le bug a été corrigé par la personne il peut faire une merge request, sinon il doit créer une issue pour que le développeur le corrige.

### Issues templates

Nous avons créé un modèle de pour report les issues pour les bugs. Il se présente sous la forme d'un petit formulaire contenu dans le fichier `BASIC_ISSUE.yml`.

### Pull request template

Nous avons également créé un modèle de pull request pour les merge request. Le template est contenu dans le fichier `pull_request_template.md`. C'est une version minimale qui pourrait être complétée en fonction des besoins du projet.

### Protected Branches policies et Pull request policy

Nous avons mis une protection sur la branche `main` en obligeant tous les utilisateurs travaillant sur cette branche d'effectuer des commits signés.
Nous avons aussi choisi de filtrer les pull request qui ne sont pas validés par au moins une personne du projet.
