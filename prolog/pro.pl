%Calculate the length of a list recursively
size([], 0).
size([_|Tail], Len) :- size(Tail, Y), Len is Y + 1.

%Reverses the elements of a list recursively
reverse([], []).
reverse([Head|Tail], X) :- reverse(Tail, A),append(A, [Head], X).

