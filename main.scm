;Procedure for Question 1  
(define (del lis atm);Names the procedure del and takes a list and an atom
  (cond       
   ;Nothing left to compare, base case
    ((null? lis) '()) 
   ;First elem of lis and atom match, call del recursively on the rest of lis
    ((eq? (car lis) atm) (del (cdr lis) atm)) 
   ;Otherwise add the first element to the list returned from recursing the rest of lis
    (else (cons (car lis) (del (cdr lis) atm)))))

;Procedure for Question 2
(define (input lis);Names the procedure input, takes a list
  (cond ;Conditional statement
   ;Nothing left to compare, base case
   ((null? lis) '()) 
   ;Otherwise, build list with results from recursing cdr in front and the first elem at end
   (else (append (input (cdr lis)) (list (car lis))))))