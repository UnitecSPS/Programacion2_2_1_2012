/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class Twitter implements iSocial{
    private String username;
    private ArrayList<String> posts = new ArrayList<String>();
    private ArrayList<Integer> following = new ArrayList<Integer>();
    
    public Twitter(String u){
        username = u;
    }

    @Override
    public void addFriend(int codeFriend) {
        if(!following.contains(codeFriend))
            following.add(codeFriend);
        else
            throw new FriendExistException();
    }

    @Override
    public void viewMyInfo() {
        System.out.println("TL de @" + username);
        for(String post : posts){
            System.out.println(post + "\n");
        }
        System.out.println("\nFollowing\n----------");
        for(Integer id : following )
            System.out.println("\t-" + id);
    }

    @Override
    public void createPost(String message) {
        posts.add(message);
    }

    @Override
    public String getUsername() {
        return username;
    }
}
