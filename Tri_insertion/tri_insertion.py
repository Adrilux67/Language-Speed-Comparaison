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

def insertion(filename, size):
    tab = read_file(filename)
    print(tab)
    for i in range(1, size):
        cle = tab[i]
        j = i-1
        while(j>=0 and tab[j] > cle):
            tab[j+1] = tab[j]
            j = j-1
        tab[j+1] = cle

    print(tab)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Effectue un tri par insertion sur un fichier spécifié.")
    parser.add_argument("filename", type=str, help="Chemin vers le fichier à trier.")
    parser.add_argument("size", type=int, help="Taille du tableau à trier.")
    args = parser.parse_args()

    # Définissez la limite de profondeur de récursion
    sys.setrecursionlimit(args.size)  # Vous pouvez ajuster la limite selon vos besoins

    insertion(args.filename, args.size)
