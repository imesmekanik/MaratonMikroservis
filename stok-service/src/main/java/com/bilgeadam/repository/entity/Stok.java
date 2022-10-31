package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Table(name = "tblstok")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String urunadi;
    String urunno;
    Integer adet;
}