fake.
tom.
has(jack,apples).
has(ann,plums).
has(dan,money).
fruit(apples).
fruit(plums).

%TODO rules...
got_it.
something :- got_it.


%order in which i want to get things to work (I think)
?- tom.
?- fruit(plums).
%?- fruit(X).
