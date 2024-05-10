package seoul.gonggong.domain.data.application;

import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.dto.response.AreaBoardListResponse;
import seoul.gonggong.domain.data.dto.response.AreaScoreListResponse;
import seoul.gonggong.domain.data.dto.response.DataBoardResponse;

import java.util.List;

public interface DataService {
    AreaScoreListResponse getAreaListByInputScore(AreaStandardRequest areaStandardRequest);

    AreaBoardListResponse getBoardOfArea(Long areaId);

    void saveBoardOfArea(Long memberId, Long areaId);

    List<DataBoardResponse> getLikeAreaList(Long memberId);
}
