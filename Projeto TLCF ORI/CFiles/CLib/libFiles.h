#include <stdio.h> 
#include <stdlib.h> 
#include <string.h>

int abreArquivo(FILE *arquivo, char caminho[50]);
void fechaArquivo(FILE *arquivo);

int abreArquivo (FILE *arquivo, char caminho[50])
{
/*
			Abre/Cria um arquivo binário no caminho Projeto/Files/"caminho". 
*/
	int tentativas = 0;
	caminho = strcat("../../Files", caminho);
	while (login == NULL && tentativas < 10)
	{
		login = fopen (caminho, "wb+");
		if (login != NULL)
			return(1);
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
	if (!(arquivo == NULL))
	{
		fclose(arquivo);
		return;
	}
}