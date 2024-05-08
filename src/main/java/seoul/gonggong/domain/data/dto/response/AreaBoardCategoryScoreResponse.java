package seoul.gonggong.domain.data.dto.response;

import java.util.List;
import java.util.stream.Collectors;

public record AreaBoardCategoryScoreResponse(
        String categoryname,
        List<AreaDetailBoardResponse> areaDetailBoardResponsList
) {
    public static List<AreaBoardCategoryScoreResponse> of(List<AreaDetailBoardResponse> areaDetailBoardResponses) {
        //bigCategory가 7개 지표중 한개임
        return areaDetailBoardResponses.stream()
                .collect(Collectors.groupingBy(AreaDetailBoardResponse::bigCategory))
                .entrySet()
                .stream()
                .map(entry -> new AreaBoardCategoryScoreResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}
