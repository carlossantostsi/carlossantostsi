/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcc.classes;

import java.math.BigInteger;

/**
 *
 * @author Carlos Santos
 */
public class OperacaoModularPotencia {

    public BigInteger modularPorPotencia(Long valor, Long modulo, Long potencia){
        BigInteger resultado = BigInteger.ONE ;

        /* Sendo "potencia" um numero primo
         * e "valor" um numero inteiro
         * entao o resultado e o proprio expoente
        */
        if (potencia.intValue() == modulo.intValue()){
            resultado = BigInteger.valueOf(potencia) ;
            return resultado ;
        }

        /* Irá modular o valor
         * enquato valor for maior que a potencia
         * Mais eficiente e mais rapido que o programa atual, utilizado nas aulas;
         */
        resultado = BigInteger.valueOf(valor).modPow(BigInteger.valueOf(potencia), BigInteger.valueOf(modulo));

        return resultado ;
    }

}
