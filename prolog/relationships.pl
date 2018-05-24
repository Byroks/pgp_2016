parent(dad, son1).
parent(dad, son2).
parent(dad, daughter1).
parent(dad2, daughter2).

parent(mom, son1).
parent(mom, son2).
parent(mom, daughter1).
parent(mom2, daughter2).

parent(grandmom, mom).
parent(grandmom, dad).
parent(granddad, mom).
parent(granddad, dad).
parent(grandmom2, mom2).
parent(grandmom2, dad2).
parent(granddad2, mom2).
parent(granddad2, dad2).

male(son1).
male(son2).
male(granddad).
male(granddad2).
male(dad).
male(dad2).

female(daughter1).
female(daughter2).
female(mom).
female(mom2).
female(grandmom).
female(grandmom2).

/* Die Familie kommt aus einer texanischen Sekte. Keine weiteren Fragen, bitte. */


mother(X,Y) :- parent(X,Y), female(X).
father(X,Y) :- parent(X,Y), male(X).

husband(X,Y) :- married(X,Y), male(X).
wife(X,Y) :- married(X,Y), female(X).

grandparent(X,Y) :- parent(Z,Y), parent(X,Z).
grandfather(X,Y) :- grandparent(X,Y), male(X).
grandmother(X,Y) :- grandmother(X,Y), female(X).

child(X,Y) :- parent(Y,X).
son(X,Y) :- child(X,Y), male(X).
daughter(X,Y) :- child(X,Y), female(Y).

sibling(X,Y) :- parent(Z,X), parent(Z,Y).
brother(X,Y) :- sibling(X,Y), male(X).
sister(X,Y) :- sibling(X,Y), female(X).

uncle(X,Y) :- brother(Y,Z), parent(Z,X).
aunt(X,Y) :- sister(Y,Z), parent(Z,X).

relative(X,Y) :- 
	parent(X,Y);
	married(X,Y);
	grandparent(X,Y);
	child(X,Y);
	sibling(X,Y);
	uncle(X,Y);
	aunt(X,Y).