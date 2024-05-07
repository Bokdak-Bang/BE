package seoul.gonggong.domain.data.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seoul.gonggong.domain.data.application.DataServiceImpl;
import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.dto.response.AreaScoreListResponse;
import seoul.gonggong.global.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/data")
public class DataApi {
    private final DataServiceImpl dataService;

    @PostMapping("/regions")
    public ApiResponse<AreaScoreListResponse> getAreaListPriority(@RequestBody AreaStandardRequest areaStandardRequest) {
        return ApiResponse.onSuccess(dataService.getAreaListByInputScore(areaStandardRequest));
    }
}
