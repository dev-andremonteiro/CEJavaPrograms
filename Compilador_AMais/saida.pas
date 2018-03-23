Program principal;
VAR
altura:REAL;
base:REAL;
resultado:REAL;

Begin

write('Digite a altura do triangulo:');

read(altura);

write('Digite a base do triangulo:');

read(base);
resultado:=base*altura;
resultado:=resultado/2;

write('A area do triangulo eh: ',resultado);

End.
