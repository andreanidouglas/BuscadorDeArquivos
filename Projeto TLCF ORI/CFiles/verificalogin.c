#include <stdio.h>
#include <stdlib.h>
#include "../CFiles/CLib/libFiles.h"


int verificaLogin()
{
    FILE *arquivo, *bancoUsuarios;
    char caractere, usuario[20]="", senha[100]="", usuarioBanco[20], senhaBanco[100], buffer;
    int  i = 0;

    do
    {
        arquivo=fopen("../Files/login.txt","rt");
        if (arquivo == NULL)
            printf("Aguardando arquivo...\n");
    }
    while (arquivo == NULL);


    while (!feof(arquivo))
    {
        // Recuperando o valor do campo "usuario"
        i = 0;
        do
        {
            caractere = fgetc(arquivo);
            if (caractere != '=' && !feof(arquivo))
            {
                usuario[i] = caractere;
                i++;
            }
        }
        while (caractere != '=' && !feof(arquivo));

        // Recuperando o valor do campo "senha"
        i = 0;
        do
        {
            caractere = fgetc(arquivo);
            if (caractere != ';' && !feof(arquivo))
            {
                senha[i] = caractere;
                i++;
            }
        }
        while (caractere != ';' && !feof(arquivo));
    }
    char modef[3] = "rt";
    abreArquivo(&bancoUsuarios, "bancoUsuarios.txt", modef);

    i=0;

    while (!feof(bancoUsuarios))
    {

        do
        {
            buffer = fgetc(bancoUsuarios);
            usuarioBanco[i] = buffer;
            i++;
        }while (buffer != '=' && !feof(bancoUsuarios));

        if (usuarioBanco == usuario)
        {
            i=0;
            do
            {
                senhaBanco[i] = buffer;
            }while (buffer != ';' && !feof(bancoUsuarios));
            if (senhaBanco == senha)
            {
                fputs("1@", arquivo);
                return (1);
            }
            else
            {
                fputs("0@", arquivo);
                return (0);
            }
        }
        else
        {
            while (buffer != ';' || !feof(bancoUsuarios))
            {
                buffer = fgetc(bancoUsuarios);
            }
        }
    }
    if (feof(arquivo))
    {
        fputs("2@", arquivo);
        return (2);
    }
    fclose(arquivo);
    getchar();
    return (0);
}
