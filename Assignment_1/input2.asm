    START 200
    MOVER AREG, A
L1  ADD BREG, B
    PRINT B
    READ ='5'
    PRINT ='15'
    LTORG
    MUL CREG, X
    SUB BREG, ='5'
    DIV CREG LP
LP  STORE X
    ORIGIN L1+30
A   DS 3
    LTORG
    MOVER BREG, X
X   DC 2
B   DS 2
    END