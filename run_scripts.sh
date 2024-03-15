#!/bin/bash
#ggplot(perf,aes(x=Taille,y=Temps))+geom_point()
#ggplot(perf,aes(x=Taille,y=Temps,color=Tri,shape=Langage))+geom_point()
#ggplot(perf,aes(x=Taille,y=Temps,color=Tri,shape=Langage))+geom_point(size=2)
#ggplot(perf,aes(x=Taille,y=Temps,color=Tri,shape=Langage))+geom_point(size=4)
#ggplot(perf,aes(x=Taille,y=Temps,color=Tri,shape=Langage))+geom_point(size=4)+facet_grid(Langage~Tri)


# Appel du script de compilation
./compilation.sh

itteration=10
tailleTableau=10000

# Fonction pour obtenir le temps d'exécution en millisecondes
get_execution_time_ms() {
    res=`(/usr/bin/time -f "%U,%M" $@ > /dev/null)2>&1`
}

# Création du fichier CSV avec l'en-tête
echo "Langage,Tri,Taille,Temps,mémoire"

    # Création d'un nouveau tableau
    `(java Generate_tab $tailleTableau > /dev/null)2>&1`

#######################################################################

# Exécution des fonctions TRI_FUSION en C
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" ./Tri_fusion/tri_fusion $tailleTableau > /dev/null)2>&1`
    echo "C,Fusion,$tailleTableau,$res"
done

# Exécution des fonctions TRI_RAPIDE en C
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" ./Tri_rapide/tri_rapide $tailleTableau > /dev/null)2>&1`
    echo "C,rapide,$tailleTableau,$res"
done

# Exécution des fonctions TRI_INSERTION en C
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" ./Tri_insertion/tri_insertion $tailleTableau > /dev/null)2>&1`
    echo "C,insertion,$tailleTableau,$res"
done

#######################################################################

# Exécution des fonctions TRI_FUSION en JAVA
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" java Tri_fusion.Fusion $tailleTableau > /dev/null)2>&1`
    echo "Java,Fusion,$tailleTableau,$res"
done

# Exécution des fonctions TRI_RAPIDE en JAVA
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" java Tri_rapide.Rapide $tailleTableau > /dev/null)2>&1`
    echo "Java,rapide,$tailleTableau,$res"
done

# Exécution des fonctions TRI_INSERTION en JAVA
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" java Tri_insertion.Insertion $tailleTableau > /dev/null)2>&1`
    echo "Java,insertion,$tailleTableau,$res"
done

#######################################################################

# Exécution des fonctions TRI_FUSION en PYTHON
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" python3 Tri_fusion/tri_fusion.py ./tab.txt $tailleTableau > /dev/null)2>&1`
    echo "Python,Fusion,$tailleTableau,$res"
done

# Exécution des fonctions TRI_RAPIDE en PYTHON
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" python3 Tri_rapide/tri_rapide.py ./tab.txt $tailleTableau > /dev/null)2>&1`
    echo "Python,rapide,$tailleTableau,$res"
done

# Exécution des fonctions TRI_INSERTION en PYTHON
for ((i=1; i<=$itteration; i++))
do
    res=`(/usr/bin/time -f "%U,%M" python3 Tri_insertion/tri_insertion.py ./tab.txt $tailleTableau > /dev/null)2>&1`
    echo "Python,insertion,$tailleTableau,$res"
done

