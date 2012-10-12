#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int abreArquivo(FILE **arquivo, char caminho[]);
void fechaArquivo(FILE *arquivo);

int abreArquivo (FILE **arquivo, char caminho[])
{
/*
			Abre/Cria um arquivo binário no caminho Projeto/Files/"caminho".
*/
	int tentativas = 0;
	char path[60];
	strcpy(path, "../Files/");
	strcat(path, caminho);
	while (tentativas < 10)
	{
		*arquivo = fopen(path, "rt+");
		if (*arquivo != NULL)
		{
			printf("\nCriou arquivo...");
			getchar();
			return(1);
		}
		tentativas++;
	}
	getchar();
	return (0);
}

void fechaArquivo(FILE *arquivo)
{
/*
		Fecha arquivo.
*/
	if (arquivo != NULL)
	{
		fclose(arquivo);
		return;
	}
}
