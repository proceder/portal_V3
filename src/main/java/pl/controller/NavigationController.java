package pl.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import pl.util.MenuView;
import pl.util.Pages;

@SessionScoped
@ManagedBean
public class NavigationController implements Serializable {

    public String goToLogin() {
        return Pages.GUEST_LOGIN;
    }

    public String goToRegister() {
        return Pages.GUEST_REGISTER;
    }

    public String goToSharedFAQ() {
        return Pages.SHARED_FAQ;
    }

    public String goToGuestHome() {
        return Pages.GUEST;
    }

    public String goToUserHome() {
        return Pages.USER;
    }

    public String goToPlayersStats() {
        return Pages.PLAYERS_STATS;
    }

    public String goToTeamStats() {
        return Pages.TEAM_STATS;
    }

    public String goToTop10Stats() {
        return Pages.TOP10_STATS;
    }
    
    public String goToAddPlayer() {
        return Pages.USER_ADD_PLAYER;
    }
    
    public String goToPlayersList() {
        return Pages.USER_PLAYERS_LIST;
    }
    
    public String goToSearchResult() {
        return Pages.SEARCH_RESULT;
    }

}
