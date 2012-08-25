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
public class Facebook implements iSocial,iComment {
    String username;
    ArrayList<String> posts = new ArrayList<String>();
    ArrayList<Integer> friends = new ArrayList<Integer>();
    ArrayList<Comment> comments = new ArrayList<Comment>();
    
    public Facebook(String u){
        username = u;
    }
    
    @Override
    public void addFriend(int codeFriend) {
        if(!friends.contains(codeFriend))
            friends.add(codeFriend);
        else
            throw new FriendExistException();
    }

    @Override
    public void viewMyInfo() {
        System.out.println("FACEBOOK DE " + username);
        System.out.println("-----------------------");
        
        for(int p = 0; p < posts.size(); p++){
            System.out.println(posts.get(p));
            //comments
            for(Comment c : comments){
                if( c.postid == p ){
                    System.out.println("\t-" + c.msg);
                }
            }
            System.out.println("");
        }
        
        System.out.println("AMIGOS\n----------");
        for(Integer id : friends )
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

    @Override
    public boolean addComment(int postid, String msg) throws NoPostException {
        if( postid >= 0 && postid < posts.size()){
            comments.add( new Comment(postid,msg) );
            return true;
        }
        else
            throw new NoPostException();
    }
    
}
