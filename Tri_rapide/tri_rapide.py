import argparse
import sys
def read_file(filename):
    valeurs = []
    try:
        with open(filename, 'r') as fichier:
            contenu = fichier.read().strip()  # Lire le contenu du fichier et supprimer les espaces en excès
            valeurs = contenu.split()  # Diviser le contenu en valeurs individuelles en utilisant les espaces comme séparateurs
            valeurs = [float(val) for val in valeurs]  # Convertir les valeurs en flottants
    except FileNotFoundError:
        print("Le fichier spécifié n'a pas été trouvé.")
    except Exception as e:
        print("Une erreur est survenue :", e)
    return valeurs

def partition(tab, p, r):
    pivot = tab[r-1]
    i = p
    for j in range(p, r-1):
        if tab[j] < pivot:
            temp = tab[i]
            tab[i] = tab[j]
            tab[j] = temp
            i+=1
    temp = tab[i]
    tab[i] = tab[r-1]
    tab[r-1] = temp
    return i

def sousTriRapide(tab, p, r):
    if p < r-1:
        q = partition(tab, p, r)
        sousTriRapide(tab, p, q)
        sousTriRapide(tab, q+1, r)


def triRapide(filename, size):
    tab = read_file(filename)
    print(tab)
    sousTriRapide(tab, 0, size)
    print(tab)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Effectue un tri rapide sur un fichier spécifié.")
    parser.add_argument("filename", type=str, help="Chemin vers le fichier à trier.")
    parser.add_argument("size", type=int, help="Taille du tableau à trier.")
    args = parser.parse_args()

    # Définissez la limite de profondeur de récursion
    sys.setrecursionlimit(args.size)  # Vous pouvez ajuster la limite selon vos besoins

    triRapide(args.filename, args.size)