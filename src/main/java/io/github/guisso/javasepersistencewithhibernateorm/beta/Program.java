/*
 * Copyright (C) 2025 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.guisso.javasepersistencewithhibernateorm.beta;

import io.github.guisso.javasepersistencewithhibernateorm.beta.eventoesportivo.EventoEsportivoRepository;
import io.github.guisso.javasepersistencewithhibernateorm.beta.eventoesportivo.EventoEsportivo;

import io.github.guisso.javasepersistencewithhibernateorm.beta.atleta.Atleta;
import io.github.guisso.javasepersistencewithhibernateorm.beta.atleta.AtletaRepository;

import io.github.guisso.javasepersistencewithhibernateorm.beta.equipe.Equipe;
import io.github.guisso.javasepersistencewithhibernateorm.beta.equipe.EquipeRepository;

import io.github.guisso.javasepersistencewithhibernateorm.beta.partida.Partida;
import io.github.guisso.javasepersistencewithhibernateorm.beta.partida.PartidaRepository;

import io.github.guisso.javasepersistencewithhibernateorm.beta.setvolei.SetVolei;
import io.github.guisso.javasepersistencewithhibernateorm.beta.setvolei.SetVoleiRepository;
import io.github.guisso.javasepersistencewithhibernateorm.beta.tecnico.Tecnico;
import io.github.guisso.javasepersistencewithhibernateorm.beta.tecnico.TecnicoRepository;

import java.time.LocalDate;
import java.time.Month;

/**
 * Runs tests of the "Beta" version
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @since 0.1, Jul 1, 2025
 */
public class Program {

    public static void betaTests() {
        
        // Equipe
        EquipeRepository equipeRepository = new EquipeRepository(); 
        
        Equipe e1 = new Equipe();
        e1.setNome("Angicos");
        e1.setPago(true);
        
        Equipe e2 = new Equipe();
        e2.setNome("Retiro");
        e2.setPago(false);
        
        equipeRepository.saveOrUpdate(e1);
        System.out.println("> " + e1);
        equipeRepository.saveOrUpdate(e2);
        System.out.println("> " + e2);
        
        boolean excluded = equipeRepository.delete(e2);
        System.out.println("> " + (excluded ? "Excluded" : "Exclusion fails..."));
        
        // Evento esportivo 
        EventoEsportivoRepository eventoEsportivoRepository = new EventoEsportivoRepository();
        
        EventoEsportivo ee1 = new EventoEsportivo();
        ee1.setNome("Futebol volei");
        ee1.setData(LocalDate.of(2005, Month.APRIL, 7));
        ee1.setLocal("Moc");
        ee1.setIngressoTime(50.0);
        
        eventoEsportivoRepository.saveOrUpdate(ee1);
        System.out.println(">> " + ee1);
        
        ee1.setLocal("Ginasio Montes Claros");
        eventoEsportivoRepository.saveOrUpdate(ee1);
        
        EventoEsportivo ee2 = new EventoEsportivo();
        ee2.setNome("Quintou Soccer");
        ee2.setData(LocalDate.of(2025, Month.NOVEMBER, 15));
        ee2.setLocal("Cristalia - MG");
        ee2.setIngressoTime(25.0);
        
        eventoEsportivoRepository.saveOrUpdate(ee2);
        System.out.println(">> " + ee2);
        
        excluded = eventoEsportivoRepository.delete(ee2);
        System.out.println("> " + (excluded ? "Excluded" : "Exclusion fails..."));
        
        // Atleta
        Atleta at1 = new Atleta();
        at1.setNumeroCamisa(10);
        at1.setCpf(1234587456L);
        at1.setDate(LocalDate.of(2000, Month.AUGUST, 5));
        at1.setNome("Robert Carlos Nascimento Carvalho");
        
        AtletaRepository atletaRepository = new AtletaRepository();
        atletaRepository.saveOrUpdate(at1);
        
        // Partida
        PartidaRepository partidaRepository = new PartidaRepository();
        
        Partida part1 = new Partida();
        part1.setQuantidadeSets(5);
        
        partidaRepository.saveOrUpdate(part1);
        
        Partida part2 = new Partida();
        part2.setQuantidadeSets(3);
        
        partidaRepository.saveOrUpdate(part2);
        
        excluded = partidaRepository.delete(part1);
        System.out.println("> " + (excluded ? "Excluded" : "Exclusion fails..."));
        
        part2.setQuantidadeSets(8);
        partidaRepository.saveOrUpdate(part2);
        
        // SetVolei
        SetVoleiRepository setVoleiRepository = new SetVoleiRepository();
        
        SetVolei sv = new SetVolei(); 
        sv.setNumeroSet(3);
        sv.setPontuacao1(22);
        sv.setPontuacao2(19);
        
        setVoleiRepository.saveOrUpdate(sv);
        
        SetVolei sv2 = new SetVolei();
        sv2.setNumeroSet(5);
        sv2.setPontuacao1(5);
        sv2.setPontuacao2(10);
        
        setVoleiRepository.saveOrUpdate(sv2);
        
        sv2.setPontuacao1(21);
        setVoleiRepository.saveOrUpdate(sv2);
        
        setVoleiRepository.delete(sv2);
        
        // Tecnico
        Tecnico t1 = new Tecnico();
        t1.setCpf(123456L);
        t1.setDate(LocalDate.of(1980, Month.JANUARY, 15));
        t1.setNome("Joao da Silva Josefa");
   
        TecnicoRepository tecnicoRepository = new TecnicoRepository();
        
        tecnicoRepository.saveOrUpdate(t1);
        
        Tecnico t2 = new Tecnico();
        t2.setCpf(12345678L);
        t2.setDate(LocalDate.of(1988, Month.JANUARY, 17));
        t2.setNome("Joao Melao");
        
        tecnicoRepository.saveOrUpdate(t2);
   
    }
}