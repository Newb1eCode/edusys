/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.model;

/**
 *
 * @author ADMIN
 */
public class Login {
    private String User ;
    private String pass ;
    private Boolean role ;

    public Login() {
    }

    public Login(String User, String pass, Boolean role) {
        this.User = User;
        this.pass = pass;
        this.role = role;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" + "User=" + User + ", pass=" + pass + ", role=" + role + '}';
    }
    
    Object[] toDataRows(){
        return new Object[]{
            this.User,this.pass,this.role
        };
    }
}
