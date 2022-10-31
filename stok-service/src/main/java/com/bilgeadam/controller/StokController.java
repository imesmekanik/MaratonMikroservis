package com.bilgeadam.controller;

import com.bilgeadam.dto.request.StokSaveRequestDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.StokServiceException;
import com.bilgeadam.repository.entity.Stok;
import com.bilgeadam.service.StokService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import static com.bilgeadam.constants.ApiUrls.*;

@RestController
@RequestMapping(STOK)
@RequiredArgsConstructor
public class StokController {

    private final StokService stokService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid StokSaveRequestDto dto) {
        if (stokService.save(dto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(STOKLISTE)
    public ResponseEntity<List<Stok>> stokList(){
        return ResponseEntity.ok(stokService.findAll());
    }

    @GetMapping(STOKARAMA)
    public ResponseEntity<List<Stok>> arama(String urunadi){
        return ResponseEntity.ok(stokService.arama(urunadi).get());
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Void> delete(Long id){
        if(stokService.findById(id)!=null){
            stokService.deleteById(id);}
        else {
            throw new StokServiceException(ErrorType.GECERSIZ_ID);
        }
        return ResponseEntity.ok().build();
    }
}