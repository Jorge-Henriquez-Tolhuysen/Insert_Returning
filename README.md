INSERT INTO RETURNING

Recientemente, como parte de un desafío, fue necesario interactuar con una base de datos Oracle. Parte de la funcionalidad solicitada requeria la implementación de una tabla de usuarios, donde me autoimpuse la restricción de que el correo electrónico fuese la clave primaria. No obstante consideré otra alternativa que controla la DUPLICIDAD de correos ya registrados pero asigna un valor autonumérico a los nuevos usuarios. Frente a tal situación requeria obtener el valor de la clave primaria recién autogenerada, durante el desarrollo del desafío esto lo solucione mediante una consulta adicional en base al correo electrónico que sabia que no se repetia, pero explore por un momento lo que descubrí de la instrucción INSERT y otras, que soportan el retorno inmediato de uno o mas valores mediante el apendice de la instrucción RETURNING.

En definitiva, este código efectivamente implementa la inserción y la extracción de la clave primaria autogenerada.
