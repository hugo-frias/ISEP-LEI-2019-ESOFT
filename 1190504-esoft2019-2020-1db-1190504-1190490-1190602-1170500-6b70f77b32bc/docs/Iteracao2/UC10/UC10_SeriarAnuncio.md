



# UC10 - Seriar Anuncio


## Formato Breve

O colaborador de organização inicia pedido de seriação(manual). O sistema mostra a lista de anuncios. O colaborador escolhe um. O sistema mostra a lista de colaboradores da organização do colaborador. O colaborador seleciona outros colaboradores para participarem no processo de seriação. O sistema mostra a lista de candidaturas. O colaborador organiza/classifica as candidaturas de acordo com o regimento aplicável. O sistema valida e apresenta as classificações das candidaturas feitas pelo colaborador pedindo que confirme. O colaborador de organização confirma.O sistema regista as classificações das candidaturas, tal como a data em que este processo ocorreu e seus participantes e informa o colaborador de organização do sucesso da operação.

## SSD
![UC10_SSD.svg](UC10_SSD.svg)

## Formato Completo

### Ator principal

Colaborador de Organização

### Partes interessadas e seus interesses

* **Colaborador de Organização**: Pretende efetuar seriação dos candidatos a uma tarefa em nome de uma determinada organização.
* **Freelancers**: Pretende ser escolhido para fazer uma determinada tarefa.
* **T4J**: Pretende que a plataforma permita classificar/ordenar candidatos a uma tarefa.
* **Organizacao**: Pretende fazer a seriação dos candidatos para realizarem a tarefa possuida por esta.

### Pré-condições

Deve haver candidaturas ao anuncio pretendido de ser seriado.

### Pós-condições

A classificação das candidaturas e outros dados associados com o processo de seriação são registados no sistema.

## Cenário de sucesso principal (ou fluxo básico)

1. O colaborador de organização inicia pedido de seriação(manual).
2. O sistema mostra a lista de anuncios publicados pelo colaborador disponiveis a serem seriados(manualmente) pelo mesmo.
3. O colaborador escolhe um anuncio.
4. O sistema pede confirmação ao colaborador se pretende adicionar outros colaboradores de sua organização para participar no processo de seriação.
5. **Se o colaborador não confirma passa para o passo 9**.
6. O sistema mostra a lista de colaboradores de organização da organização do colaborador.
7. O colaborador de organizacão escolhe um colaborador para participar no processo.
8. **O passo 7 repete-se até serem selecionados todos os colaboradores pretendidos.**
9. O sistema mostra a lista de candidaturas do anuncio escolhido.
10. O colaborador de organização escolhe uma candidatura da lista.
11. O sistema solicita ao colaborador de organização a classificação da candidatura escolhida.
12. O colaborador de organização atribui a classificação pretendida da candidatura (de 1 até ao numero de candidaturas).
13. **Os passos 10 a 12 repetem-se até todas as candidaturas possuirem uma classificação.**
14. O sistema valida e apresenta as classificações de cada candidatura ao colaborador, pedindo confirmação.
15. O colaborador de organização confirma.
16. O sistema regista as classificações de cada candidatura tal como a data em que este processo ocorreu e seus participantes e informa o colaborador de organização do sucesso da operação.

### Extensões (ou fluxos alternativos)

*a. O colaborador de organização solicita o cancelamento do processo de seriação.
> O caso de uso termina.

2a. O sistema deteta que a lista de anuncios possiveis de ser seriados manualmente pelo colaborador está vazia.
> O caso de uso termina.

3a. O sistema deteta que o colaborador de organização não tem acesso ao processo de seriação do anuncio escolhido (ex: não foi este que a publicou).
> O caso de uso termina.

6a. O sistema deteta que a lista de colaboradores está vazia.
> 1. O sistema informa o colaborador desse facto.
> 2. O sistema avança para o passo 9.

9a. O sistema deteta que a lista de candidaturas está vazia.
> O caso de uso termina.

14a. O sistema deteta que as classificações não estão feitas de acordo com o regimento aplicável.
> 1. O sistema informa o colaborador de organização desse facto.
> 2. O sistema permite a alteração (passo 4)
>
	>  2a. O colaborador não altera as classificações das candidaturas. O caso de uso termina.

14b. O sistema deteta que existem candidaturas com a mesma classificação
> 1. O sistema informa o colaborador de organização desse facto.
> 2. O sistema permite a alteração (passo 2)
>
	>  2a. O colaborador não altera as classificações da lista. O caso de uso termina.

15a. O colaborador de organização não confirma.
> O sistema permite a alteração da classificação da lista.


### Requisitos especiais
-

### Lista de Variações de Tecnologias e Dados
-

### Frequência de Ocorrência
-

### Questões em aberto


* Haverá um minimo de candidatos para a seriação poder ser realizada?
* Existe um minimo de colaboradores participantes para a seriação poder ser realizada?
* Este caso de uso só pode ser iniciado por colaboradores que tenham gerado anúncios?
* Qual a frequência de ocorrência deste caso de uso?
* È realmente necessário classificar todas as candidaturas? Ou haverá possibilidade de por exemplo, fazer só o top 3.
* Poderá haver candidaturas com a mesma classificação (empate)? Se sim, haverá critério de desempate?


## 2. Análise OO

### Excerto do Modelo de Domínio Relevante para o UC

![UC10_MD.svg](UC10_MD.svg)

## 3. Design - Realização do Caso de Uso

### Racional


| Fluxo Principal | Questão: Que Classe... | Resposta  | Justificação  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. O colaborador de organização inicia pedido de seriação(manual).	 |	... interage com o utilizador? | SeriarAnuncioUI   |  Pure Fabrication, pois não se justifica atribuir esta responsabilidade a nenhuma classe existente no Modelo de Domínio. |
|  		 |	... coordena o UC?	| SeriarAnuncioController | Controller    |
|  		 |	... cria instância de Seriacao | Anuncio | Creator (Regra1)   |
|  		 |	... conhece a organização do colaborador?	| RegistoOrganizacoes | HC/LC |
|||Organização | IE: A organização conhece os seus colaboradores |
||| Colaborador | IE: conhece os seus dados (e.g email)
||conhece o utilizador/gestor a utilizar o sistema?|SessaoUtilizador | IE: documentação do componente de gestão de utilizadores.
| 2. O sistema mostra a lista de anuncios publicados pelo colaborador disponiveis a serem seriados(manualmente) pelo colaborador.		 |...conhece todos os anuncios disponiveis? |  RegistoAnuncios | HC/LC|
||...tem conhecimento dos anuncios disponiveis **a serem seriados pelo colaborador**|RegistoAnuncios|IE: RegistoAnuncios conhece todos os anuncios, e, como tal, todos os anuncios publicados pelo colaborador.
| 3. O Colaborador escolhe um anuncio 	  | |
| 4. O sistema pede confirmação ao colaborador se pretende adicionar outros colaboradores de sua organização para participar no processo de seriação.
| 5. Se o colaborador não confirma  passa para o passo 9.		 |                          |
| 6.  O sistema mostra a lista de colaboradores de organização da organização do colaborador.		 |		... tem conhecimento sobre outros colaboradores da organização do colaborador? | RegistoOrganizacoes | HC/LC |
|||Organização | IE: A organização conhece os seus colaboradores |
|||ListaColaborador| HC/LC|
| 7.  O colaborador de organizacão escolhe um colaborador para participar no processo.		 | ...guarda o colaborador escolhido?|   Seriacao | IE: instância criada no passo 1: possui uma lista de colaboradores participantes |
| 8.  **O passo 7 repete-se até serem selecionados todos os colaboradores pretendidos.**| |
| 9. O sistema mostra a lista de candidaturas do anuncio escolhido.	 |		...tem conhecimento sobre a lista de candidaturas do anuncio escolhido?  |   ListaCandidaturas | HC/LC    |
| 10. O colaborador de organização escolhe uma candidatura da lista.		 | ...guarda a candidatura escolhida?|  Anuncio |  IE: No modelo de dominio, Anuncio recebe candidaturas.                           |
| 11.  O sistema solicita ao colaborador de organização a classificação da candidatura escolhida.		 | 
| 12.  O colaborador de organização atribui a classificação pretendida da candidatura (de 1 até ao numero de candidaturas).	  | ...guarda a classificação? | Candidatura|IE: No MD, classificação é referente a Candidatura|
| |...valida a classificação atribuida(validacão local)? | Candidatura|IE: No MD, classificação é referente a Candidatura|
|| ...valida a classificação atribuida(validação global)? | ListaCandidaturas|IE: ListaCandidatura possui atributos gerais, tais como o numero máximo de posições.|
| 13.  **Os passos 10 a 12 repetem-se até todas as candidaturas possuirem uma classificação.**
| 14.  O sistema valida e apresenta as classificações de cada candidatura ao colaborador, pedindo confirmação.| ...valida os dados da Seriacao(validação local)? | Seriacao|IE: Seriacao possui os seus próprios dados|
|| ...valida os dados da Seriacao(validação global)?| RegimentoAplicavel | IE: No MD, Seriacao aplica um regimento||
| 15.  O colaborador de organização confirma.		 | |   | |
| 16.  O sistema regista as classificações de cada candidatura tal como a data em que este processo ocorreu e seus participantes e informa o colaborador de organização do sucesso da operação.|  ...guarda a Seriacao realizada?| ListaSeriacao| HC/LC |
|| ...conhece a data em que o processo ocorreu? | Date |IE: instância criada no passo 1|
|| ... notifica o utilizador? |SeriarAnuncioUI ||


## Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:
 
* Candidatura
* Anuncio
* Seriacao
* Date
* RegimentoAplicavel

Outras classes de software (i.e. Pure Fabrication) identificadas:

* ListaSeriacao
* ListaCandidaturas
* RegistoOrganizacoes
* RegistoAnuncios 
* SeriarAnuncioUI
* SeriarAnuncioController
 
Outras classes de sistemas/componentes externos:

* SessaoUtilizador

## Diagrama de Sequência ##

**SD sem refs**


![UC10_SD.svg](UC10_SD.svg)


**SD com refs**

![UC10_SDComRefs.svg](UC10_SDComRefs.svg)

## Diagrama de Classes ##

![UC10_CD.svg](UC10_CD.svg)
