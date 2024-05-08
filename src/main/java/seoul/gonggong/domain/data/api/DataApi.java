package seoul.gonggong.domain.data.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seoul.gonggong.domain.data.application.DataService;
import seoul.gonggong.domain.data.application.DataServiceImpl;
import seoul.gonggong.domain.data.dto.request.AreaStandardRequest;
import seoul.gonggong.domain.data.dto.response.AreaBoardListResponse;
import seoul.gonggong.domain.data.dto.response.AreaScoreListResponse;
import seoul.gonggong.global.ApiResponse;
import seoul.gonggong.global.utils.SecurityUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/data")
public class DataApi {
    private final DataService dataService;

    @PostMapping("/areas")
    public ApiResponse<AreaScoreListResponse> getAreaListPriority(@RequestBody AreaStandardRequest areaStandardRequest) {
        return ApiResponse.onSuccess(dataService.getAreaListByInputScore(areaStandardRequest));
    }

    @GetMapping("/{areaId}/board")
    public ApiResponse<AreaBoardListResponse> getBoardOfArea(@PathVariable Long areaId) {
        return ApiResponse.onSuccess(dataService.getBoardOfArea(areaId));
    }

    @PostMapping("/{areaId}/board")
    public ApiResponse<?> saveBoardOfArea(@PathVariable Long areaId) {
        dataService.saveBoardOfArea(SecurityUtil.getCurrentMemberId(), areaId);
        return ApiResponse.onSuccess("성공적으로 저장되었습니다.");
    }

//    @GetMapping("/areas/boards")
//    public ApiResponse<AreaLikeResponse> getAreaLikeList() {
//        return ApiResponse.onSuccess(dataService.getLikeAreaList());
//    }

}
