/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

/**
 *
 * @author Gotcha
 */
public interface iSocial {
    void addFriend(int codeFriend);
    void viewMyInfo( );
    void createPost(String message);
    String getUsername();
    int VERSION_INTERFACE = 233;
}
