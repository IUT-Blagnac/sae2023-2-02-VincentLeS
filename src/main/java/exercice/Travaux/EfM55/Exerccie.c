#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Vérification de la nature du caractère donné
int estUneLettre(int c) {
  if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
    return 1;
  }
  return 0;
}

// Trouve la taille d'une chaine dont on a le
// On incrémente le pointeur jusqu'à atteindre la fin de la chaîne
int tailleChaine(const char texte[]) {
  int taille = 0;
  while (texte[taille] != '\0') {
    taille++;
  }
  return taille;
}

// Fonction qui permet de trouver l'indice de la première occurence d'une lettre
// recherchée dans une string dont on a le pointeur.
// Retourne -1 si non trouvée.
int trouveChar(const char texte[], char c) {
  for (int indiceLettre = 0; texte[indiceLettre] != '\0'; indiceLettre++) {
    if (texte[indiceLettre] == c) {
      return indiceLettre;
    }
  }
  return -1;
}

// Fonction récursive de tri en utilisant l'ordre
// Debut et Fin représentent la partie sur laquelle l'appel à la fonction se
// concentre
void triRapide(char **mots, int debut, int fin, const char ordre[],
               int tailleOrdre) {
  // Condition d'arrêt
  if (debut >= fin) {
    return;
  }

  int pivotIndex = fin;
  int i = debut - 1;

  for (int j = debut; j < fin; j++) {
    int k;
    // Trouver la position du pivot et de l'élément courant dans l'ordre
    int pivotPos = trouveChar(ordre, mots[pivotIndex][0]);
    int currentPos = trouveChar(ordre, mots[j][0]);

    if (currentPos < pivotPos) {
      i++;
      char *temp = mots[i];
      mots[i] = mots[j];
      mots[j] = temp;
    } else if (currentPos == pivotPos) {
      for (k = 1; k < tailleChaine(mots[j]); k++) {
        pivotPos = trouveChar(ordre, mots[pivotIndex][k]);
        currentPos = trouveChar(ordre, mots[j][k]);

        if (currentPos < pivotPos) {
          i++;
          char *temp = mots[i];
          mots[i] = mots[j];
          mots[j] = temp;
          break;
        } else if (currentPos > pivotPos) {
          break;
        }
      }

      if (k == tailleChaine(mots[j])) {
        i++;
        char *temp = mots[i];
        mots[i] = mots[j];
        mots[j] = temp;
      }
    }
  }

  i++;
  char *temp = mots[i];
  mots[i] = mots[pivotIndex];
  mots[pivotIndex] = temp;

  triRapide(mots, debut, i - 1, ordre, tailleOrdre);
  triRapide(mots, i + 1, fin, ordre, tailleOrdre);
}

void solution(char **result, int tailleResult, char *texte, char *ordre,
              int tailleOrdre) {
  int numMot = 0;
  int numLettreCopiee = 0;
  char dernierCaractere = '\0';

  // Allocation de mémoire pour chaque élément de result
  for (int i = 0; i < tailleResult; i++) {
    result[i] = malloc((tailleResult + 1) * sizeof(char));
    if (result[i] == NULL) {
      fprintf(stderr, "Erreur d'allocation de mémoire.\n");
      exit(1);
    }
  }

  // Copie dans la liste de tous les mots du texte
  for (int i = 0; texte[i] != '\0'; i++) {
    if (!estUneLettre(texte[i])) {
      if (estUneLettre(dernierCaractere)) {
        numLettreCopiee = 0;
        numMot++;
      }
    } else {
      result[numMot][numLettreCopiee] = tolower(texte[i]);
      numLettreCopiee++;
    }
    dernierCaractere = texte[i];
  }

  // On met les caractères de l'ordre en minuscule
  for (int i = 0; i < tailleOrdre; i++) {
    ordre[i] = tolower(ordre[i]);
  }

  triRapide(result, 0, numMot - 1, ordre, numMot);
}
