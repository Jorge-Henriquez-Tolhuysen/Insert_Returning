INSERT INTO RETURNING

Recientemente, como parte de un desafio, fue necesario interctuar con una base de datos Oracle Database. Parte de la funcionalidad solicitada requeria la implementación de una tabla de usuarios, donde me autoimpuse la restriccion de que el correo electronico fuese la clave primaria. No obstante considere otra alternativa que controla la NO REPETICION de correos ya registrador pero asigna un valor autonumerico a los nuevos usuarios. Frente a tal situacion requeria obtener el valor de la clave primaria recien autogenerada, durante el desarrollo del desafio esto lo solucione mediante una consulta adicional en base al correo electronico que sabia que no se repetia, pero explore por un momento lo que descubri de la instruccion INSERT y otras, que soportan el retorno inmediato de uno o mas valores mediante el apendice de la instruccion RETURNING.

En definitiva, este código efectivamente implementa la insercion y la extraccion de la clave primaria autogenerada.
