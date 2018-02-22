package Utilidades;

import com.sun.javafx.application.PlatformImpl;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Raul
 */
public class JTextfieldPlaceHolder extends JTextField {

    private String placeholder = "placeholder default";
    private boolean isPlaceholderActive = true;
    private Color colorPlaceholder = Color.GRAY;
    private Color colorForeground = Color.BLACK;

    private DocumentListener listener = new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent e) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    if (isPlaceholderActive && !obtenerTextoInterno().equals(placeholder)) {
                        getDocument().removeDocumentListener(listener);
                        setText(obtenerTextoInterno().substring(placeholder.length()));
                        getDocument().addDocumentListener(listener);
                    }
                }
            });
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    getDocument().removeDocumentListener(listener);
                    setText(placeholder);
                    getDocument().addDocumentListener(listener);
                }
            });
        }

        @Override

        public void changedUpdate(DocumentEvent e) {
        }
    };

    /**
     * Constructor del JTextField con placeholder
     */
    public JTextfieldPlaceHolder() {
        setTextInterno(placeholder);
        setColorPlaceholder(colorPlaceholder);
        getDocument().addDocumentListener(listener);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPlaceholderActive) {
                    setCaretPosition(obtenerTextoInterno().length());
                }
            }
        });
        addFocusListener(new FocusAdapter(){
            
            @Override
            public void focusGained(FocusEvent evt){
                setCaretPosition(obtenerTextoInterno().length());
            }
            
        });
    }

    /**
     * Retorna la cadena usada como placeholder
     *
     * @return el texto usado como placeholder
     */
    public String getPlacelder() {
        return placeholder;
    }

    /**
     * Establece la cadena que se usará como placeholder
     *
     * @param placeholder el placeholder a usar
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        if (isPlaceholderActive) {            
            setTextInterno(placeholder);
        }
    }

    /**
     * Obtiene el color que toma el placeholder
     *
     * @return el color asignado al placeholder
     */
    public Color getColorPlaceholder() {
        return colorPlaceholder;
    }

    /**
     * Establece el color del placeholder
     *
     * @param colorPlaceholder el color que se establecerá en el placeholder
     */
    public void setColorPlaceholder(Color colorPlaceholder) {
        this.colorPlaceholder = colorPlaceholder;
        if (isPlaceholderActive) {
            setForeground(colorPlaceholder);
        }
    }

    /**
     * Estable el color del texto
     *
     * @param fg color que se asignará
     */
    public void setColorForeground(Color fg) {
        this.colorForeground = fg;
    }

    /**
     * Retorna el texto, si es que existe alguno en el JTextField (el
     * placeholder no es considerado texto)
     *
     * @return el texto de la cadena
     */
    @Override
    public String getText() {
        if (isPlaceholderActive) {
            return "";
        } else {
            return super.getText();
        }
    }

    private String obtenerTextoInterno() {
        return super.getText();
    }

    private void setTextInterno(String text) {
        super.setText(text);
    }

    public void setText(String text) {
        if(!text.equals(placeholder)) {
            isPlaceholderActive = false;
            setForeground(colorForeground);
            setTextInterno(text);
        } else if ((isPlaceholderActive && !obtenerTextoInterno().equals(placeholder))
                || obtenerTextoInterno().isEmpty()) {
            isPlaceholderActive = true;
            setForeground(colorPlaceholder);
            setTextInterno(placeholder);            
        }
    }
}
