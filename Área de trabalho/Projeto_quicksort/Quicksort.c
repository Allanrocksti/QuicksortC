#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define arquivo "alunos.txt"

/*
	Struct com os valores de cada aluno
*/
typedef struct{
	int matricula;
	char nome[100];
	char idade[100];
}Aluno;

/*
	Enum que adiciona a função dos tradicionais valores booleanos
*/
typedef enum{
	true = 1,
	false = 0,
}boolean;

int qtd_alunos(){
 
 	FILE *arq;

	char string_temp[100] = " ";
	char *result;
	int qtd_alunos = 0;

	arq = fopen(arquivo, "r");

	if(arq != NULL){

		while(1){
		
			result = fgets(string_temp, 100, arq);
			
			if(result != NULL)
				qtd_alunos++;
			else
				break;

		}

		fclose(arq);

	}

	return qtd_alunos;

}

/*
Função que insere os dados do arquivo dentro do array de alunos
	
	@Aluno alunos[]: array de Aluno
	@int qtd_alunos: quantidade de alunos

	@return: boolean indicando se houve erro na abertura do arquivo
				true: Abriu corretamente
				false: Erro ao abrir

*/
boolean coletar_alunos(Aluno alunos[], int qtd_alunos){
	
	boolean erro = true;

	FILE *arq;
	char linha[100];

	arq = fopen(arquivo, "r");

	if (arq != NULL){

		for (int i = 0; i < qtd_alunos; i++){
			
			fgets(linha, 100, arq);

			alunos[i].matricula = atoi(strtok(linha, ","));
			strcpy(alunos[i].nome, strtok(NULL, ","));
			strcpy(alunos[i].idade, strtok(NULL, ","));

		}		
		
		fclose(arq);

	}else{
		erro = false;
	}

	return erro;

}

/*
	Estrutura de dados que ordena especificamente o array de alunos por matrícula

	@Aluno alunos[]: array de Aluno
	@int ini_vetor: indice inicial do vetor
	@int fim_vetor: indice final do vetor

*/
void quicksort(Aluno alunos[], int ini_vetor, int fim_vetor){
	int i = ini_vetor;
	int j = fim_vetor;
	Aluno pivo = alunos[(i + j) / 2];
	Aluno aux;

	while(j > i){
		
		while(alunos[i].matricula < pivo.matricula) i++;
		while(alunos[j].matricula > pivo.matricula) j--;

		if(i <= j){
			aux = alunos[i];
			alunos[i] = alunos[j];
			alunos[j] = aux;
			i++;
			j--;
		}

	}

	if(ini_vetor < j) quicksort(alunos, ini_vetor, j);
	if (i < fim_vetor) quicksort(alunos, i, fim_vetor);

}

/*
Função que imprime na tela os dados dentro do array de alunos
	
	@Aluno alunos[]: array de Aluno
	@int qtd_alunos: quantidade de alunos
*/
void print_alunos(Aluno alunos[], int qtd){

	for(int i = 0; i < qtd; i++){

		printf("\n=============== Aluno %d ===============\n", i+1);
		printf("Matricula: %d\n", alunos[i].matricula);
		printf("Nome: %s\n", alunos[i].nome);
		printf("Idade: %s", alunos[i].idade);
	
	}

}

int main(){

	int qtd = qtd_alunos();

	if (qtd > 0){

		Aluno alunos[qtd];
		
		if(coletar_alunos(alunos, qtd) == true){

			quicksort(alunos, 0, qtd-1);
			print_alunos(alunos, qtd);

		}else{
			printf("O arquivo foi corrompido!\n");	
		}
	
	}else{
		printf("Arquivo em branco ou inexistente!\n");
	}

	return 0;

}