package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StokSaveRequestDto {
    String urunadi;
    String urunno;
    Integer adet;
}