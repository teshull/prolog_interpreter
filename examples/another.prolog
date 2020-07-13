
%top(X):- listExample(X).
%
%listExample([1,2,3]).


%?- timer(X is 1).


thing1 :- fail.
thing3.
thing2(foo) :- thing1.
thing2(Y) :- thing4(Y).
thing4(foo) :- thing3.
anotherRule(booBar(tom, X)) :- thing2(X).
ruleExample(X) :- anotherRule(X).

