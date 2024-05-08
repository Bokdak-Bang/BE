package seoul.gonggong.domain.data.dto.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record AreaDetailBoardResponse(
        String bigCategory,
        String detailCategory,
        Double score
) {
    public static List<AreaDetailBoardResponse> of(List<Map<String, Map<String, Double>>> categoryAndScoreList) {
        List<AreaDetailBoardResponse> responses = new ArrayList<>();

        for (Map<String, Map<String, Double>> categoryMap : categoryAndScoreList) {
            for (Map.Entry<String, Map<String, Double>> categoryEntry : categoryMap.entrySet()) {
                String bigCategory = categoryEntry.getKey();
                Map<String, Double> detailScores = categoryEntry.getValue();
                for (Map.Entry<String, Double> scoreEntry : detailScores.entrySet()) {
                    String detailCategory = scoreEntry.getKey();
                    Double score = scoreEntry.getValue();
                    responses.add(new AreaDetailBoardResponse(bigCategory, detailCategory, score));
                }
            }
        }
        return responses;
    }
}
