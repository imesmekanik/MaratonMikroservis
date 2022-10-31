package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUrunRepository extends JpaRepository<Urun,Long> {
    Optional<Urun> findOptionalByUrunadi(String urunadi);
    @Query("select count(e.urunadi) from Urun e where e.urunadi = ?1")
    Integer urunadedi(String urunadi);
}
