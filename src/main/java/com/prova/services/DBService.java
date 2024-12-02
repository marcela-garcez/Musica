package com.prova.services;

import com.prova.domains.Album;
import com.prova.domains.Cantor;
import com.prova.domains.Gravadora;
import com.prova.domains.Musica;
import com.prova.domains.enums.Popularidade;
import com.prova.repositories.AlbumRepository;
import com.prova.repositories.CantorRepository;
import com.prova.repositories.GravadoraRepository;
import com.prova.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private CantorRepository cantorRepo;

    @Autowired
    private GravadoraRepository gravadoraRepo;

    @Autowired
    private MusicaRepository musicaRepo;

    public void initDB(){

        Album album01 = new Album(null,"novas historias");
        Album album02 = new Album(null,"in the cities");
        Album album03 = new Album(null,"non stop pop");

        Cantor cantor01 = new Cantor(null,"Henrique e Juliano","Henrique e Juliano","Sertanejo","5584565536");
        Cantor cantor02 = new Cantor(null,"Cristiano de Melo Araujo","Cristiano Araujo","Sertanejo","9848354545");
        Cantor cantor03 = new Cantor(null,"Robyn Rihanna Fenty","Rihanna","pop","87454641665");

        Gravadora gravadora01 = new Gravadora(null,"Som Livre","44545448998854","São Paulo");
        Gravadora gravadora02 = new Gravadora(null,"Vevo","854854564336","Rio de Janeiro");

        Musica musica01 = new Musica(null,"Na hora da Raiva","Sertanejo","2:56","2016",cantor01,album01,gravadora02, Popularidade.BOA);
        Musica musica02 = new Musica(null,"Ele quer ser eu","Sertanejo","2:45","2016",cantor01,album01,gravadora02, Popularidade.MEDIA);
        Musica musica03 = new Musica(null,"Caso Indefinido","Sertanejo","5:25","2013",cantor02,album02,gravadora01, Popularidade.BOA);
        Musica musica04 = new Musica(null,"Only Girl","Pop","3:55","2010",cantor03,album03,gravadora02, Popularidade.BOA);



        albumRepo.save(album01);
        albumRepo.save(album02);
        albumRepo.save(album03);

        cantorRepo.save(cantor01);
        cantorRepo.save(cantor02);
        cantorRepo.save(cantor03);

        gravadoraRepo.save(gravadora01);
        gravadoraRepo.save(gravadora02);

        musicaRepo.save(musica01);
        musicaRepo.save(musica02);
        musicaRepo.save(musica03);
        musicaRepo.save(musica04);

    }
}
