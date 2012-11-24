#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../CFiles/CLib/libFiles.h"

int main(int argc, char* argv[])
{
   if (argc != 2)
    {
        //exit(1);
    }
    printf("\nArgumento: %d", atoi(argv[1]));
    if (atoi(argv[1]) == 1)
    {
        verificaLogin();
    }
    else if (atoi(argv[1]) == 0)
    {
        criaXML();
    }
    return (0);
}

int abreArquivo (FILE **arquivo, char caminho[], char mode[])
{
	int tentativas = 0;
	char path[60]="";
	strcpy(path, "Files/");
	strcat(path, caminho);
	while (tentativas < 10)
	{
		*arquivo = fopen(path, mode);
		if (*arquivo != NULL)
		{
			printf("\nCriou arquivo... %s", caminho);
			return(1);
		}
		tentativas++;
	}
	exit(1);
}

void fechaArquivo(FILE *arquivo)
{
	if (arquivo != NULL)
	{
		fclose(arquivo);
		return;
	}
}
