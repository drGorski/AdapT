# AdapT 

## Design Pattern for Self-Adaptive Smart Contracts

The pattern allows for the ``reuse`` of verification rules and ensures the ``self-adaptability`` of a smart contract to any number of transaction types. It employs a distinct configuration for each transaction type.

## Construction

Verification rule objects are shared among configurations at run-time. Thus the ``redundancy`` of logical conditions was ``eliminated``. 

In consequence, the memory usage is restricted only to one object for each verification rule.

## Implementation

The pattern was implemented in Java language using ``object-oriented`` and ``functional`` programming mechanisms.
