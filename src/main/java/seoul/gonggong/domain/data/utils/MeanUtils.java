package seoul.gonggong.domain.data.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoul.gonggong.domain.data.domain.*;
import seoul.gonggong.domain.data.dto.response.MeanScoreResponse;
import seoul.gonggong.domain.data.repository.*;
import seoul.gonggong.domain.exception.DataException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static seoul.gonggong.global.error.status.ErrorStatus.DATA_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class MeanUtils {
    private final AreaJpaRepository areaJpaRepository;
    private final EducationJpaRepository educationJpaRepository;
    private final LifeJpaRepository lifeJpaRepository;
    private final NatureJpaRepository natureJpaRepository;
    private final ResidenceJpaRepository residenceJpaRepository;
    private final SecurityJpaRepository securityJpaRepository;
    private final WelfareCultureJpaRepository welfareCultureJpaRepository;
    private final PopulationJpaRepository populationJpaRepository;

    //Nature
    public Double co2Mean(Area area) {
        Nature nature = natureJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return nature.getCoMeanMean();
    }
    public Double pm10Mean(Area area) {
        Nature nature = natureJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return nature.getPm10Mean();
    }
    public Double greenSumMean(Area area) {
        Nature nature = natureJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return nature.getGreenSumMean();
    }

    // Education
    public Double elementarySchoolMean(Area area) {
        Education education = educationJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return education.getElementarySchoolMean();
    }

    public Double middleSchoolMean(Area area) {
        Education education = educationJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return education.getMiddleSchoolMean();
    }

    public Double highSchoolMean(Area area) {
        Education education = educationJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return education.getHighSchoolMean();
    }

    // Residence
    public Double landPriceMean(Area area) {
        Residence residence = residenceJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return residence.getLandPriceMean();
    }

    public Double landAreaMean(Area area) {
        Residence residence = residenceJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return residence.getLandAreaMean();
    }

    public Double expansionRateMean(Area area) {
        Residence residence = residenceJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return residence.getExpansionRateMean();
    }

    // WelfareCulture
    public Double cultureFacilityMean(Area area) {
        WelfareCulture welfareCulture = welfareCultureJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return welfareCulture.getCultureFacilityMean();
    }

    public Double gymFacilityMean(Area area) {
        WelfareCulture welfareCulture = welfareCultureJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return welfareCulture.getGymFacilityMean();
    }

    // Population - 모든 세부 카테고리에 대한 평균 점수 메소드
    public Double onePersonHouseWholeRateMean(Area area) {
        Population population = populationJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return population.getOnePersonHouseWholeRateMean();
    }

    public Double youthPeopleMean(Area area) {
        Population population = populationJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return population.getYouthPeopleMean();
    }

    public Double productivePeopleMean(Area area) {
        Population population = populationJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return population.getProductivePeopleMean();
    }

    public Double oldPeopleMean(Area area) {
        Population population = populationJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return population.getOldPeopleMean();
    }


    // Security
    public Double accidentMean(Area area) {
        Security security = securityJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return Double.valueOf(security.getAccidentMean());
    }

    public Double criminalMean(Area area) {
        Security security = securityJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return Double.valueOf(security.getCriminalMean());
    }

    public Double lifeSecurityMean(Area area) {
        Security security = securityJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return Double.valueOf(security.getLifeSecurityMean());
    }

    public Double suicideMean(Area area) {
        Security security = securityJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return Double.valueOf(security.getSuicideMean());
    }

    public Double fireMean(Area area) {
        Security security = securityJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return Double.valueOf(security.getFireMean());
    }

    public Double cctvMean(Area area) {
        Security security = securityJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return Double.valueOf(security.getCctvMean());
    }

    // Life
    public Double busStationNumberMean(Area area) {
        Life life = lifeJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return life.getBusStationNumberMean();
    }

    public Double subwayStationNumberMean(Area area) {
        Life life = lifeJpaRepository.findByArea(area).orElseThrow(() -> new DataException(DATA_NOT_FOUND));
        return life.getSubwayStationNumberMean();
    }
    public List<MeanScoreResponse> getMeanList(Area area) {
        Map<String, Double> data = new HashMap<>();

        // Nature
        data.put("co2Mean", co2Mean(area));
        data.put("pm10Mean", pm10Mean(area));
        data.put("greenSumMean", greenSumMean(area));

        // Education
        data.put("elementarySchoolMean", elementarySchoolMean(area));
        data.put("middleSchoolMean", middleSchoolMean(area));
        data.put("highSchoolMean", highSchoolMean(area));

        // Life
        data.put("busStationNumberMean", busStationNumberMean(area));
        data.put("subwayStationNumberMean", subwayStationNumberMean(area));

        // Population
        data.put("onePersonHouseWholeRateMean", onePersonHouseWholeRateMean(area));
        data.put("youthPeopleMean", youthPeopleMean(area));
        data.put("productivePeopleMean", productivePeopleMean(area));
        data.put("oldPeopleMean", oldPeopleMean(area));

        // Residence
        data.put("landPriceMean", landPriceMean(area));
        data.put("landAreaMean", landAreaMean(area));
        data.put("expansionRateMean", expansionRateMean(area));

        // Security
        data.put("accidentMean", accidentMean(area));
        data.put("criminalMean", criminalMean(area));
        data.put("lifeSecurityMean", lifeSecurityMean(area));
        data.put("suicideMean", suicideMean(area));
        data.put("fireMean", fireMean(area));
        data.put("cctvMean", cctvMean(area));

        // WelfareCulture
        data.put("cultureFacilityMean", cultureFacilityMean(area));
        data.put("gymFacilityMean", gymFacilityMean(area));

        return MeanScoreResponse.of(data);
    }




}
