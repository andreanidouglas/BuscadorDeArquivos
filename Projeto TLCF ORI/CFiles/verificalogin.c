#include <stdio.h>
#include <stdlib.h>

main()
{
  FILE *arquivo;
  char caractere, usuario[20]="", senha[10]="";
  int  i = 0;

  do
  {
    arquivo=fopen("../Files/login.txt","rt");
    if (arquivo == NULL)
        printf("Aguardando arquivo...\n");
  } while (arquivo == NULL);


  while (!feof(arquivo))
  {
         // Recuperando o valor do campo "usuario"
         i = 0;
         do
         {
            caractere = fgetc(arquivo);
            if (caractere != '=' && !feof(arquivo))
            {
                usuario[i] = caractere; i++;
            }
         } while (caractere != '=' && !feof(arquivo));

         // Recuperando o valor do campo "senha"
         i = 0;
         do
         {
            caractere = fgetc(arquivo);
            if (caractere != ';' && !feof(arquivo))
            {
                senha[i] = caractere; i++;
            }
         } while (caractere != ';' && !feof(arquivo));
  }

  printf("\n\nInformacoes recuperadas: \nUsuario: %s \nSenha: %s", usuario, senha);

  fclose(arquivo);

    //chama a função de gerar XML

  getchar();
}


