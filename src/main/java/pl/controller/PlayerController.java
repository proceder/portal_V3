/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import pl.domain.Player;
import pl.logic.Service;
import pl.util.Pages;

/**
 *
 * @author kadam
 */
@ManagedBean
@ViewScoped
public class PlayerController implements Serializable {

    @EJB
    private Service service;
    private Player player;
    private List<Player> playersList = new ArrayList<Player>();
    private String searchString;
    private Logger logger;

    public PlayerController() {
    }

    @PostConstruct
    public void init() {
        this.player = new Player();
        logger = Logger.getLogger(Service.class.getName());

    }

    public String deleteRow(Player playerToDelete) {
        logger.info(this.getClass().getSimpleName() +  "@@@ Trying to remove player:" + playerToDelete.getFirstName());
        service.deleteFromDB(playerToDelete);
        return null;
    }

    public List<Player> getSearchList() {
        return service.allPlayers(this.searchString);
    }

    public List<Player> getPlayersList() {
        logger.info(this.getClass().getSimpleName() +  "@@@ Trying to return playerList:");

        playersList = service.allPlayers();
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public String save() {
        logger.info(this.getClass().getSimpleName() +  "@@@ Trying to update playerList:");
        for (Player player : playersList) {
            player.setEditable(false);
            service.update(player);
        }
        return null;
    }

    public String addPlayer() {
        logger.info(this.getClass().getSimpleName() +  "@@@ Trying to create new player:");
        service.createPlayer(player);
        this.player = new Player();
        return Pages.PLAYERS_STATS;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void edit() {
        service.update(player);
    }

    public String goToEdition(Player p) {
        this.player = p;
        return "edit";
    }

}
