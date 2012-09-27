#include <stdio.h> 
#include "CLib/libFiles.h"

typedef struct
{
	char     login[10];
	char     senha[100];
	char     nome[60];
	char     sobrenome[100];
	int      id; //AUTO INCREMENT
	int		 status;
} infLogin;

int removeRegistro(*FILE arquivo, infLogin usuario, int id);

int main()
{
	int retorno;
	FILE *login;
	infLogin usuario;
	
	retorno = abreArquivo(login, "login.gdr");
	if(!retorno)
		exit(1);
	fechaArquivo(login);
	return (0);
}

int removeRegistro(*FILE arquivo, infLogin usuario, int id)
{
	while (!feof(arquivo) && usuario.status == 1)
	{
		fread(&usuario, sizeof(usuario), 1, arquivo);
		if (!feof(arquivo) && id == usuario.id)
		{
			usuario.status = 0;
			fwrite(&usuario, sizeof(usuario), 1, arquivo);
			return (1);
		}
	}
	return (0);
}