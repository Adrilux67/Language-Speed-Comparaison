# P41 : Performances et optimisation

## Objectifs pédagogiques

  - Comprendre la complexité algorithmique. 
  - Savoir mesurer des performances applicatives en boîte noire.
  - Savoir analyser des performances applicatives en regard de complexités théoriques. 

## Objectifs de réalisation

1. Comparer les performances applicatives 

  - temps d'exécution et consommation mémoire
  - de trois tris différents
  - dans trois langages différents
  - sur des données complètement aléatoires
  - décompte des opérations élémentaires

2. Explorer une hypothèse


## Evaluation

### Générateur de données de test.

- [ ] Génère un fichier d'entiers aléatoires selon une taille donnée en entrée.
- [ ] Génère des fichiers d'entiers qui correspondent aux meilleurs et aux pires cas de complexité des algorithmes

### Comparaison des tris et langages

- [ ] Au moins trois tris dans trois langages sont codés et fonctionnels.
- [ ] Au moins deux tris dans deux langages sont codés et fonctionnels.
- [ ] Au moins un tri dans un langage est codé et fonctionnel.
- [ ] Les calculs de complexité sont correctement effectués.

### Description du protocole expérimental de la comparaison des tris

- [ ] Le protocole expérimental de la comparaison des tris est clairement et pleinement décrit
- [ ] Les paramètres expérimentaux ne sont pas trop petits : tous les phénomènes et épi-phénomènes sont visibles.
- [ ] Les paramètres expérimentaux ne sont pas trop grands : il n'y a pas d'expériences superflues.

### Résultats de la comparaison

- [ ] L'analyse des résultats est pertinente.
- [ ] Les limites sont exhaustives et pertinentes.
- [ ] La conclusion tient en une phrase pertinente.

### Vérification d'une hypothèse 

- [ ] L'hypothèse est de difficulté ***. 
- [ ] L'hypothèse est de difficulté au moins **. 
- [ ] Le protocole expérimental est exhaustif et pertinent.
- [ ] Les visualisations sont exhaustives et pertinentes.
- [ ] Les limites et conclusions sont exhaustives et pertinentes.
- [ ] Les conclusions se confrontent à la théorie.

### Conclusion générale

- [ ] La conclusion générale est succincte, pertinente, et prend de la hauteur.

### Reproductibilité

- [ ] Les codes sont propres et commentés, et en lien direct depuis le rendu.
- [ ] Les codes sont testés systématiquement et les résultats des tests sont consultables.
- [ ] Les commandes pour reproduire toutes les expérimentations sont indiquées dans le code et le rendu.
- [ ] Un make unique permet de compiler tous les codes.
- [ ] Une commande unique permet de reproduire toutes les expérimentations et visualisations.

### Qualité des représentations graphiques

- [ ] Les graphiques ne comportent aucun artefact sans justification.
- [ ] Les axes et unités sont bien renseignés.
- [ ] Les graphiques comportent : titre, auteurs et source.
- [ ] Les graphiques n'induisent pas en erreur un lecteur rapide (qui ne lit pas les axes).

## Rendu 

### Générateur de données

[Lien vers le code](lien)

Utilisation :
```
Exécutables et paramètres
```

### Comparaison des tris et langages

Tris : 

  - Insertion
  - Rapide
  - fusion

Langages :

  - Compilé : [Lien vers le code (par défaut C)](lien)
  - Compilé/interprété : [Lien vers le code (par défaut C# ou Java)](lien)
  - Interprété : [Lien vers le code (par défaut Python)](lien)

#### Description du protocole expérimental

  - Nombre d'expériences par tri/langage : 
  - Plage des paramètres : 
  - Méthode de fixation des paramètres :
  - Description de la machine de test :

```
Description de la machine de test
```

#### Résultats

```
Ligne de commande pour produire les résultats
```

[Lien vers le fichier de données](lien)


##### Temps d'exécution 

`Unique graphique temps d'exécution`

Analyse du graphique

##### Consommation mémoire

`Unique graphique mémoire`

Analyse du graphique

#### Limites et conclusion de la comparaison des tris et langages

Mettre les résultats pratiques en regard des résultats théoriques.

Identifier les limites de l'analyse.

Conclure en une seule phrase.


### Hypothèse

Choisir une hypothèse dans la liste suivante et la vérifier par une expérimentation, ou bien concevoir sa propre hypothèse et la faire valider par son enseignant. Supprimer du README les hypothèses non fouillées.
Le nombre d'étoiles indique la difficulté.

_Attention_ : certaines hypothèses peuvent être fausses.

- Le choix du pivot influence les performances du tri rapide (*)
- C est plus rapide que Java (*)
- Le tri fusion peut être optimiser en terme de vitesse de calcul. (**)
- Les langages compilés sont plus rapides que les langages interprétés. (**)
- La nature des données à trier influence les performances des tris (**)
- Les options du compilateur influencent les performances (**).
- Il existe des optimisations du tri rapide pour avoir une complexité optimale sur les tableaux constants et strictement décroissants (**).
- Le tri rapide est plus complexe mais plus rapide que le tri fusion (**)
- Le tri fusion peut être optimiser en terme d'allocation mémoire. (**)
- Les tris génériques (void*, template...) sont plus lents. (**/***)
- Détecter la nature des données permet de gagner en temps d'exécution (***)
- Le tri insertion permet d'optimiser le tri fusion et le ti rapide. (***)
- Python est ralenti par l'absence de typage (simulation possible en C). (***)

#### Description du protocole expérimental 

#### Résultats

### Conclusion générale

