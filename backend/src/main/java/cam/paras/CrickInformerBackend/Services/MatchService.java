package cam.paras.CrickInformerBackend.Services;

import cam.paras.CrickInformerBackend.Entities.Match;

import java.util.List;

public interface MatchService {

    List<Match> getAllMatches();

    List<Match> getLiveMatches();



    List<List<String>> getPointTable();
}
