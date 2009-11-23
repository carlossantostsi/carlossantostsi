package tcc.classes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Carlos Santos
 */
public class ValidarDados extends PlainDocument{

    private static final long serialVersionUID = -5066124721357390024L;

    private int iMaxLength;
    private String numeros = "1234567890";

    public ValidarDados(int maxlen) {
        super();   
        iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }
        /*
         * So permite que seja
         * digitados numeros
         * 
         * */
        if (!numeros.toString().contains(str)){
            super.remove(offset, offset);
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str, attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
            super.insertString(offset, str, attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }
            String newStr = str.substring(0, (iMaxLength - getLength()));
            super.insertString(offset, newStr, attr);
        }
    }

}
