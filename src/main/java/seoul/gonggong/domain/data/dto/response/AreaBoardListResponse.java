package seoul.gonggong.domain.data.dto.response;

import java.util.List;

public record AreaBoardListResponse(
        String area,
        List<AreaBoardScoreResponse> areaBoardScoreResponse,
        List<MeanScoreResponse> meanScoreResponses,
        List<AreaBoardCategoryScoreResponse> areaBoardCategoryScoreResponses


) {
    public static AreaBoardListResponse of(String area,List<AreaBoardScoreResponse> areaBoardScoreResponse,
                                           List<MeanScoreResponse> meanScoreResponses,
                                           List<AreaBoardCategoryScoreResponse> areaBoardCategoryScoreResponses) {
        return new AreaBoardListResponse(area,areaBoardScoreResponse,meanScoreResponses,areaBoardCategoryScoreResponses);
    }

}
