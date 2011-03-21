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

* Homogeneous traversals.
* Path based traversals, based on simple and complex path expressions.
* Pattern matching traversals.
* Search: A*, shortest path, et.c.
* Combinations of the above.

Design notes
------------

Possible start entities:
* Node
* Relationship - bidirectional?
* Path - bidirectional?
* Traversal result
* Index hits


Requirements:

* No user defined callbacks
* Define everything through descriptions - cover all common cases
* Possibly leave an "escape hatch" (callback based?) for "advanced" stuff.
* Optionally be able to construct stateful (start position) descriptions
  from entities.
* Path filtering.


Traversal positioning is:

1. Where I am.
2. How to continue from here.
3. (optionally) carried state.


Traversal is:

1. Positioning
2. Expand candidates
3. Order candidates
4. Evaluate candidates to create next position
5. Repeat

