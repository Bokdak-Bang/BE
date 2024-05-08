package seoul.gonggong.domain.data.dto.response;

import java.util.List;
import java.util.Map;

public record MeanScoreResponse(
        String detailCategory,
        Double mean
) {
    public static List<MeanScoreResponse> of(Map<String, Double> mean) {
        return mean.entrySet()
                .stream()
                .map(entry -> new MeanScoreResponse(entry.getKey(), entry.getValue()))
                .toList();
    }
}
