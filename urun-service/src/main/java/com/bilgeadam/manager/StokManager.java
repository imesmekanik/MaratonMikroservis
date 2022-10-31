package com.bilgeadam.manager;

import com.bilgeadam.dto.request.StokSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name="stok-profile-service",url = "http://localhost:9092/stok",decode404 = true)
public interface StokManager {

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody StokSaveRequestDto dto);

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(Long id);
}
