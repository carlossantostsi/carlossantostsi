/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcc.classes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Carlos Santos
 */
public class Matriz2x2 {

    public Map<String, Long> calcularMatrizInversa(Long a11, Long a12, Long a21, Long a22, Long modulo){

        Map<String, Long> matrizInversa = new HashMap<String, Long>();

        AlgoritmoEuclidesEstendido euclidesEstendido = new AlgoritmoEuclidesEstendido();
        OperacaoModular operacaoModular = new OperacaoModular();

        Long detK = new Long((a11 * a22) - (a12 * a21));
        Long[][] adjK = new Long[2][2];
        Long[][] K1 = new Long[2][2];

        adjK[0][0] = new Long(a22) ; adjK[0][1] = new Long(-a12);
        adjK[1][0] = new Long(-a21); adjK[1][1] = new Long(a11) ;

        Map<String, Long> resultadoEuclidesEstendido = euclidesEstendido.calcularEE(detK, modulo);

        if (operacaoModular.calularMOD(resultadoEuclidesEstendido.get("MDC"), modulo) == 1){
                matrizInversa.put("POSSUI_INVERSO", new Long(0));
                Long detKT = new Long(0);
                if (resultadoEuclidesEstendido.containsKey("INVERSO")){
                    detKT = resultadoEuclidesEstendido.get("INVERSO");
                }else{
                    detKT = resultadoEuclidesEstendido.get("X");
                }

                
                for (int i = 0; i < K1.length; i++) {
                        for (int j = 0; j < K1[i].length; j++) {
                                K1[i][j] = (operacaoModular.calularMOD((detKT * (adjK[i][j])), modulo));
                        }
                }

                for (int i = 0; i < K1.length; i++) {
                    for (int j = 0; j < K1.length; j++) {
                        matrizInversa.put("a"+(i+1) +(j+1), K1[i][j]);
                    }
                }
        }else{
                System.out.println("Não Tem Inverso !");
                return matrizInversa ;
        }

        

        return matrizInversa ;
    }

}
