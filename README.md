# eCommerce API

Conception d'une API E-Commerce

## Prerequis

Avant d'exécuter l'application, assurez-vous que les éléments suivants sont installés sur votre ordinateur :

1. **Java Version 17**: Install [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
2. **PostgreSQL ou PhpAdmin**: Installer PostgreSQL et creer une base de donnée `e-commerce_db`

## Installation de la base de donnée

Après avoir installé PostgreSQL, créez la base de données `e-commerce_db` en exécutant la commande SQL suivante :

```sql
CREATE DATABASE e_commerce_db;
```

## Configuration de l'Application

Dans le fichier `src/main/resources/application.properties`, ajoutez les détails de votre connexion MySQL :

```properties
spring.datasource.url=your_db_link
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Remplacez `your_db_link`, `your_username` et `your_password` par les détails de votre connexion à la base de données réelle

## Caractéristique

L'application fournit les points de terminaison suivants pour gérer les entités « User »  « Produit »  « Payment »  « Order»  « Order_Item» .

## Diagramme de Classe

<img width="469" alt="Diagramme_de_classe" src="https://github.com/user-attachments/assets/14bf2a02-976a-43d4-8a2e-07862db36e13">

## API Endpoints


| HTTP Method | Endpoint              | Description               |
| ----------- | --------------------- | ------------------------- |
| **POST**    | `/produits`           | Ajouter un produit        |
| **GET**     | `/produits`           | Obtenir un produit         |
| **PUT**     | `/produits/{id}`      | Modifier un produit        |
| **DELETE**  | `/produits/{id}`      | Supprimer un produit       |
|-------------|---------------------- |---------------------------|
| **POST**    | `/panier`             | Ajouter un panier          |
| **GET**     | `/panier`             | Obtenir un panier          |
| **PUT**     | `/panier/{id}`        | Modifier un panier         |
| **DELETE**  | `/panier/{id}`        | Supprimer un panier        |
|-------------|-----------------------|---------------------------|
| **POST**    | `/paiement`           | Effectuer un paiement      |
| **GET**     | `/paiement`           | Voir l'historique des paiements |
|-------------|-----------------------|---------------------------|
| **POST**    | `/user`               | Créer un utilisateur       |
| **GET**     | `/user/{id}`          | Obtenir un utilisateur     |
| **PUT**     | `/user/{id}`          | Modifier un utilisateur    |
| **DELETE**  | `/user/{id}`          | Supprimer un utilisateur   |


## Comment exécuter l'application
1. Clone le repository:
     ```bash
   git clone https://github.com/BAKJUNIOR/e-commerce.git
   ```

2. Accédez au répertoire du projet :

   ```bash
   cd e-commerce
   ```
3. Chargez les dependences Maven
4. Creez un fichier `.env` 
 ```bash
   CLOUDINARY_URL = your_cloudinary_url
   ```

5. Construisez le projet à l'aide de Maven :

   ```bash
   mvn clean install
   ```

6.Exécutez l'application :

   ```bash
   mvn spring-boot:run
   ```

7.Ouvrez votre postman ou navigateur sur « http://localhost:8081/ » et accédez aux points de terminaison de l'application.

## Technologies Used

- **Spring Boot**
- **Cloudinary**
- **PostgreSQL**
- **Java 17**

## Contributors


| Contributeur                                         | Rôle                     | Contributions principales                                  |
|------------------------------------------------------|--------------------------|------------------------------------------------------------|
| [BAKUS JUNIOR](https://github.com/bakjunior)         | Lead Backend             | Gestion de l'architecture backend, développement des API   |
| [BEUGRE](https://github.com/Audre1)                  |  Gestionnaire Projet     |Mise en Place de la documentation , suivi du projet et développement des API        |
| [BANGAH](https://github.com/Bino26)                  | Backend Developer        | Developpement du Cloud    ,développement des API                                 |
| [WONOM](https://github.com/wononkaridja)             | Gestionnaire BD          | Mise en Place du Diagramme et de la BD ,développement des API                    |
| [DIOMANDE](https://github.com/diomandesouleymane)    | Testeur                  |Tests API et fonctionnels  ;développement des API                                 |
      


