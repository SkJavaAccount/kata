# kata
This is just a example of credit, withdraw, print, unit testing...
It has nothing to do with how to tackle this probleme in real life.


To do so in a bank, deposit & withdrawal must run in a DB transaction to garanty the atomocity.
By transaction I mean the DB must execute the balance +/- amount for a given client.
To avoid all conccurency troubles, such the same user connected twice, overriding values,or multi instance...
