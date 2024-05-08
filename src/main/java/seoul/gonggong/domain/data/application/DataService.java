package seoul.gonggong.domain.data.application;

import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.dto.response.AreaBoardListResponse;
import seoul.gonggong.domain.data.dto.response.AreaScoreListResponse;

public interface DataService {
    AreaScoreListResponse getAreaListByInputScore(AreaStandardRequest areaStandardRequest);

    AreaBoardListResponse getBoardOfArea(Long areaId);

    void saveBoardOfArea(Long memberId, Long areaId);
}
