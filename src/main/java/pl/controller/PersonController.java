/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import pl.util.MenuView;
import pl.util.Pages;

@SessionScoped
@ManagedBean
public class PersonController implements Serializable {

    private MenuView menuView = new MenuView();
    private boolean logged = false;
    private boolean admin;
    private boolean boss;
    private boolean client;

    public String login() {
        logged = true;

        if (true) {
            return Pages.USER;
        } else {
            return Pages.GUEST_LOGIN;
        }
    }

    public String register() {
        return Pages.GUEST_REGISTER;
    }

    public String logout() {
        logged = false;

        return Pages.GUEST;
    }

    public boolean isLogged() {
        return logged;
    }

}
