package seoul.gonggong.domain.data.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoul.gonggong.domain.data.domain.Area;
import seoul.gonggong.domain.data.domain.MemberAreaEntity;
import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.dto.response.*;
import seoul.gonggong.domain.data.repository.*;
import seoul.gonggong.domain.data.utils.MeanUtils;
import seoul.gonggong.domain.data.utils.ScoreUtils;
import seoul.gonggong.domain.exception.DataException;
import seoul.gonggong.domain.member.domain.MemberEntity;
import seoul.gonggong.domain.member.exception.MemberNotFoundException;
import seoul.gonggong.domain.member.repository.MemberJpaRepository;

import java.util.*;
import java.util.stream.Collectors;

import static seoul.gonggong.global.error.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class DataServiceImpl implements DataService {
    private final AreaJpaRepository areaJpaRepository;
    private final MemberAreaJpaRepository memberAreaJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    private final ScoreUtils scoreUtils;
    private final MeanUtils meanUtils;

    @Override
    public List<DataBoardResponse> getLikeAreaList(Long memberId) {
        List<DataBoardResponse> dataBoardResponses = new ArrayList<>();
        List<MemberAreaEntity> memberAreaEntityList = memberAreaJpaRepository.findByMemberId(memberId);

        for (MemberAreaEntity memberArea : memberAreaEntityList) {
            Area area = areaJpaRepository.findById(memberArea.getArea().getId())
                    .orElseThrow(() -> new DataException(AREA_NOT_FOUND));

            Map<String, Integer> scoreList = new HashMap<>();

            scoreList.put("education", Integer.valueOf(scoreUtils.getTotalEducationScore(area).intValue()));
            scoreList.put("life",Integer.valueOf(scoreUtils.getTotalLifeScore(area).intValue()));
            scoreList.put("nature",Integer.valueOf(scoreUtils.getTotalNatureScore(area).intValue()));
            scoreList.put("residence",Integer.valueOf(scoreUtils.getTotalResidenceScore(area).intValue()));
            scoreList.put("security",Integer.valueOf(scoreUtils.getTotalSecurityScore(area).intValue()));
            scoreList.put("welfare", Integer.valueOf(scoreUtils.getTotalWelfareScore(area).intValue()));

            List<AreaBoardScoreResponse> areaBoardScoreResponses = AreaBoardScoreResponse.of(scoreList);

            dataBoardResponses.add(DataBoardResponse.of(area.getRegion().getArea(), areaBoardScoreResponses));
        }

        return dataBoardResponses;
    }

    @Override
    public AreaScoreListResponse getAreaListByInputScore(AreaStandardRequest areaStandardRequest) {
        List<AreaScoreResponse> collect = areaJpaRepository.findAll().stream()
                .map(area -> new AreaScoreResponse(area.getId(), String.valueOf(area.getRegion()), scoreUtils.calculateTotalScore(area, areaStandardRequest)))
                .sorted(Comparator.comparingDouble(AreaScoreResponse::score).reversed())
                .collect(Collectors.toList());

        return AreaScoreListResponse.of(collect);
    }

    @Override
    public AreaBoardListResponse getBoardOfArea(Long areaId) {
        Area area = areaJpaRepository.findById(areaId)
                .orElseThrow(() -> new DataException(AREA_NOT_FOUND));

        Map<String, Integer> scoreList = new HashMap<>();

        scoreList.put("education", Integer.valueOf(scoreUtils.getTotalEducationScore(area).intValue()));
        scoreList.put("life",Integer.valueOf(scoreUtils.getTotalLifeScore(area).intValue()));
        scoreList.put("nature",Integer.valueOf(scoreUtils.getTotalNatureScore(area).intValue()));
        scoreList.put("residence",Integer.valueOf(scoreUtils.getTotalResidenceScore(area).intValue()));
        scoreList.put("security",Integer.valueOf(scoreUtils.getTotalSecurityScore(area).intValue()));
        scoreList.put("welfare", Integer.valueOf(scoreUtils.getTotalWelfareScore(area).intValue()));

        List<AreaBoardScoreResponse> areaBoardScoreResponses = AreaBoardScoreResponse.of(scoreList);

        List<Map<String, Map<String, Double>>> categoryAndScoreList = scoreUtils.getCategoryAndScoreList(area);


        List<AreaDetailBoardResponse> areaDetailBoardResponses=AreaDetailBoardResponse.of(categoryAndScoreList);

        List<AreaBoardCategoryScoreResponse> areaBoardCategoryScoreResponses = AreaBoardCategoryScoreResponse.of(areaDetailBoardResponses);

        return AreaBoardListResponse.of(
                String.valueOf(area.getRegion()),
                areaBoardScoreResponses,
                meanUtils.getMeanList(area),
                areaBoardCategoryScoreResponses
        );
    }

    @Override
    public void saveBoardOfArea(Long memberId, Long areaId) {
        MemberEntity memberEntity = memberJpaRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));

        Area area = areaJpaRepository.findById(areaId)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        memberAreaJpaRepository.findByMemberAndArea(memberEntity, area)
                .ifPresent(ma -> {
                    throw new DataException(DATA_IS_EXIST);
        });

        MemberAreaEntity memberArea = MemberAreaEntity.of(null, memberEntity, area);
        memberAreaJpaRepository.save(memberArea);
    }
}

