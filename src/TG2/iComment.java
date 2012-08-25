/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

/**
 *
 * @author Gotcha
 */
public interface iComment {
    boolean addComment(int postid,String msg) throws NoPostException;
}
