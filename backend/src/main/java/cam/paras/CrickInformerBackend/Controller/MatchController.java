package cam.paras.CrickInformerBackend.Controller;

import cam.paras.CrickInformerBackend.Entities.IPLPointsTable;
import cam.paras.CrickInformerBackend.Entities.Match;
import cam.paras.CrickInformerBackend.Services.IPLPointsService;
import cam.paras.CrickInformerBackend.Services.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/match")
@CrossOrigin
public class MatchController {
    @Autowired
    private MatchServiceImpl service;
    @GetMapping("/live")
    public List<Match> getLiveMatches()
    {
        return service.getLiveMatches();
    }
    @GetMapping
    public List<Match> getAllMatches(){
        return service.getAllMatches();
    }
    @GetMapping("/point-table")
    public List<List<String>> getPointTable()
    {
        return service.getPointTable();
    }
    @Autowired
    private IPLPointsService pointsService;

    @GetMapping("/update-ipl-points")
    public List<IPLPointsTable> updatePointsTable() {
       return pointsService.getAllPointsTableData();
       // return "Points table updated successfully!";
    }

}
