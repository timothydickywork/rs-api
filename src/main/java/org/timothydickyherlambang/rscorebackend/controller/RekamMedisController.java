package org.timothydickyherlambang.rscorebackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.timothydickyherlambang.rscorebackend.dto.ApiResponse;
import org.timothydickyherlambang.rscorebackend.dto.PasienRekamMedisResponse;
import org.timothydickyherlambang.rscorebackend.dto.RekamMedisResponse;
import org.timothydickyherlambang.rscorebackend.service.RekamMedisService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rekam_medis")
public class RekamMedisController {

    private final RekamMedisService rekamMedisService;

    public RekamMedisController(RekamMedisService rekamMedisService) {
        this.rekamMedisService = rekamMedisService;
    }

    @GetMapping("/search-pasien")
    @Operation(summary = "Search Rekam Medis By Pasien Name, Minimum 3 search character.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Rekam Medis retrieved successfully",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class),
                            examples = @ExampleObject(value = """
                                    {"success":true,"message":"Rekam Medis retrieved successfully","data":[{"id_pemeriksaan":"7e3c434b-f1e3-4f4a-b3c8-bc06796f5ed1","nama_pasien":"Timothy Dicky Herlambang","nomor_rekam_medis":"P01-20261110-0002","nama_dokter":"Hari Prasetyo","status_pemeriksaan":"Proses Periksa"]}""")))
    })
    public ResponseEntity<ApiResponse<List<RekamMedisResponse>>> searchPasien(@RequestParam("search") String search) {
        return ResponseEntity.ok(ApiResponse.success("Rekam Medis retrieved successfully", rekamMedisService.searchPasien(search)));
    }

    @GetMapping("/pasien-by-no-rekam-medis")
    @Operation(summary = "Search Pasien By Nomor Rekam Medis,")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Pasien retrieved successfully",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class),
                            examples = @ExampleObject(value = """
                                    {"success":true,"message":"Pasien retrieved successfully","data":[{"nomor_rekam_medis":"P01-20261110-0001","nama_pasien":"Timothy Dicky Herlambang","dob_pasien":"1997-10-02","usia":"29 tahun 1 bulan","address":"Jl. Test, Yogyakarta"]}""")))
    })
    public ResponseEntity<ApiResponse<PasienRekamMedisResponse>> findPasienByNomorRekamMedis(@RequestParam("nomor_rekam_medis") String nomor_rekam_medis) {
        return ResponseEntity.ok(ApiResponse.success("Rekam Medis retrieved successfully", rekamMedisService.findPasienByNomorRekamMedis(nomor_rekam_medis)));
    }
}
