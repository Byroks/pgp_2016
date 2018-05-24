//Unter Verwendung der Vorlesung (Logisch II_1 / 27)

:-use_module(library(clpfd)).

%1. ZEROS + ONES == BINARY

solve([Z,E,R,O,S,N,B,I,A,Y]) :-
	[Z,E,R,O,S,N,B,I,A,Y] ins 0..9, Z #\= 0, O #\= 0, B #\= 0,
	all_different([Z,E,R,O,S,N,B,I,A,Y]),
	S + S #= Y + 10*C1,
	C1 + O + E #= R + 10 * C2,
	C2 + R + N #= A + 10 * C3,
	C3 + E + O #= N + 10 * C4,
	C4 + Z #= I + 10 * B,
	label([Z,E,R,O,S,N,B,I,A,Y]).

% => false


%2. ABRA + CADABRA + ABRA + CADABRA = HOUDINI

solve([A,B,R,C,D,H,O,U,I,N]) :-
  [A,B,R,C,D,H,O,U,I,N] ins 0..9, A #\= 0, C #\= 0, H #\= 0,
  all_different([A,B,R,C,D,H,O,U,I,N]),
  A+A+A+A #= I + 10*C1,
  C1 + R+R+R+R #= N + 10 * C2,
  C2 + B+B+B+B #= I + 10 * C3,
  C3 + A+A+A+A #= D + 10 * C4,
  C4 + D+D #= U + 10 * C5,
  C5 + A+A #= O + 10 * C6,
  C6 + C+C #= H,
  label([A,B,R,C,D,H,O,U,I,N]).


% => wird erfolgreich gelöst