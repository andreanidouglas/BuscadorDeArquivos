#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../CFiles/CLib/libFiles.h"

int main()
{
    verificaLogin();
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
			printf("\nCriou arquivo...");
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


int criaUsuario(FILE **arquivo)
{
    FILE *bancoUsuarios, *login;
    char buffer;
    abreArquivo(&bancoUsuarios, "bancoUsuarios.txt", "wt+");
    abreArquivo(&login, "login.txt", "rt+");

    while (!feof(login))
    {
        buffer = fgetc(login);
        fputc(buffer, bancoUsuarios);
        return (1);
    }
    return (0);
}
