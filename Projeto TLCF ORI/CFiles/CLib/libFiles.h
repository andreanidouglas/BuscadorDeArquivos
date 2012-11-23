#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int abreArquivo (FILE **arquivo, char caminho[], char mode[]);

void fechaArquivo(FILE *arquivo);

int verificaLogin();

int criaXML();

void recuperaRegistros(FILE *BancoArquivos, char tag[][100], char *tipo, char *caminho);

int verificaRegistroIncluso(FILE **BancoArquivos);


