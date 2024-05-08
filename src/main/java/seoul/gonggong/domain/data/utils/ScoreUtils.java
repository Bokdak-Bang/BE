package seoul.gonggong.domain.data.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.repository.*;
import seoul.gonggong.domain.exception.DataException;

import java.util.*;

import static seoul.gonggong.global.error.status.ErrorStatus.DATA_IS_WRONG;
import static seoul.gonggong.global.error.status.ErrorStatus.DATA_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class ScoreUtils {
    private final EducationJpaRepository educationJpaRepository;
    private final LifeJpaRepository lifeJpaRepository;
    private final NatureJpaRepository natureJpaRepository;
    private final ResidenceJpaRepository residenceJpaRepository;
    private final SecurityJpaRepository securityJpaRepository;
    private final WelfareCultureJpaRepository welfareCultureJpaRepository;
    private final CalculateUtils calculateUtils;

    public double calculateTotalScore(Area area, AreaStandardRequest request) {
        Double natureScore = request.natureScore() / 5.0 * (natureJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_IS_WRONG))).getTotalScore();

        Double residenceScore = request.residenceScore() / 5.0 * (residenceJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_IS_WRONG))).getTotalScore();

        Double securityScore = request.securityScore() / 5.0 * (securityJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_IS_WRONG))).getTotalScore();

        Double lifeScore = request.lifeScore() / 5.0 * (lifeJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_IS_WRONG))).getTotalScore();

        Double educationScore = request.educationScore() / 5.0 * (educationJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_IS_WRONG))).getTotalScore();

        Double welfareScore = request.welfareScore() / 5.0 * (welfareCultureJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_IS_WRONG)).getTotalScore());

        return natureScore + residenceScore + securityScore + lifeScore + educationScore + welfareScore;
    }

    public Double getTotalEducationScore(Area area) {
        Double totalScore = educationJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND)).getTotalScore();
        return Double.parseDouble(String.format("%.1f", totalScore));
    }

    public Double getTotalLifeScore(Area area) {
        Double totalScore = lifeJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND)).getTotalScore();
        return Double.parseDouble(String.format("%.1f", totalScore));
    }

    public Double getTotalNatureScore(Area area) {
        Double totalScore = natureJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND)).getTotalScore();
        return Double.parseDouble(String.format("%.1f", totalScore));
    }

    public Double getTotalResidenceScore(Area area) {
        Double totalScore = residenceJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND)).getTotalScore();
        return Double.parseDouble(String.format("%.1f", totalScore));
    }

    public Double getTotalSecurityScore(Area area) {
        Double totalScore = securityJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND)).getTotalScore();
        return Double.parseDouble(String.format("%.1f", totalScore));
    }

    public Double getTotalWelfareScore(Area area) {
        Double totalScore = welfareCultureJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND)).getTotalScore();
        return Double.parseDouble(String.format("%.1f", totalScore));
    }

    public List<Map<String, Map<String, Double>>> getCategoryAndScoreList(Area area) {
        List<Map<String, Map<String, Double>>> list = new ArrayList<>();

        Map<String, Map<String, Double>> educationCategoryList = calculateUtils.getEducationCategoryList(area);
        Map<String, Map<String, Double>> natureCategoryList = calculateUtils.getNatureCategoryList(area);
        Map<String, Map<String, Double>> populationCategoryList = calculateUtils.getPopulationCategoryList(area);
        Map<String, Map<String, Double>> residenceCategoryList = calculateUtils.getResidenceCategoryList(area);
        Map<String, Map<String, Double>> securityCategoryList = calculateUtils.getSecurityCategoryList(area);
        Map<String, Map<String, Double>> welfareCultureCategoryList = calculateUtils.getWelfareCultureCategoryList(area);
        Map<String, Map<String, Double>> lifeCategoryList = calculateUtils.getLifeCategoryList(area);

        list.add(educationCategoryList);
        list.add(natureCategoryList);
        list.add(populationCategoryList);
        list.add(residenceCategoryList);
        list.add(securityCategoryList);
        list.add(welfareCultureCategoryList);
        list.add(lifeCategoryList);

        return list;
    }
}
