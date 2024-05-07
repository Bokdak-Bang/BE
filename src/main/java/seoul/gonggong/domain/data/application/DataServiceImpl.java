package seoul.gonggong.domain.data.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.dto.response.AreaScoreListResponse;
import seoul.gonggong.domain.data.dto.response.AreaScoreResponse;
import seoul.gonggong.domain.data.repository.*;
import seoul.gonggong.domain.exception.DataException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static seoul.gonggong.global.error.status.ErrorStatus.DATA_IS_WRONG;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DataServiceImpl implements DataService {
    private final AreaJpaRepository areaJpaRepository;
    private final EducationJpaRepository educationJpaRepository;
    private final LifeJpaRepository lifeJpaRepository;
    private final NatureJpaRepository natureJpaRepository;
    private final ResidenceJpaRepository residenceJpaRepository;
    private final SecurityJpaRepository securityJpaRepository;
    private final WelfareCultureJpaRepository welfareCultureJpaRepository;

    @Override
    public AreaScoreListResponse getAreaListByInputScore(AreaStandardRequest areaStandardRequest) {
        List<AreaScoreResponse> collect = areaJpaRepository.findAll().stream()
                .map(area -> new AreaScoreResponse(area.getId(), String.valueOf(area.getRegion()), calculateTotalScore(area, areaStandardRequest)))
                .sorted(Comparator.comparingDouble(AreaScoreResponse::score).reversed())
                .collect(Collectors.toList());
        
        return AreaScoreListResponse.of(collect);
    }

    private double calculateTotalScore(Area area, AreaStandardRequest request) {
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
}
