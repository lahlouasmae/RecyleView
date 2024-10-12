# Projet de liste de models

Ce projet est une application Android simple qui affiche une liste de modèles (models) dans un `RecyclerView`. Chaque modèle contient un nom, une image, et une note. L'utilisateur peut également rechercher des modèles en utilisant une barre de recherche dans le menu.

## Fonctionnalités

- Affichage d'une liste de modèles avec leurs informations (nom, image, et note).
- Recherche dynamique à travers les modèles avec un `SearchView` intégré au menu.
- Partage d'un texte via l'option "Share" du menu.

## Technologies utilisées

- **Java** : Langage principal utilisé pour le développement de l'application.
- **Android SDK** : Utilisé pour développer l'application Android native.
- **RecyclerView** : Composant Android pour afficher la liste des modèles.
- **Glide** : Utilisé pour le chargement des images dans la liste.
- **SearchView** : Barre de recherche intégrée au menu de l'application.
- **ShareCompat** : Pour partager du texte via l'option de partage dans le menu.

## Structure du projet

Le projet est structuré comme suit :

- `ListActivity.java` : Activité principale où la liste des modèles est affichée.
- `Model.java` : Classe représentant un modèle avec des attributs `nom`, `image` et `note`.
- `ModelAdapter.java` : Adapter pour gérer l'affichage des modèles dans le `RecyclerView`.
- `ModelService.java` : Service pour gérer la création et la récupération des modèles.
- `menu.xml` : Menu de l'application avec les options de recherche et de partage.

## Comment démarrer

### Pré-requis

- **Android Studio** : Assurez-vous que vous avez Android Studio installé sur votre machine.
- **Emulateur Android** ou **dispositif Android** pour tester l'application.

### Instructions

1. Clonez ce repository sur votre machine locale.
   ```bash
   git clone https://github.com/votre-utilisateur/votre-repository.git
2.Ouvrez le projet dans Android Studio.
3.Compilez et exécutez le projet sur un émulateur ou un appareil physique.

### Exemple de modèles

Les modèles sont définis dans la méthode init() de la classe ListActivity. Voici quelques exemples de modèles ajoutés :
service.create(new Model("Bella Hadid", "https://example.com/bella.jpg", 4.5f));
service.create(new Model("Gigi Hadid", "https://example.com/gigi.jpg", 4.0f));
service.create(new Model("Kendall Jenner", "https://example.com/kendall.jpg", 5.0f));

### Video Descriptif

