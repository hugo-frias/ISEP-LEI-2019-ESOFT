Engenharia	de	Software
2019-2020
Plataforma de	Outsourcing	de	Tarefas
Iteração	3
1 Enunciado
1.1 Respostas	a	questões	em	aberto
1. Aquando	 da publicação	 de	 uma tarefa,	 deve ser	 gerado	 para	 o	 anúncio	
resultante um identificador único	global a	todo	o	sistema.
2. Relativamente	aos	períodos	constantes	num	anúncio,	esclarece-se	o	seguinte:
2.1. O	 período	 de	 publicitação	 compreende	 total	 ou	 parcialmente	 o	 período	
de	apresentação	de	candidaturas.
2.2. O	período	de	apresentação	de	candidaturas	não	pode	iniciar-se	antes	do	
período	de	publicitação	do	anúncio;
2.3. O	 período	 de	 apresentação	 de	 candidaturas pode	 terminar	 depois	 do	
período	de	publicitação	do	anúncio;
2.4. O período	 de	 seriação	 e	 decisão	 de	 atribuição	 da	 tarefa é	 sempre	
posterior	ao	término	dos	períodos	de	publicitação	e	de	apresentação	de	
candidaturas.
2.5. Os	 vários	 períodos	 são	 especificados	 sempre	 em	 dias	 completos,	isto	 é,	
não	 compreendem	 horas.	 Ou	 seja,	 os	 períodos	 iniciam-se	 sempre	 às	
00h00m	do	dia	inicial e	terminam	às 24h00m	do dia	final.
3. Não	é	permitido	que	o	mesmo	freelancer	efetue	mais	do	que	uma	candidatura	
ao	 mesmo	 anúncio.	 Contudo,	 durante	 o	 período	 de	 apresentação	 de	
candidaturas	previsto	 em	 cada anúncio,	 para	 além	 de	 efetuar	 candidaturas,	
os	freelancers	podem:
3.1. Atualizar	a	informação	das candidaturas previamente	efetuadas por	si;
3.2. Retirar	candidaturas	previamente	efetuadas por	si;
4. No	âmbito	de	um	anúncio,	o processo	de	seriação	de	candidaturas	é	distinto	
do	processo	de	atribuição	da	realização	da	tarefa	ao	freelancer.
4.1. Relativamente	ao	processo	de	seriação,	este	deve	ser	 realizado:	 (i) pelo	
colaborador,	 quando	 assente	 em	 critérios subjetivos (cf.	 descrito	 na	
iteração	 2); ou (ii) automaticamente	 pelo	 sistema,	 quando	 assente	 em	
critérios	objetivos	(e.g.	2º preço	mais	baixo).
4.2. Relativamente	ao	processo	de	atribuição,	este	deve	ser	realizado:	(i)	pelo	
gestor	da	organização	sempre	que	a	atribuição	prevista	no	 regimento	é	
opcional;	ou	(ii)	automaticamente	pelo	sistema,	quando	a	atribuição	está	
especificada	pelo	regimento	como	sendo	obrigatória.
1.2 Novos	Requisitos
Com	 o	 intuito	 de	 garantir	 e/ou	 facilitar	 o	 cumprimento	 dos	 prazos	 constantes	
nos	 anúncios,	 os	 processos	 automáticos	 de	 seriação	 e	 atribuição	 (quando	
possível)	devem	ser	realizados:
• pelo	sistema	de	forma	periódica	(e.g.	às	02h15m	de	cada	dia);	e/ou
• imediatamente	 após	 a	 conclusão	 do	 processo	 de	 seriação	 não	 automático	
realizado	pelo	colaborador.
Quando	 o	 processo	 de	 seriação	 é	 realizado	 pelo	 colaborador,	 este	 deve incluir	
também	uma	justificação	de	suporte	à	classificação	atribuída a	cada	candidatura	
e,	um texto de	conclusão/resumo	do	processo	como	um	todo.
Da conclusão, com	 sucesso, de	 um	 processo	 de	 atribuição	 resulta	 uma	
adjudicação	de	uma	 tarefa	onde	consta:	(i)	a	organização	que	adjudica a	 tarefa;	
(ii)	o	 freelancer	a	quem	é	adjudicada	a realização da tarefa;	 (iii)	a	descrição	da	
tarefa	 adjudicada;	 (iv)	 o	 período	 afeto	 à realização	 da	 mesma; (v)	 o	 valor	
remuneratório aceite	por	ambas	as	partes;	e	(vi)	uma	referência	ao	anúncio	que	
lhe	 deu origem.	Cada	 adjudicação	 deve	ter	 ainda	 um número único sequencial
(por	 ano),	 atribuído pelo	 sistema bem	 como	 a	 data	 em	 que	 a	 adjudicação
ocorreu.
O	 processo	 de	 instalação	 e	 configuração	 do	 sistema deve	 ser	 muito	 simples,	
intuitivo,	rápido	e	acima	de	tudo	adequado	a	pessoas	com	poucos	conhecimentos	
técnicos.
Salienta-se	 ainda	 a	 necessidade	 do sistema	 estar	 preparado	 para	 suportar	
adequadamente picos	 de	 utilização	 elevada	 do	 sistema,	 em	 particular,	 pelos
freelancers.
Por	 fim,	 durante	 a	 utilização	 do	 sistema	 os	 diversos	 utilizadores	 devem	 ter	
facilmente	acesso	a	informação	de	apoio/suporte	à	tarefa	que	estão	a	realizar	no	
momento.