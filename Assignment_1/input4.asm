    START 1000
    READ N
    MOVER BREG, ='1'
    MOVEM BREG, TR
A   MUL BREG, TR
    MOVER CREG, TR
    COMP CREG, N
    BC LE, A
    MOVEM BREG, RG
    LTORG
    PRINT RG
    STOP
N   DS 1
RG  DS 20
TR  DS 1
    END