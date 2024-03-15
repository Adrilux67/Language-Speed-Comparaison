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

int partition(int* tab, int p, int r) {
    int pivot = tab[r-1];
    int i = p;
    int* buf = malloc(1 * sizeof(int));
    buf[0] = 0;
    for(int j=p; j < r-1;j++)
    {
        if(tab[j] <= pivot)
        {
            buf[0] = tab[i];
            tab[i] = tab[j];
            tab[j] = buf[0];
            i++;
        }
    }
    buf[0] = tab[i];
    tab[i] = tab[r-1];
    tab[r-1] = buf[0];

    free(buf);
    return i;
}

int* sous_tri_rapide(int* tab, int p, int r) {
    if(p<r-1)
    {
        int q = partition(tab,p,r);
        sous_tri_rapide(tab, p, q);
        sous_tri_rapide(tab, q+1, r);
    }
    return tab;
}


int* tri_rapide(char* filename, int taille){
    int* tab = read_file(filename,&taille);
    tab = sous_tri_rapide(tab,0,taille);
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
    int* tab = tri_rapide("./tab.txt",size);
    free(tab);

    return 0;
}
