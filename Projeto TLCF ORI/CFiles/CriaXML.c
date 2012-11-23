#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../CFiles/CLib/libFiles.h"

int criaXML()
{
    FILE     *xmlAutomato=NULL
           , *BancoArquivos=NULL;
    int      i=0, j=0, k=0, idArquivo=0;
    char     buffer='\0';
    char     tag[3][100] = {"","",""}
           , tipo[25] = ""
           , tagFinal[100]=""
           , caminhoArquivo[100];


    xmlAutomato = fopen("Files/Automato.xml", "wb+");
    if (xmlAutomato == NULL)
    {
        abreArquivo(&xmlAutomato, "Automato.xml", "wt+");
    }
    printf("criou xml...");
    BancoArquivos = fopen("Files/bancoArquivos.txt", "rt+");
    if (BancoArquivos == NULL)
    {
        printf("Banco de arquivos nao existe");

    }


    fprintf(xmlAutomato, "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
    fprintf(xmlAutomato, "\n<Automato>");

    fprintf(xmlAutomato, "\n<Alfabeto");
    for (i=0;i<26;i++)
        fprintf(xmlAutomato, " s%d=\"%c\"", i, (char)97+i);
    fprintf(xmlAutomato, "/>");




    while (!feof(BancoArquivos))
    {
        idArquivo++;
        printf("Incluir novo registro...");
        for(k=0;k<3;k++)
        {
            memset(&tag[k], '\0', 100);
        }
        memset(tipo, '\0',25);
        memset(caminhoArquivo, '\0',100);
        recuperaRegistros(BancoArquivos, tag, tipo, caminhoArquivo);
        fprintf(xmlAutomato, "\n\t<Arquivo id=\"%d\" tipo=\"%s\" caminho=\"Files/%s\">",idArquivo, tipo, caminhoArquivo);

        for (j=0;j<3;j++)
        {
            fprintf(xmlAutomato, "\n\t\t<Palavra id=\"%d\">",j);

            fflush(xmlAutomato);
            printf("\nTAG J: %s", &tag[j]);
            strcpy(tagFinal, &tag[j]);
            for (i=0;i<1000;i++)
            {
                if (tagFinal[i] == '\0')
                    break;
                fprintf(xmlAutomato, "\n\t\t\t<q id=\"%d\" qp=\"q%d\">%c</q>",i,i+1, tagFinal[i]);
                printf("<q%d>%c</q>",i, tagFinal[i]);
            }
            fprintf(xmlAutomato, "\n\t\t</Palavra>");
        }
        fprintf(xmlAutomato, "\n\t</Arquivo>");
        printf("\n%s %s %s %s", &tag[0], &tag[1], &tag[2], tipo);
        fflush(BancoArquivos);
        buffer = fgetc(BancoArquivos);
        if (feof(BancoArquivos))
            break;
    }
    fprintf(xmlAutomato, "\n</Automato>");
    fclose(xmlAutomato);
    fclose(BancoArquivos);
    return 0;
}

void recuperaRegistros(FILE *BancoArquivos, char tag[][100], char *tipo, char *caminho)
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
        if (feof(BancoArquivos))
            return;
    }while (buffer != '#');
    i=0;
    do
    {
        buffer = fgetc(BancoArquivos);
        if (feof(BancoArquivos) || buffer == '=')
        {
            if (feof(BancoArquivos))
                return;
            break;
        }
        caminho[i] = buffer;
        i++;
    }while (buffer != '=');
    i=0;
    do
    {
        buffer = fgetc(BancoArquivos);
        if (feof(BancoArquivos) || buffer == '@')
        {
            if (feof(BancoArquivos))
                return;
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
            if (feof(BancoArquivos))
                return;
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

