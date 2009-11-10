/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcc.classes;

/**
 *
 * @author Carlos Santos
 */
public class OperacaoModular {

    public Long calularMOD(Long valor, Long modulo){
        Long resultado = new Long(0);

        if(valor < 0){
            resultado = (-1 * valor) % modulo ;
            resultado = (-1 * resultado) + modulo ;
            return resultado ;
        }

        if (valor < modulo){
            resultado = valor ;
        }else{
            resultado = valor % modulo ;
        }

        if (resultado < 0){
            resultado = resultado + modulo ;
        }

        return resultado;
    }

}
