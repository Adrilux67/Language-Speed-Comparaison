#!/bin/bash

# Compilation JAVA
javac Generate_tab.java
javac Tri_insertion/Insertion.java
javac Tri_rapide/Rapide.java
javac Tri_fusion/Fusion.java

# Compilation C
gcc Tri_insertion/tri_insertion.c -o Tri_insertion/tri_insertion
gcc Tri_rapide/tri_rapide.c -o Tri_rapide/tri_rapide
gcc Tri_fusion/tri_fusion.c -o Tri_fusion/tri_fusion
