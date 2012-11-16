#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../CFiles/CLib/libFiles.h"

int criaXML()
{
    FILE     *xmlAutomato
           , *BancoArquivos;
    int      i
           , registroValidado;
    char     buffer;
    char     tag[3][100] = {"","",""}
           , tipo[25] = "";


    xmlAutomato = fopen("Files\\Automato.xml", "rb+");
    if (xmlAutomato == NULL)
    {
        abreArquivo(&xmlAutomato, "Automato.xml", "wb+");
    }
    abreArquivo(&BancoArquivos, "bancoArquivos.txt", "rt+");
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

        while (!feof(BancoArquivos))
        {
            if ((buffer = fgetc(BancoArquivos)) == '\n')
                buffer = fgetc(BancoArquivos);
                if(feof(BancoArquivos))
                    break;
            recuperaRegistros(&BancoArquivos, tag, tipo);
            printf("\n%s %s %s %s", &tag[0], &tag[1], &tag[2], tipo);
        }


        fprintf(xmlAutomato, "\n</Automato>");
        fclose(BancoArquivos);


    }
    fclose(xmlAutomato);
    return 0;
}

int recuperaRegistros(FILE **BancoArquivos, char tag[][100], char *tipo)
{
    int     i            = 0
          , arrayi       = 0
          , arrayj       = 0
          , marcadorLido = 0
          , contadorString = 0;

    char    tagFile[300] = ""
          , buffer;
    do
    {
        contadorString++;
       if (feof(*BancoArquivos))
            break;

        if (buffer == '$')
        {
            marcadorLido = fgetc(*BancoArquivos) - 48;
            contadorString++;
            break;
        }
        i++;
        buffer = fgetc(*BancoArquivos);
    }while(!feof(*BancoArquivos));

    printf("\n%d", contadorString);

    if (marcadorLido == 1)
        return 1;
    else
    {
        fseek(*BancoArquivos, -1 * contadorString * sizeof(char) + 1, SEEK_CUR);
        i=0;
        do
        {
            buffer = fgetc(*BancoArquivos);
        }while (buffer != '#');
        do
        {
            buffer = fgetc(*BancoArquivos);
        }while (buffer != '=');

        do
        {
            buffer = fgetc(*BancoArquivos);
            if (buffer == feof(*BancoArquivos) || buffer == '@')
            {
                break;
            }
            tagFile[i] = buffer;
            i++;
        }while (buffer != '@');
        i=0;
        do
        {
            buffer = fgetc(*BancoArquivos);
            if (buffer == feof(*BancoArquivos) || buffer == '$')
            {
                break;
            }
            tipo[i] = buffer;
            i++;
        }while (buffer != '$' || feof(*BancoArquivos));

        fseek(*BancoArquivos, -1*sizeof(char), SEEK_CUR);
        fflush(*BancoArquivos);
        fputs("$1", *BancoArquivos);

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
            buffer = fgetc(*BancoArquivos);
        }
        while (buffer != '\n');
    }
    return 0;
}
