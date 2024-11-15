package cam.paras.CrickInformerBackend.Repository;

import cam.paras.CrickInformerBackend.Entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepo extends JpaRepository<Match,Integer> {


    Optional<Match> findByTeamHeading(String teamHeading);
}
