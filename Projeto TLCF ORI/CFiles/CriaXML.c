#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../CFiles/CLib/libFiles.h"

int criaXML()
{
    FILE     *xmlAutomato=NULL
           , *BancoArquivos=NULL;
    int      i=0;
    char     buffer='\0';
    char     tag[3][100] = {"","",""}
           , tipo[25] = "";


    xmlAutomato = fopen("Files\\Automato.xml", "rb+");
    if (xmlAutomato == NULL)
    {
        abreArquivo(&xmlAutomato, "../Files/Automato.xml", "wt+");
    }
    BancoArquivos = fopen("../Files/bancoArquivos.txt", "rt+");
    if (BancoArquivos == NULL)
    {
        printf("Banco de arquivos nao existe");
        system("Pause");
    }

    buffer = fgetc(xmlAutomato);
    if (buffer == '<')
    {
        //xml ja existente
    }
    else
    {
        //novo xml
        fprintf(xmlAutomato, "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
        fprintf(xmlAutomato, "\n<Automato>");

        fprintf(xmlAutomato, "\n<Alfabeto");
        for (i=0;i<26;i++)
            fprintf(xmlAutomato, " s%d=\"%c\"", i, (char)97+i);
        fprintf(xmlAutomato, "/>");

        fprintf(xmlAutomato, "\n</Automato>");
        while (!feof(BancoArquivos))
        {
            if (verificaRegistroIncluso(&BancoArquivos) == 0)
            {
                do
                {
                    fseek(BancoArquivos, -2*sizeof(char), SEEK_CUR);
                }while ((buffer = fgetc(BancoArquivos))!='\n');
                recuperaRegistros(BancoArquivos, tag, tipo);
                printf("\n%s %s %s %s", &tag[0], &tag[1], &tag[2], tipo);
            }fflush(BancoArquivos);


        }
    }
    fclose(xmlAutomato);
    fclose(BancoArquivos);
    return 0;
}

int verificaRegistroIncluso(FILE **BancoArquivos)
{
    char buffer='\0';
    int validacao=0;
    if (*BancoArquivos == NULL)
        return -1;
    FILE *banco = *BancoArquivos;
    while (!feof(banco) || buffer != ';')
    {
        while (buffer != '$')
        {
            buffer = fgetc(banco);
            if (feof(banco))
                break;
        }
        buffer = fgetc(banco);
        if (buffer == 48 || buffer == 49)
        {
            validacao = buffer - 48;
            buffer = fgetc(banco);
            return validacao;
        }
        else
        {
            return -1;
        }
    }
    return -1;
}



void recuperaRegistros(FILE *BancoArquivos, char tag[][100], char *tipo)
{
    int     i            = 0
          , arrayi       = 0
          , arrayj       = 0;

    char    tagFile[300] = ""
          , buffer='\0';

    i=0;
    do
    {
        buffer = fgetc(BancoArquivos);
    }while (buffer != '#');
    do
    {
        buffer = fgetc(BancoArquivos);
    }while (buffer != '=');

    do
    {
        buffer = fgetc(BancoArquivos);
        if (feof(BancoArquivos) || buffer == '@')
        {
            break;
        }
        tagFile[i] = buffer;
        i++;
    }while (buffer != '@');
    i=0;
    do
    {
        buffer = fgetc(BancoArquivos);
        if (feof(BancoArquivos) || buffer == '$')
        {
            break;
        }
        tipo[i] = buffer;
        i++;
    }while (buffer != '$' || feof(BancoArquivos));

    buffer = fgetc(BancoArquivos);

    i=0;
    for (arrayj=0;arrayj<3;arrayj++)
    {
        for (arrayi=0;arrayi<100;arrayi++)
        {
            if (tagFile[i] == ' ' || tagFile[i] == '\0')
                break;
            tag[arrayj][arrayi] = tagFile[i];
            i++;
        }
        i++;
    }
    do
    {
        buffer = fgetc(BancoArquivos);
    }
    while (buffer != ';');
    fseek(BancoArquivos, -2*sizeof(char), SEEK_CUR);
    //buffer = fgetc(BancoArquivos);
    fputs("1;", BancoArquivos);
    fflush(BancoArquivos);

}

