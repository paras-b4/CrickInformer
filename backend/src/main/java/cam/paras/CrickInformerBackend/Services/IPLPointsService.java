package cam.paras.CrickInformerBackend.Services;

import cam.paras.CrickInformerBackend.Entities.IPLPointsTable;
import cam.paras.CrickInformerBackend.Repository.IPLPointsTableRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IPLPointsService {

    @Autowired
    private IPLPointsTableRepo repo;

    public void updatePointsTable() {
        String tableURL = "https://www.cricbuzz.com/cricket-series/7607/indian-premier-league-2024/points-table";
        try {
            Document document = Jsoup.connect(tableURL).get();
            Elements table = document.select("table.cb-srs-pnts");
            Elements bodyTrs = table.select("tbody>*");
            bodyTrs.forEach(tr -> {
                if (tr.hasAttr("class")) {
                    Elements tds = tr.select("td");
                    String teamName = tds.get(0).select("div.cb-col-84").text();
                    int played = Integer.parseInt(tds.get(1).text());
                    int won = Integer.parseInt(tds.get(2).text());
                    int lost = Integer.parseInt(tds.get(3).text());
                    int tied = Integer.parseInt(tds.get(4).text());
                    int noResult = Integer.parseInt(tds.get(5).text());
                    int points = Integer.parseInt(tds.get(6).text());
                    double netRunRate = Double.parseDouble(tds.get(7).text().replace(",", "").replace("+", ""));

                    IPLPointsTable pointsTable = new IPLPointsTable(teamName, played, won, lost, tied, noResult, points, netRunRate);
                    updatePointsTableInDb(pointsTable);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updatePointsTableInDb(IPLPointsTable pointsTable) {
        IPLPointsTable existingTeam = repo.findByTeamName(pointsTable.getTeamName()).orElse(null);
        if (existingTeam == null) {
            repo.save(pointsTable);
        } else {
            pointsTable.setId(existingTeam.getId());
            repo.save(pointsTable);
        }
    }
    public List<IPLPointsTable> getAllPointsTableData() {
        return repo.findAll();
    }
}
