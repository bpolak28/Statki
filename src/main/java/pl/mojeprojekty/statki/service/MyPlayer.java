package pl.mojeprojekty.statki.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.mojeprojekty.statki.dto.Player;

@Component
@Scope(value = "session")
public class MyPlayer {

    Player me;

    public MyPlayer() {

    }

    public Player getMe() {
        return me;
    }

    public void setMe(Player me) {
        this.me = me;
    }
}
