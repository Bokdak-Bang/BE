package seoul.gonggong.domain.data.dto.response;

public record AreaScoreResponse(
        Long id,
        String region,
        Double score
) {
    public static AreaScoreResponse of(Long id,String region, Double score) {
        return new AreaScoreResponse(id, region, score);
    }
}
