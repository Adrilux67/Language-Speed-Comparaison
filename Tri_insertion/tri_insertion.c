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

int* tri_tab(int* tab, int taille){
    for(int i=1; i<taille;i++)
    {
        int key = tab[i];
        int j = i-1;
        while(j>=0 && tab[j]>key)
        {
            tab[j+1] = tab[j];
            j=j-1;
        }
        tab[j+1] = key;
    }
    return tab;
}

int* insertion(char* filename, int taille){
    int* tab = read_file(filename,&taille);
    tab = tri_tab(tab,taille);
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
    int* tab = insertion("./tab.txt",size);
    free(tab);

    return 0;
}
