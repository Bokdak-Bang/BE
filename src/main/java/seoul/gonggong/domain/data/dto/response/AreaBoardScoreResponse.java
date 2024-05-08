package seoul.gonggong.domain.data.dto.response;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record AreaBoardScoreResponse(
        String categoryName,
        Integer score
) {
    public static List<AreaBoardScoreResponse> of(Map<String, Integer> scoreList) {
        return scoreList.entrySet()
                .stream()
                .map(entry -> new AreaBoardScoreResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
