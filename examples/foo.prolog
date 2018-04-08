fake.
tom.
has(jack,apples).
has(ann,plums).
has(dan,money).
fruit(apples).
fruit(plums).
compoundAtom(anotherRule(awesome)).

%TODO rules...
%got_it.
%something :- got_it.

weirdRule(X).


%order in which i want to get things to work (I think)
%?- tom.
%?- fruit(plums).
%?- has(dan, money).
%?- fruit(X).
%?- something.
%?- compoundAtom(X).
%?- fruit(X).

?- weirdRule(Tom).
?- weirdRule(tom).
