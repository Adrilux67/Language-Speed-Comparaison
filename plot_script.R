#!/usr/bin/Rscript

# Charger les données depuis un fichier CSV
perf <- read.csv("essaie2.csv")
print("Données chargées avec succès.")

# Charger la librairie ggplot2
library(ggplot2)
print("Librairie ggplot2 chargée avec succès.")

# Obtenir la valeur maximale de la colonne Taille
max_taille <- max(perf$Taille)

# Tracer un graphique avec ggplot2 en utilisant facet_grid pour diviser les données
print("Tracé du cinquième graphique...")
ggsave("graphique2.png", ggplot(perf, aes(x=Taille, y=Temps, color=Tri, shape=Langage)) + 
         geom_point(size=4) + 
         facet_grid(Langage~Tri) + 
         theme(legend.position = "none", axis.ticks.x = element_blank()) +
         scale_x_continuous(breaks = max_taille) +
         labs(x = "Taille"),
         width = 15, height = 6)
