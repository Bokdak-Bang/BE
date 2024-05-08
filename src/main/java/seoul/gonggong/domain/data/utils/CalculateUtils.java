package seoul.gonggong.domain.data.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoul.gonggong.domain.data.domain.*;
import seoul.gonggong.domain.data.repository.*;
import seoul.gonggong.domain.exception.DataException;

import java.util.HashMap;
import java.util.Map;

import static seoul.gonggong.global.error.status.ErrorStatus.DATA_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class CalculateUtils {
    private final EducationJpaRepository educationJpaRepository;
    private final LifeJpaRepository lifeJpaRepository;
    private final NatureJpaRepository natureJpaRepository;
    private final ResidenceJpaRepository residenceJpaRepository;
    private final SecurityJpaRepository securityJpaRepository;
    private final WelfareCultureJpaRepository welfareCultureJpaRepository;
    private final PopulationJpaRepository populationJpaRepository;
    private ScoreUtils scoreUtils;

    public Map<String, Map<String, Double>> getEducationCategoryList(Area area) {

        Education education = educationJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> detailScore = new HashMap<>();

        detailScore.put("elementschool", Double.valueOf(education.getElementarySchool()));
        detailScore.put("middleschool", Double.valueOf(education.getMiddleSchool()));
        detailScore.put("highschool", Double.valueOf(education.getHighSchool()));

        data.put(
                "education",
                detailScore
        );


        return data;
    }

    public Map<String, Map<String, Double>> getNatureCategoryList(Area area) {
        Nature nature = natureJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> detailScore = new HashMap<>();

        detailScore.put("co2Mean", Double.valueOf(nature.getCoMean()));
        detailScore.put("pm10Mean", Double.valueOf(nature.getPm10Mean()));
        detailScore.put("greenSum", Double.valueOf(nature.getGreenSum()));

        data.put(
                "nature",
                detailScore
        );
        return data;
    }

    public Map<String, Map<String, Double>> getPopulationCategoryList(Area area) {
        Population population = populationJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> detailScore = new HashMap<>();

        detailScore.put("onePersonHouseWholeRate", Double.valueOf(population.getOnePersonHouseWholeRate()));
        detailScore.put("youthPeople", Double.valueOf(population.getYouthPeople()));
        detailScore.put("productivePeople", Double.valueOf(population.getProductivePeople()));
        detailScore.put("oldPeople", Double.valueOf(population.getOldPeople()));

        data.put(
                "population",
                detailScore
        );
        return data;
    }

    public Map<String, Map<String, Double>> getResidenceCategoryList(Area area) {
        Residence residence = residenceJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> detailScore = new HashMap<>();

        detailScore.put("landPrice", Double.valueOf(residence.getLandPrice()));
        detailScore.put("landArea", Double.valueOf(residence.getLandArea()));
        detailScore.put("expansionRate", Double.valueOf(residence.getExpansionRate()));

        data.put(
                "resdience",
                detailScore
        );
        return data;
    }

    public Map<String, Map<String, Double>> getSecurityCategoryList(Area area) {
        Security security = securityJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> detailScore = new HashMap<>();

        detailScore.put("accident", Double.valueOf(security.getAccident()));
        detailScore.put("criminal", Double.valueOf(security.getCriminal()));
        detailScore.put("lifeSecurity", Double.valueOf(security.getLifeSecurity()));
        detailScore.put("suicide", Double.valueOf(security.getSuicide()));
        detailScore.put("fire", Double.valueOf(security.getFire()));
        detailScore.put("cctv", Double.valueOf(security.getCctv()));


        data.put(
                "security",
                detailScore
        );
        return data;
    }

    public Map<String, Map<String, Double>> getWelfareCultureCategoryList(Area area) {
        WelfareCulture welfareCulture = welfareCultureJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> detailScore = new HashMap<>();

        detailScore.put("cultureFacility", Double.valueOf(welfareCulture.getCultureFacility()));
        detailScore.put("gymFacility", Double.valueOf(welfareCulture.getGymFacility()));

        data.put(
                "welfareculture",
                detailScore
        );
        return data;
    }

    public Map<String, Map<String, Double>> getLifeCategoryList(Area area) {
        Life life = lifeJpaRepository.findByArea(area)
                .orElseThrow(() -> new DataException(DATA_NOT_FOUND));

        Map<String, Map<String, Double>> data = new HashMap<>();
        Map<String, Double> detailScore = new HashMap<>();

        detailScore.put("busStationNumber", Double.valueOf(life.getBusStationNumber()));
        detailScore.put("subwayStationNumber", Double.valueOf(life.getSubwayStationNumber()));

        data.put(
                "life",
                detailScore
        );
        return data;
    }
}
