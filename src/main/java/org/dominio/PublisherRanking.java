package org.dominio;

import java.util.ArrayList;
import java.util.List;

public class PublisherRanking {
    private List<Ranking> rankings;

    public PublisherRanking(){
        this.rankings = new ArrayList<Ranking>();
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void agregarRanking(Ranking ranking){
        rankings.add(ranking);
    }


    public void sacarRanking(Ranking ranking){
        rankings.remove(ranking);
    }

    public void notificarRankings(){
        rankings.forEach(ranking -> ranking.ordenarRanking());
    }


}
