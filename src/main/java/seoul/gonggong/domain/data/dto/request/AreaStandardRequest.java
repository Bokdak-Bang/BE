package seoul.gonggong.domain.data.dto.request;

public record AreaStandardRequest(
        Integer natureScore,
        Integer residenceScore,
        Integer populationScore,
        Integer securityScore,
        Integer lifeScore,
        Integer educationScore,
        Integer welfareScore
) {

}
