package com.bilgeadam.controller;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.request.UrunUpdateRequestDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UrunServiceException;
import com.bilgeadam.manager.StokManager;
import com.bilgeadam.repository.entity.Urun;
import com.bilgeadam.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import static com.bilgeadam.constants.ApiUrls.*;
@RestController
@RequestMapping(URUN)
@RequiredArgsConstructor
public class UrunController {

    private final UrunService urunService;
    private final StokManager stokManager;

    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        if (urunService.save(dto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping(URUNLISTE)
    public ResponseEntity<List<Urun>> urunList(){
        return ResponseEntity.ok(urunService.findAll());
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Void> delete(Long id){
        if(urunService.findById(id)!=null){
            urunService.deleteById(id);
            stokManager.delete(id);
            }
        else {
            throw new UrunServiceException(ErrorType.GECERSIZ_ID);
        }
        return ResponseEntity.ok().build();
    }
}