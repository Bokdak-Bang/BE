package seoul.gonggong.domain.data.application;

import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.dto.response.AreaScoreListResponse;

public interface DataService {
    AreaScoreListResponse getAreaListByInputScore(AreaStandardRequest areaStandardRequest);
}
