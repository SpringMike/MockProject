package intern.sapo.be.service;

import intern.sapo.be.dto.request.Statistics.StatisticsImportRequest;
import intern.sapo.be.dto.response.Statistics.StatisticsImportResponse;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IStatisticsService {
    List<StatisticsImportResponse> getStatisticsImport(StatisticsImportRequest request);

    List<StatisticsImportResponse> getStatisticsImportExtend(StatisticsImportRequest request);
}
