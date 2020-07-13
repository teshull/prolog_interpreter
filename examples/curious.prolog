
top :- test(a(X,Y)).

test(X) :- sing(X).
sing(a(b,c)).


isInteger(0).
isInteger(Y) :- isInteger(X), (Y is X + 1).
