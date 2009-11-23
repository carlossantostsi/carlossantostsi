/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcc.classes;

/**
 *
 * @author Carlos Santos
 */
public class AlgoritmoFermat {

    public String fermat(Long valor) {
        OperacaoModular operacaoModular = new OperacaoModular();
        String retorno = "O Número "+valor+" é Primo.";
        Double temp = 0.0;
        Long x = new Long(0);
        Double y = 0.0;

        if(operacaoModular.calularMOD(valor, new Long(2)) == 0){
            return "O Número Informado é Par.";
        }

        temp = Math.sqrt(valor);
        x = temp.longValue()+1;

        for (int i = x.intValue(); i < (valor+1)/2; i++) {

            y = Math.sqrt(Math.pow(i, 2) - valor);
            System.out.println(i + "             " + y);

            if (y == Math.round(y) ) {
                Integer p = (i + y.intValue());
                Integer q = (i - y.intValue());

                retorno = ("Número não Primo. Os múltiplos de: " + p*q + " ; são: " + p + " e: " +q+" .");
            break;
            }
        }

        return retorno;
    }

}
