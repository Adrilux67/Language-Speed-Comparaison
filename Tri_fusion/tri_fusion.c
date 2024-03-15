#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* read_file(char* filename, int* taille){
    FILE* fichier = NULL;
    fichier = fopen(filename, "r");
    int* tab = malloc(*taille * sizeof(int));
    *taille = 0;
    while(fscanf(fichier, "%d",&tab[*taille]) == 1){
        (*taille) ++;
    }
    fclose(fichier);
    return tab;
}

void fusion(int* tab, int p, int q, int r) {
    int n1 = q-p;
    int n2 = r-q;
    int* tabG = malloc(n1 * sizeof(int));
    int* tabD = malloc(n2 * sizeof(int));
    memcpy(tabG,tab+p,n1 * sizeof(int));
    memcpy(tabD,tab+q,n2 * sizeof(int));
    int indG = 0;
    int indD = 0;
    int i = p;
    while(i<r)
    {
        if(indG == n1)
        {
            tab[i] = tabD[indD];
            indD++;
        }
        else if(indD == n2)
        {
            tab[i] = tabG[indG];
            indG++;
        }
        else if(tabG[indG] < tabD[indD])
        {
            tab[i] = tabG[indG];
            indG++;
        }
        else
        {
            tab[i] = tabD[indD];
            indD++;
        }
        i++;
        
    }
    free(tabG);
    free(tabD);
}

int* sous_tri_fusion(int* tab, int p, int r) {
    if(p<r-1)
    {
        int q = (p+r) / 2;
        sous_tri_fusion(tab, p, q);
        sous_tri_fusion(tab, q, r);
        fusion(tab, p, q, r);
    }
    return tab;
}


int* tri_fusion(char* filename, int taille){
    int* tab = read_file(filename,&taille);
    tab = sous_tri_fusion(tab,0,taille);
    for(int i=0; i<taille; i++)
    {
        printf("%d\n", tab[i]);
    }
    return tab;
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <size>\n", argv[0]);
        return 1;
    }

    int size = atoi(argv[1]);
    int* tab = tri_fusion("./tab.txt", size);
    free(tab);

    return 0;
}
