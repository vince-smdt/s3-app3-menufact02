# À utiliser (obligatoire):
- Singleton
  - Pour le chef afin d'éviter d'avoir plusieurs instances de chef
  - Sinon, singleton au niveau d'un gestionnaire de factures (FactureManager), voir Facade plus bas dans les 2 design patterns extras à ajouter
- Factory
  - Pour la création de plats de différents types
- Observer
  - Pour notifer le chef d'un plat commandé via abonnement de la facture au chef
- State
  - Pour l'état des factures, toString() et fermer() ouvrir() payer() agieront de façons différentes à partir de l'état actuel
- MVC
  - Au niveau de la facture (modèle pour les données, vue pour l'affichage et contrôleur pour gérer le reste)
- Flyweight
  - Pour les ingrédients (à la place de recréer les ingrédients pour chaque plat, en crée un et passer l'instance a chaque plat en ayant besoin)

# Les 2 design patterns extras:
- Bridge
  - Permettre à la hiérarchie d'ingrédients liquides et solides d'être référencée dans la hiérarchie de type d'ingrédient, à la place de créer une classe pour chaque combinaison
- Facade
  - Offrir une interface au client pour simplifier les interactions avec le sous-système complexe, une classe gestion de haut niveau pour le client (au niveau de la facture?)