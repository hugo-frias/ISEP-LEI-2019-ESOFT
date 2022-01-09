


# UC13 - Seriar Automaticamente Anuncio


## Formato Breve

O Timer inicia pedido de seria��o na hora definida (02:15h). O sistema verifica todos os anuncios em que o tipo de regimento implica uma seriacao automatica e o periodo de apresentacao de candidaturas e o periodo de publicitacao j� terminou, recolhendo-os. O sistema realiza a seria��o das candidaturas de cada um dos anuncios recolhidos conforme os objetivos de cada regimento. O sistema guarda os resultados da seriacao e adjudica��o tal como a data e hora em que o processo ocorreu.

## SSD
![UC13_SSD.svg](UC13_SSD.svg)

# Formato Completo

### Ator principal

Timer

### Partes interessadas e seus interesses

* **Freelancers**: Pretende ser escolhido para fazer uma determinada tarefa.
* **T4J**: Pretende que a plataforma permita classificar/ordenar candidatos a uma tarefa de forma autom�tica.
* **Organizacao**: Pretende que a sua tarefa seja realizada, e, como tal, que seja realizada a seriacao das candidaturas ao anuncio que esta gerou.

### Pr�-condi��es

Haver pelo menos um anuncio em condi��o de ser seriado automaticamente.

### P�s-condi��es

A classifica��o/ordena��o das candidaturas e outros dados associados com o processo de seria��o autom�tico tal como a adjudica��o, s�o registados no sistema.

## Cen�rio de sucesso principal (ou fluxo b�sico)

1. O timer inicia pedido de seriacao na hora definida.
2. O sistema verifica e recolhe todos os anuncios em condi��es para serem seriados automaticamente.
3. O sistema realiza a seria��o do primeiro anuncio por seriar da lista de acordo com os crit�rios de seu regimento.
4. O sistema realiza a adjudica��o final do anuncio seriado.
5.  O sistema guarda os resultados da seriacao e adjudica��o tal como a data e hora em que o processo ocorreu. 
6. **Os passos 3 a 5 repetem-se at� a lista recolhida n�o ter mais anuncios por seriar**


### Extens�es (ou fluxos alternativos)


2a. O sistema deteta que n�o existem anuncios em condi��es de serem seriados automaticamente.
> O caso de uso termina.

3a. O sistema deteta que n�o tem disponiveis mecanismos para poder realizar a seriacao do anuncio.
> O sistema remove o anuncio e avan�a para o passo seguinte.
> 
4a. O sistema deteta que o tipo de regimento do anuncio implica uma adjudica��o opcional.
> O sistema guarda os resultados da seriacao tal como a data e hora em que o processo ocorreu.
> O sistema avan�a para o passo 6.

### Requisitos especiais
-

### Lista de Varia��es de Tecnologias e Dados
-

### Frequ�ncia de Ocorr�ncia

Na data/hora definida.

### Quest�es em aberto


* Haver� um minimo de candidatos a um determinado anuncio para a seria��o poder ser realizada?
* Poder� haver candidaturas com a mesma classifica��o no final do processo? Se sim, haver� crit�rio de desempate?
* Algu�m tem de ser notificado da conclus�o desta opera��o?
* Caso o sistema n�o tenha disponiveis mecanismos de seria��o para um determinado regimento, alguem tem de ser notificado disto?

## 2. An�lise OO

### Excerto do Modelo de Dom�nio Relevante para o UC

![UC13_MD.svg](UC13_MD.svg)

## 3. Design - Realiza��o do Caso de Uso

### Racional
| Fluxo Principal | Quest�o: Que Classe... | Resposta  | Justifica��o  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1.  O timer inicia pedido de seriacao na hora definida.	 | ...coordena o UC?| SeriarEadjudicarAnuncioTask| Definida no timer.
||... cria inst�ncia de seriacao automatica? | Anuncio | Creator(Regra1)
||..conhece a hora definida? | Plataforma | Creator(Regra1) - Plataforma possui um timer
|||Timer | IE: Timer conhece os seus pr�prios dados
|2. O sistema verifica e recolhe todos os anuncios em condi��es para serem seriados automaticamente.|...conhece todos os anuncios disponiveis? | RegistoAnuncios | HC/LC
||...conhece todos os anuncios que implicam uma seria��o automatica? | RegistoAnuncios| IE e Protected Variation: RegistoAnuncio conhece todos os anuncios e estes possuem uma instancia de RegimentoAplicavel que aplica Protected Variation.
|| ...sabe que anuncios j� terminou o periodo de apresenta��o e publicita��o? | RegistoAnuncios | HC/LC e IE: conhece todos os anuncios e seus dados.
|3.O sistema realiza a seria��o do primeiro anuncio por seriar da lista de acordo com os crit�rios de seu regimento, guardando os resultados da mesma. |...conhece o tipo de regimento e os crit�rios deste que ser�o aplicados? |Anuncio | IE e Protected Variation: Anuncio possui uma inst�ncia de RegimentoAplicavel que aplica Protected Variation
|||RegimentoAplicavel | Protected Variation
|4. O sistema realiza a adjudica��o final do anuncio| ...cria e valida inst�ncia de adjudica��o? | RegistoAdjudicacao |  HC/LC |
|| ...sabe se a adjudica��o � obrigatoria/autom�tica? | RegimentoAplicavel | Protected Variation
|| ...conhece a organiza��o que adjudicou a tarefa? | RegistoOrganizacoes | HC/LC
|| ...conhece a tarefa que originou o anuncio e os seus dados? | Anuncio | IE: Anuncio possui uma tarefa e tem conhecimento de seus pr�prios dados
||...conhece o Id do anuncio? | Anuncio | IE: conhece seus pr�prios dados
|| ...conhece o periodo de realizacao, o valor acordado e o freelancer a ser atribuida a tarefa? | Seriacao | IE: inst�ncia criada no passo 3 contem uma lista de candidaturas ordenada conforme o regimento aplicavel.
| ||Candidatura | IE: possusi os seus pr�prios dados.
|5. O sistema guarda os resultados da seriacao e adjudica��o tal como a data e hora em que o processo ocorreu.|  ...guarda a Seriacao realizada?| Anuncio| Creator(Regra1) |
|| ...guarda a inst�ncia de adjudica��o? | RegistoAdjudicacao | HC/LC
|| ...conhece a data em que o processo ocorreu? | Date |IE: inst�ncia criada no passo 1|
|6. **Os passos 3 a 5 repetem-se at� a lista recolhida n�o ter mais anuncios por seriar**|

## Sistematiza��o ##

 Do racional resulta que as classes conceptuais promovidas a classes de software s�o:
 
* Plataforma
* Adjudicacao
* Candidatura
* Anuncio
* Seriacao
* SeriacaoAutomatica
* Date
* RegimentoAplicavel

Outras classes de software (i.e. Pure Fabrication) identificadas:

* RegistoAdjudicacao
* RegistoAnuncios 
* SeriarEadjudicarAnuncioTask
 
Outras classes de sistemas/componentes externos:

* Timer


## Diagrama de Sequ�ncia ##

**SD**

![UC13_SD.svg](UC13_SD.svg)
![UC13_SDseriarEadjudicarAnuncios.svg](UC13_SDseriarEadjudicarAnuncios.svg)
![SDInstanciarAdjudicacao.svg](SDInstanciarAdjudicacao.svg)


## Diagrama de Classes ##

![UC13_CD.svg](UC13_CD.svg)

![UC13_RegimentoAplicavelItf.svg](UC13_RegimentoAplicavelItf.svg)
