package pl.kietlinski.iolab1serwer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import pl.kietlinski.iolab1serwer.entity.Motto;
import pl.kietlinski.iolab1serwer.repository.MottoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MottoService {

    private MottoRepository mottoRepository;
    private List<Motto> mottoList;

    @Autowired
    public MottoService(MottoRepository mottoRepository) {
        this.mottoRepository = mottoRepository;
        initMottoRepository();
        this.mottoList = new ArrayList<>();
        initMottoList();
    }

    private void initMottoRepository() {
        mottoRepository.deleteAll();
        mottoRepository.save(new Motto("Szczęście nie przychodzi z zewnątrz. Zależy od tego, co jest w nas samych.", "Dale Carnegie"));
        mottoRepository.save(new Motto("Gdy zmieniamy nasze myślenie, zmieniamy naszą rzeczywistość.", "Louise L. Hay"));
        mottoRepository.save(new Motto("Nasze życie zawsze pokazuje rezultat naszych dominujących myśli.", "Soren Kierkegaard"));
        mottoRepository.save(new Motto("Kochać samego siebie - to początek romansu na całe życie.", "Oskar Wilde"));
        mottoRepository.save(new Motto("Czerp z innych, ale nie kopiuj ich. Bądź SOBĄ.", "Michel Quois"));
        mottoRepository.save(new Motto("Wszystko jest możliwe. Niemożliwe wymaga po prostu więcej czasu.", "Dan Brown"));
        mottoRepository.save(new Motto("By zyskać miłość… wypełnij się nią, aż staniesz się magnesem.", "Rhonda Byrne"));
    }

    private void initMottoList() {
        mottoList = mottoRepository.findAll();
    }

    public Motto getMotto(){
        return mottoList.get(new Random().nextInt(mottoList.size()));
    }
}
