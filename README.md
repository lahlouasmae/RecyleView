# Application de Gestion des Modèles

## Description
Gestion des Modèles est une application Android intuitive permettant d'afficher une liste de modèles sous forme de RecyclerView. Chaque modèle est présenté avec un nom, une image, et une note. L'application offre également une fonctionnalité de recherche via une barre dédiée dans le menu, facilitant ainsi la recherche de modèles spécifiques.

## Objectifs du projet :
- Affichage d'une liste de modèles avec leurs informations (nom, image, et note).
- Recherche dynamique à travers les modèles avec un SearchView intégré au menu.
- Partage d'un texte via l'option "Share" du menu.

## Fonctionnalités
- Liste des modèles : Affiche une collection de modèles sous forme de liste.
- Recherche de modèles : Permet aux utilisateurs de rechercher un modèle dans la liste.
- Partage d'un texte: via l'option "Share" du menu.

## Structure du projet

### Activités principales
1. SplashActivity :
   - Une activité de démarrage avec une animation appliquée sur une image (logo de l'application).
   
2. ListActivity :
   - Gère l'affichage de la liste des modèles sous forme de RecyclerView.
   - Chaque élément de la liste affiche le nom, une image, et une note.
   
3. ModelService :
   - Service chargé de la gestion et du traitement des données liées aux modèles.

### XML pour l'interface graphique

- activity_splash.xml : Fichier de mise en page pour la SplashActivity pour afficher une animation de démarrage de l'application.
- activity_list.xml : Fichier de mise en page pour la ListActivity affichant la liste des modèles.
  - Utilisation d'un RecyclerView pour afficher les modèles.
  
- model_item.xml : Fichier de mise en page des éléments de la liste des modèles, avec des TextView pour le nom, ImageView pour l'image et le rating bar.
- menu.xml : Menu de l'application avec les options de recherche et de partage.

## Logique Java
1. SplashActivity.java :
   - Afficher une activité animée pour une durée déterminée avant de rediriger l'utilisateur vers ListActivity.
   
2. ListActivity.java :
   - Charge la liste des modèles et les affiche dans un RecyclerView.

3. ModelService.java :
   - Assure la logique d'accès et de gestion des données des modèles.
   
4. ModelAdapter.java : Adapter pour gérer l'affichage des modèles dans le RecyclerView.
## Technologies utilisées

- **Java** : Langage principal utilisé pour le développement de l'application.
- **Android SDK** : Utilisé pour développer l'application Android native.
- **RecyclerView** : Composant Android pour afficher la liste des modèles.
- **Glide** : Utilisé pour le chargement des images dans la liste.
- **SearchView** : Barre de recherche intégrée au menu de l'application.
- **ShareCompat** : Pour partager du texte via l'option de partage dans le menu.


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

