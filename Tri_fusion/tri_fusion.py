import argparse
import sys

def read_file(filename):
    valeurs = []
    try:
        with open(filename, 'r') as fichier:
            contenu = fichier.read().strip()  
            valeurs = contenu.split()  
            valeurs = [float(val) for val in valeurs]  
    except FileNotFoundError:
        print("Le fichier spécifié n'a pas été trouvé.")
    except Exception as e:
        print("Une erreur est survenue :", e)
    return valeurs

def fusion(tab, p, q, r):
    n1 = q - p
    n2 = r - q

    ag = copy_borne_table(tab, p, q)
    ad = copy_borne_table(tab, q, r)

    indG = 0
    indD = 0

    i = p

    while i < r:
        if indG == n1:
            tab[int(i)] = ad[int(indD)]
            indD = indD + 1
        elif indD == n2:
            tab[int(i)] = ag[int(indG)]
            indG = indG + 1
        elif ag[indG] < ad[indD]:
            tab[int(i)] = ag[int(indG)]
            indG = indG + 1
        else:
            tab[int(i)] = ad[int(indD)]
            indD = indD + 1
        i += 1


def sousTriFusion(tab, p, r):
    if p < r-1:
        q = (p+r)//2
        sousTriFusion(tab, p, q)
        sousTriFusion(tab, q, r)
        fusion(tab, p, q, r)


def copy_borne_table(tab, borne1, borne2):
    tab2 = []
    for i in range (int(borne1), int(borne2)):
        tab2.append(tab[i])
    return tab2

def tri_fusion(filename, size):
    tab = read_file(filename)
    print(tab)
    sousTriFusion(tab, 0, size)
    print(tab)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Effectue un tri par fusion sur un fichier spécifié.")
    parser.add_argument("filename", type=str, help="Chemin vers le fichier à trier.")
    parser.add_argument("size", type=int, help="Taille du tableau à trier.")
    args = parser.parse_args()

    # Définissez la limite de profondeur de récursion
    sys.setrecursionlimit(args.size)  # Vous pouvez ajuster la limite selon vos besoins
    
    tri_fusion(args.filename, args.size)
