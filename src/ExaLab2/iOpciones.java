/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExaLab2;

/**
 *
 * @author Gotcha
 */
public interface iOpciones {
    int MAX_OPTIONS = 60;
    void imprimirOpciones();
    void ejecutarOpcion(int opId)throws NoSuchOptionException;
}
