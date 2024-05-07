package seoul.gonggong.domain.data.dto.response;

import java.util.List;
import java.util.function.Function;

public record AreaScoreListResponse(
        List<AreaScoreResponse> areaScoreResponseList
) {
    public static AreaScoreListResponse of(List<AreaScoreResponse> collect) {
        return new AreaScoreListResponse(collect);
    }
}
