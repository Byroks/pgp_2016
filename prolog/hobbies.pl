person([andreas,bernd,claudia,doris,emil,felix,gustav,helga,ines,joerg,karin,ludwig,marta,natalie,olaf,paula,rita,sabine,timo,ulrich,volker,walter,xenia]).
isPerson(X) :- person(Persons),member(X,Persons).

male([andreas,bernd,emil,felix,gustav,joerg,ludwig,olaf,timo,ulrich,volker,walter]).
female([claudia,doris,helga,ines,karin,marta,natalie,rita,sabine,xenia]).

isMale(X) :- isPerson(X),male(Males),member(X,Males).
isFemale(Y) :- isPerson(Y),female(Females),member(Y,Females).

differentValues(A,B) :- A\=B.

personsHobbies(andreas,[climbing,electronics,gambling,juggling,knitting,puzzles,skateboarding]).
personsHobbies(bernd,[archery,gambling,magic,puzzles,skateboarding]).
personsHobbies(claudia,[dancing,juggling,knitting,nordic-walking,origami]).
personsHobbies(doris,[bowling,climbing,electronics,ice-skating,origami]).
personsHobbies(emil,[dancing,football,hunting,juggling,lacrosse,origami,skateboarding]).
personsHobbies(felix,[archery,electronics,football]).
personsHobbies(gustav,[electronics,magic,nordic-walking]).
personsHobbies(helga,[dancing,ice-skating,knitting,nordic-walking]).
personsHobbies(ines,[bowling,football,gambling,climbing, ice-skating,juggling,origami,puzzles]).
personsHobbies(joerg,[bowling,climbing,football,gambling,hunting,skateboarding]).
personsHobbies(karin,[climbing,dancing,ice-skating,juggling,skateboarding]).
personsHobbies(ludwig,[archery,dancing,knitting,nordic-walking,origami]).
personsHobbies(marta,[dancing,ice-skating,magic,puzzles]).
personsHobbies(natalie,[electronics,juggling]).
personsHobbies(olaf,[gambling,hunting,lacrosse,magic,skateboarding]).
personsHobbies(paula,[archery,hunting,ice-skating,knitting,nordic-walking,puzzles]).
personsHobbies(rita,[dancing,electronics,football,hunting,skateboarding]).
personsHobbies(sabine,[dancing,ice-skating,knitting]).
personsHobbies(timo,[bowling,climbing,electronics,football,gambling,hunting,skateboarding]).
personsHobbies(ulrich,[archery,juggling,magic,puzzles]).
personsHobbies(volker,[electronics,football,hunting,lacrosse,origami]).
personsHobbies(walter,[climbing,dancing,ice-skating,magic]).
personsHobbies(xenia,[bowling,electronics,ice-skating,knitting, climbing,nordic-walking,puzzles]).


personHasHobby(X,Y) :- isPerson(X),personsHobbies(X,Hobbies),member(Y,Hobbies).
