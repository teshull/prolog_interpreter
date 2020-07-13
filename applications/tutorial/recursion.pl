
on_route(rome).

on_route(Place):-
    move(Place,Method,NewPlace),
    on_route(NewPlace).

move(home,taxi,halifax).
move(halifax,train,gatwick).
move(gatwick,plane,rome).

parent(john,paul).             /* paul is john's parent */  
     
parent(paul,tom).              /* tom is paul's parent */

parent(tom,mary).              /* mary is tom's parent */       
    
ancestor(X,Y):- parent(X,Y).   /* someone is your ancestor if there are your parent */
