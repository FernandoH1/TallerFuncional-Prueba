package Pruebas;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Prueba {

    public static class Main {

        public static void main(String[] args) {


            BiFunction<Integer,Integer,Integer> sumar=(a, b)->a+b;
            BiFunction<Integer,Integer,Integer> restar=(a, b)->a-b;

            //suma y resta con operador binario
            IntBinaryOperator add=(a, b)->a+b;
            IntBinaryOperator sustract=(a, b)->a-b;

            //multiplicacion
            IntBinaryOperator mult=(a,b)->
                    IntStream.range(0,b+1)
                            .reduce((acomulador,numero)-> add.applyAsInt(acomulador,a))
                            .getAsInt();


            //division
            BiFunction<Integer,Integer,Integer> divisionEntera = (num,den) ->{
                return IntStream.range(0, den+1)
                        .reduce((acumulador, numero) -> {
                            if (mult.applyAsInt(numero,den)<=num) {
                                return acumulador = acumulador+1 ;
                            }
                            return acumulador;
                        }).getAsInt();
            };

            System.out.println(sumar.apply(1,2));
            System.out.println(restar.apply(3,2));
            System.out.println(add.applyAsInt(1,5));
            System.out.println(sustract.applyAsInt(5,2));
            System.out.println(mult.applyAsInt(5,5));
            System.out.println(divisionEntera.apply(95,3));


        }
    }
}
