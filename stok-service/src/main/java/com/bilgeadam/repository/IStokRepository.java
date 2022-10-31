package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Stok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStokRepository extends JpaRepository<Stok,Long> {

    Optional<List<Stok>> findOptionalByUrunadiContaining(String urunadi);
    Optional<Stok> findOptionalByUrunadi(String urunadi);

}
