package com.app.restful.api;

import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.CongestionDTO;
import com.app.restful.domain.dto.PetTourDTO;
import com.app.restful.service.OpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/open-apis")
@RequiredArgsConstructor
public class OpenApi {

    private final OpenApiService openApiService;

    @GetMapping("/pet-tour-list")
    public ResponseEntity<ApiResponseDTO<List<PetTourDTO>>> getPetTourList() throws IOException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("펫 투어 리스트 조회 완료", openApiService.fetchData()));
    }

    @GetMapping("/congestion")
    public ResponseEntity<ApiResponseDTO<CongestionDTO>> getCongestionList() throws IOException, URISyntaxException {

        CongestionDTO congestionDTO = openApiService.fetchData2();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("지하철 혼잡도 조회 완료", congestionDTO));
    }
}
