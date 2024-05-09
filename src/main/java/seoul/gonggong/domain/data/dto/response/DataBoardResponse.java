package seoul.gonggong.domain.data.dto.response;

import java.util.List;

public record DataBoardResponse(
        String area,
        List<AreaBoardScoreResponse> areaBoardScoreResponseList
) {
    public static DataBoardResponse of(String area, List<AreaBoardScoreResponse> areaBoardScoreResponseList) {
        return new DataBoardResponse(area, areaBoardScoreResponseList);
    }
}
