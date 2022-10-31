package com.bilgeadam.service;



import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.request.StokSaveRequestDto;
import com.bilgeadam.dto.request.UrunUpdateRequestDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.manager.StokManager;
import com.bilgeadam.repository.IUrunRepository;
import com.bilgeadam.repository.entity.Urun;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;

@Service
public class UrunService extends ServiceManager<Urun,Long> {
    private final IUrunRepository repository;
    private final StokManager stokManager;

    public UrunService(IUrunRepository repository,StokManager stokManager) {
        super(repository);
        this.repository = repository;
        this.stokManager=stokManager;

    }
    public Boolean save(RegisterRequestDto dto){
        Urun urun= Urun.builder().urunadi(dto.getUrunadi()).urunno(dto.getUrunno()).build();
        Integer adet=repository.urunadedi(urun.getUrunadi());

        if(adet==0) {
            urun.setAdet(adet+1);
            save(urun);
            if (urun.getId() != null) {
                stokManager.save(StokSaveRequestDto.builder()
                        .urunadi(dto.getUrunadi()).urunno(dto.getUrunno()).adet(adet + 1).build());
            }
        }
        else{

            Urun temp=repository.findOptionalByUrunadi(dto.getUrunadi()).get();
            temp.setAdet(temp.getAdet()+1);
            save(temp);
            stokManager.save(StokSaveRequestDto.builder()
                    .urunadi(dto.getUrunadi()).urunno(dto.getUrunno()).adet(temp.getAdet() + 1).build());

        }
        return true;
    }

}