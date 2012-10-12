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
	char     cpf[13];
	int      especial;
} infLogin;

int criaRegistro(FILE **arquivo, infLogin usuario, int id);

int criaRegistro(FILE **arquivo, infLogin usuario, int id)
{
    char buffer[10];
    int i;
    fseek(*arquivo, 0L, SEEK_SET);
    for (i=0;i<10;i++)
    {
        if (!feof(*arquivo))
        {
            buffer[i] = fgetc(*arquivo);
            if(buffer[0] != '<')
            {
                if (feof(*arquivo))
                {
                    fprintf(*arquivo, "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?> \n");
                    fprintf(*arquivo, "<CADASTRO>");
                    fprintf(*arquivo, "\n</CADASTRO>");
                    break;
                }
            }
        }
    }
    {
        fseek(*arquivo, 0L, SEEK_END);
        fseek(*arquivo, -11 * sizeof(buffer), SEEK_CUR);
        fprintf(*arquivo, "\n");
        fprintf(*arquivo, "\n<LOGIN id = \"%d\">", id);
        fprintf(*arquivo, "\n<username>\n%s\n</username>", usuario.login);
        fprintf(*arquivo, "\n<password>\n%s\n</password>", usuario.senha);
        fprintf(*arquivo, "\n<nome>\n%s\n</nome>", usuario.nome);
        fprintf(*arquivo, "\n<sobrenome>\n%s\n</sobrenome>", usuario.sobrenome);
        fprintf(*arquivo, "\n<status>\n%d\n</status>", 1);
        fprintf(*arquivo, "\n<cpf>\n%s\n</cpf>", usuario.cpf);
        fprintf(*arquivo, "\n<especial\n%d\n</especial>", usuario.especial);
        fprintf(*arquivo, "\n</LOGIN>");
        return (1);
    }
}


