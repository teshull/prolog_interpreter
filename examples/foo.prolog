fake.
tom.
has(jack,apples).
has(ann,plums).
has(dan,money).
fruit(apples).
fruit(plums).
compoundAtom(anotherRule(awesome)).

%TODO rules...
easyFact.
easyRule :- easyFact.

weirdFact(X).

thing1.
anotherRule(potatoes) :- thing1.
ruleExample(X) :- anotherRule(X).

%order in which i want to get things to work (I think)
%?- tom.
%?- fruit(plums).
%?- has(dan, money).
%?- fruit(X).
%?- something.
%?- compoundAtom(X).
%?- fruit(X).

%?- weirdFact(Tom).
%?- weirdFact(tom).

%?- ruleExample(Tom).

factOne.
factTwo :- falseFact.
factTwo.
compoundRule :- factOne, factTwo.

trueFact.
orRule :- trueFact ; falseFact.
orRule2 :- falseFact; trueFact.

%?- compoundRule.
%?- factTwo.
%?- easyRule.

%?- orRule.
%?- orRule2.

numberFact(10).

%?- numberFact(10).

?- 10 + 10.
