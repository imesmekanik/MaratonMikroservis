package com.bilgeadam.service;

import com.bilgeadam.dto.request.StokSaveRequestDto;
import com.bilgeadam.repository.IStokRepository;
import com.bilgeadam.repository.entity.Stok;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StokService extends ServiceManager<Stok,Long> {
    private final IStokRepository repository;

    public StokService(IStokRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Boolean save(StokSaveRequestDto dto){

        if(dto.getAdet()==1) {
            Stok stok = Stok.builder().urunadi(dto.getUrunadi()).urunno(dto.getUrunno()).adet(dto.getAdet()).build();
            save(stok);
        }
        else{
            Stok temp=repository.findOptionalByUrunadi(dto.getUrunadi()).get();
            temp.setAdet(temp.getAdet()+1);
            save(temp);
        }
        return true;
    }


    public Optional<List<Stok>> arama(String urunadi) {
        return repository.findOptionalByUrunadiContaining(urunadi);
    }
}
