words = []

with open("leipzig100k.txt") as file:
    for linha in file:
        wordsline = linha.split()
        for word in wordsline:
            if word in words:
                continue
            else:
                words.append(word)

with open("No-repeat-leipzig100k.txt", "w") as arq:
    for word in words:
        arq.write(word + "\n")
