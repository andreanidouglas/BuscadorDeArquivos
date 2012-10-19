#include <stdio.h>
#include <stdlib.h>
#include "../CFiles/CLib/libFiles.h"


int verificaLogin()
{
    FILE *arquivo, *bancoUsuarios;
    char caractere, usuario[20]="", senha[100]="", usuarioBanco[20]="", senhaBanco[100]="", buffer, codigoString[11]="";
    int  i = 0, codigoNumerico=0;

    do
    {
        arquivo=fopen("../Files/login.txt","rt+");
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


    while (!feof(bancoUsuarios))
    {
         i=0;
        do
        {
            buffer = fgetc(bancoUsuarios);
            if (buffer == '#')
                break;
            codigoString[i] = buffer;
            i++;
            codigoNumerico = atoi(codigoString);
        }
        while (buffer != '#' && !feof(bancoUsuarios));
        i=0;
        do
        {
            buffer = fgetc(bancoUsuarios);
            if (buffer == '=')
                break;
            usuarioBanco[i] = buffer;
            i++;
        }while (buffer != '=' && !feof(bancoUsuarios));

        if (!strcmp(usuario, usuarioBanco))
        {
            i=0;
            do
            {
                buffer = fgetc(bancoUsuarios);
                if (buffer == ';')
                    break;
                senhaBanco[i] = buffer;;
                i++;
            }while (buffer != ';' && !feof(bancoUsuarios));
            if (!(strcmp(senha, senhaBanco)))
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
            while ((buffer != ';') && (!feof(bancoUsuarios)))
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
