/*
#include <stdio.h>
#include <stdlib.h>

main()
{
	FILE *arquivo;
	char cpf[15], endereco[20], nome[20];

	printf("Entre com os dados\n\n");
	printf("Nome: "); gets(nome);
	printf("Endereco: "); gets(endereco);
	printf("CPF: "); gets(cpf);

	arquivo = fopen("registros.xml", "wt");
	if (arquivo == NULL)
	{
	    printf("\nNao foi possivel criar o arquivo....");
	    exit(1);
	}

	fputs("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?> \n", arquivo);
	fputs("<registros>\n",arquivo);
	fputs("   <registro id=\"1\">\n", arquivo);
	fputs("      <dados cpf=",arquivo);
	fputs("\"",arquivo);
	fputs(cpf,arquivo);
	fputs("\" ",arquivo);
	fputs("endereco=\"",arquivo);
	fputs(endereco,arquivo);
	fputs("\" ",arquivo);
        fputs("nome=\"",arquivo);
	fputs(nome,arquivo);
	fputs("\" />\n",arquivo);
	fputs("   </registro>\n",arquivo);
	fputs("</registros>",arquivo);

	fclose(arquivo);

	printf("\n\nArquivo XML gerado com sucesso...");
}

*/
