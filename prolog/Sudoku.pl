//Zusammenarbeit mit Paul Jonas Zietlow und Enno von Hartmann 

:-use_module(library(clpfd)).
% —------------------------------------------------------------------------

% Sudoku(Puzzle) :- solve the given Sudoku puzzle and print the
%    problem statement as well as the solution to the standard output
%   (list-of-integers, partially instantiated)
%
alu(R):-all_different(R).

getIndex([A|B],J,Res):-0 is J, Res = A; getIndex(B,J-1,Res).

testeZeilen(Puzzle):-
  testeZeile(Puzzle,0),
  testeZeile(Puzzle,1),
  testeZeile(Puzzle,2),
  testeZeile(Puzzle,3),
  testeZeile(Puzzle,4),
  testeZeile(Puzzle,5),
  testeZeile(Puzzle,6),
  testeZeile(Puzzle,7),
  testeZeile(Puzzle,8).

testeZeile(Puzzle,J):-
  getIndex(Puzzle,9*J,A),
  getIndex(Puzzle,9*J+1,B),
  getIndex(Puzzle,9*J+2,C),
  getIndex(Puzzle,9*J+3,D),
  getIndex(Puzzle,9*J+4,E),
  getIndex(Puzzle,9*J+5,F),
  getIndex(Puzzle,9*J+6,G),
  getIndex(Puzzle,9*J+7,H),
  getIndex(Puzzle,9*J+8,I),
  alu([A,B,C,D,E,F,G,H,I]).

testeSpalten(Puzzle):-
  testeSpalte(Puzzle,0),
  testeSpalte(Puzzle,1),
  testeSpalte(Puzzle,2),
  testeSpalte(Puzzle,3),
  testeSpalte(Puzzle,4),
  testeSpalte(Puzzle,5),
  testeSpalte(Puzzle,6),
  testeSpalte(Puzzle,7),
  testeSpalte(Puzzle,8).

testeSpalte(Puzzle,J):-
  getIndex(Puzzle,0*9+J,A),
  getIndex(Puzzle,1*9+J,B),
  getIndex(Puzzle,2*9+J,C),
  getIndex(Puzzle,3*9+J,D),
  getIndex(Puzzle,4*9+J,E),
  getIndex(Puzzle,5*9+J,F),
  getIndex(Puzzle,6*9+J,G),
  getIndex(Puzzle,7*9+J,H),
  getIndex(Puzzle,8*9+J,I),
  alu([A,B,C,D,E,F,G,H,I]).

testeBloecke(Puzzle):-
  testeBlock(Puzzle,0),
  testeBlock(Puzzle,1),
  testeBlock(Puzzle,2),
  testeBlock(Puzzle,3),
  testeBlock(Puzzle,4),
  testeBlock(Puzzle,5),
  testeBlock(Puzzle,6),
  testeBlock(Puzzle,7),
  testeBlock(Puzzle,8).

testeBlock(Puzzle,J):-
  getIndex(Puzzle,((J // 3)*3)*9  +((J mod 3)*3)  ,A),
  getIndex(Puzzle,((J // 3)*3)*9  +((J mod 3)*3+1),B),
  getIndex(Puzzle,((J // 3)*3)*9  +((J mod 3)*3+2),C),
  getIndex(Puzzle,((J // 3)*3+1)*9+((J mod 3)*3)  ,D),
  getIndex(Puzzle,((J // 3)*3+1)*9+((J mod 3)*3+1),E),
  getIndex(Puzzle,((J // 3)*3+1)*9+((J mod 3)*3+2),F),
  getIndex(Puzzle,((J // 3)*3+2)*9+((J mod 3)*3)  ,G),
  getIndex(Puzzle,((J // 3)*3+2)*9+((J mod 3)*3+1),H),
  getIndex(Puzzle,((J // 3)*3+2)*9+((J mod 3)*3+2),I),
  alu([A,B,C,D,E,F,G,H,I]).


sudoku(Puzzle) :-
   printPuzzle(Puzzle), nl,
   Puzzle ins 1..9,
   testeZeilen(Puzzle),
   testeSpalten(Puzzle),
   testeBloecke(Puzzle),
   label(Puzzle),
   %YOUR CODE GOES HERE
   printPuzzle(Puzzle),
   fail.
% —-------------------------------------------------------
printPuzzle([]).
printPuzzle(Xs) :- nl,
   printBand(Xs,Xs1),
   write('--------+---------+--------'), nl,
   printBand(Xs1,Xs2),
   write('--------+---------+--------'), nl,
   printBand(Xs2,_).

printBand(Xs,Xs3) :-
   printRow(Xs,Xs1), nl,
   write('        |         |'), nl,
   printRow(Xs1,Xs2), nl,
   write('        |         |'), nl,
   printRow(Xs2,Xs3), nl.

printRow(Xs,Xs3) :-
   printTriplet(Xs,Xs1), write(' | '),
   printTriplet(Xs1,Xs2), write(' | '),
   printTriplet(Xs2,Xs3).

printTriplet(Xs,Xs3) :-
   printElement(Xs,Xs1), write('  '),
   printElement(Xs1,Xs2), write('  '),
   printElement(Xs2,Xs3).

printElement([X|Xs],Xs) :- var(X), !, write('.').
printElement([X|Xs],Xs) :- write(X).

printCounter(0) :- !, write('No solution'), nl.
printCounter(1) :- !, write('1 solution'), nl.
printCounter(K) :- write(K), write(' solutions'), nl.

% —-------------------------------------------------------

run(N) :- puzzle(N,P), sudoku(P).

puzzle(1,P) :-
   P = [_,_,4,8,_,_,_,1,7,
  6,7,_,9,_,_,_,_,_,
  5,_,8,_,3,_,_,_,4,
        3,_,_,7,4,_,1,_,_,
  _,6,9,_,_,_,7,8,_,
  _,_,1,_,6,9,_,_,5,
  1,_,_,_,8,_,3,_,6,
  _,_,_,_,_,6,_,9,1,
  2,4,_,_,_,1,5,_,_].
  
%9  3  4 | 8  2  5 | 6  1  7
%        |         |
%6  7  2 | 9  1  4 | 8  5  3
%        |         |
%5  1  8 | 6  3  7 | 9  2  4
%--------+---------+------—
%3  2  5 | 7  4  8 | 1  6  9
%        |         |
%4  6  9 | 1  5  3 | 7  8  2
%        |         |
%7  8  1 | 2  6  9 | 4  3  5
%--------+---------+------—
%1  9  7 | 5  8  2 | 3  4  6
%        |         |
%8  5  3 | 4  7  6 | 2  9  1
%        |         |
%2  4  6 | 3  9  1 | 5  7  8

puzzle(2,P) :-
   P = [3,_,_,_,7,1,_,_,_,
  _,5,_,_,_,_,1,8,_,
  _,4,_,8,_,_,_,_,_,
  _,_,6,2,_,_,3,_,_,
  _,_,1,_,5,_,8,_,_,
  _,_,3,_,_,8,2,_,_,
        _,_,_,_,_,3,_,4,_,
  _,6,4,_,_,_,_,7,_,
  _,_,_,9,6,_,_,_,1].

%3  8  9 | 5  7  1 | 4  6  2
%        |         |
%6  5  7 | 4  3  2 | 1  8  9
%        |         |
%1  4  2 | 8  9  6 | 7  3  5
%--------+---------+------—
%8  7  6 | 2  1  9 | 3  5  4
%        |         |
%4  2  1 | 3  5  7 | 8  9  6
%        |         |
%5  9  3 | 6  4  8 | 2  1  7
%--------+---------+------—
%9  1  5 | 7  2  3 | 6  4  8
%        |         |
%2  6  4 | 1  8  5 | 9  7  3
%        |         |
%7  3  8 | 9  6  4 | 5  2  1