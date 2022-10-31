package com.bilgeadam.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblurun")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String urunadi;
    String urunno;
    Integer adet;

}