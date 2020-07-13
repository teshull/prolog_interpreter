

mortal(X) :- human(X).

human(socrates).


fun(X) :-                      /* an item is fun if */


        red(X),                /* the item is red */


        car(X).                /* and it is a car */


fun(X) :-                      /*  or an item is fun if */


        blue(X),               /* the item is blue */


        bike(X).               /* and it is a bike */


fun(ice_cream).                /* and ice cream is also fun. */

car(vw_beatle).
car(ford_escort).
bike(harley_davidson).
red(vw_beatle).
red(ford_escort).
blue(harley_davidson).
