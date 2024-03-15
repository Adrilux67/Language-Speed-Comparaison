def read_file(filename):
    f = open(filename, "r")
    return f

def insertion(filename, size):
    tab = read_file(filename)
    print(tab)

insertion("../tab.txt")