/*Zusammenarbeit mit Benedict Hans*/

leftof(V,W,[V,W|_]).
leftof(V,W,[_|R]) :- leftof(V,W,R).
fourth(F,[_,_,_,F,_]).
pos(V,W,L) :- leftof(V,W,R);leftOf(W,V,R).

solve(G,H,I,J) :-
	X=[_,_,_,_,_],
	/* Auto, Autofarbe, Stadt, Beruf, CD */
	member([ferrari,red,_,_,_],X),
	member([_,silver,_,teacher,_]),
	member([vw,_,_,_,madonna]),
	pos([bmw,_,munich,_,_],[_,blue,_,_,_],X),
	pos([_,_,hamburg,_,_],[_,brown,_,_,_],X), 
	member([_,_,_,butcher,abba]),
	pos([_,_,_,_,beatles],[_,_,_,teacher,_],X),
	member([_,_,cologne,notary,_]),
	pos([_,blue,_,_,_],[smart,_,_,_,_],X),
	member([ford,_,_,carpenter,_]), 
	member([_,green,hamburg,_,_]),
	pos([_,_,berlin,_,_],[_,_,_,baker,_],X),
	fourth([_,_,_,_,eminem],X),
	not(pos([_,_,stuttgart,_,_],[bmw,_,_,_,_])),
	member([G,H,I,J,heino],X),
	write(G,H,I,J),nl.

/*Mit Hilfe von Wikipedia (Prolog-Artikel)*/