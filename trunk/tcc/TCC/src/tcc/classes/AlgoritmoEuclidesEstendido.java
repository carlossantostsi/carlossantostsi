/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcc.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carlos Santos
 */
public class AlgoritmoEuclidesEstendido {

    public Map<String, Long> calcularEE(Long a, Long b){
        List<String> lista = new ArrayList<String>();
        Map<String, Long> listaValores = new HashMap<String, Long>();

        List<Long> r = new ArrayList<Long>();
        List<Long> q = new ArrayList<Long>();
        List<Long> x = new ArrayList<Long>();
        List<Long> y = new ArrayList<Long>();

        r.add(0, a);  q.add(0, new Long(0));  x.add(0, new Long(1));  y.add(0, new Long(0));
        r.add(1, b);  q.add(1, new Long(0));  x.add(1, new Long(0));  y.add(1, new Long(1));

        for(Integer i=2; r.get(i-1) != 0; i++){
                r.add(i,r.get(i-2)%r.get(i-1));
                q.add(i,(Long)(r.get(i-2)/r.get(i-1)));
                x.add(i,(Long)(x.get(i-2)- (q.get(i)) * x.get(i-1)));
                y.add(i,(Long)(y.get(i-2)- (q.get(i)) * y.get(i-1)));

                System.out.println(r.get(i)+"    "+q.get(i)+"    "+x.get(i)+"    "+y.get(i));
        }

        if(x.get(x.size()-2) < 0){
            Long inverso = x.get(x.size()-2) + b ;
            listaValores.put("INVERSO", inverso);
        }

        listaValores.put("MDC", r.get(r.size()-2));
        listaValores.put("X", x.get(x.size()-2));
        listaValores.put("Y", y.get(y.size()-2));

        lista.add("O MDC entre "+a+" e "+b+" é: "+r.get(r.size()-2));
        lista.add("O valor de x é: "+x.get(x.size()-2));
        lista.add("O valor de y é: "+y.get(y.size()-2));

        return listaValores ;

    }

}
