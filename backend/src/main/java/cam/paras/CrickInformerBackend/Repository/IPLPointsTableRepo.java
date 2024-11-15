package cam.paras.CrickInformerBackend.Repository;

import cam.paras.CrickInformerBackend.Entities.IPLPointsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IPLPointsTableRepo extends JpaRepository<IPLPointsTable, Long> {
    Optional<IPLPointsTable> findByTeamName(String teamName);
}
