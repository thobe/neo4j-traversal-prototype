Traversal API Prototype for Neo4j
=================================

This project is a prototype for a new traversal API for Neo4j.

Design goals include:
* Allowing the same API to be used both for the Embedded Neo4j Graph Database,
  and with the Neo4j Graph Database Server.
* Being able to express the intent of traversals simply without having to
  consider complex details.
* Allow for the traversal engine to optimize traversals from the provided
  traversal declarations.

Traversal modes intended to support:
* Path based traversals, based on simple and complex path expressions.
* Pattern matching traversals.
* Search: A*, shortest path, et.c.
* Combinations of the above.

