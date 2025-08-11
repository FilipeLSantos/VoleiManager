/*
 * Copyright (C) 2025 robert
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
package io.github.guisso.javasepersistencewithhibernateorm.beta.partida;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.DataSourceFactory;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robert
 */

@Entity
public class PartidaRepository 
        extends Repository<Partida>{

    private static final long serialVersionUID = 1L;
   
     @Override
    public String getJpqlFindAll() {
        return "SELECT p FROM Partida p";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT p FROM Equipe p p = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Partida  p WHERE p.id = :id";
    }
    
    public void moveToTrash(Partida partida) {
        partida.setLixo(true);
        this.saveOrUpdate(partida);
    }

    public void moveToTrash(List<Partida> atleta) {
        for (Partida aux : atleta) {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }

    public List<Partida> loadFromTrash() {

       List<Partida> aux = new ArrayList<>();
        aux = this.findAll();
        List<Partida> excluidos = new ArrayList<>();
        for(Partida temp : aux)
        {
            if(temp.isLixo() == true)
            {
                excluidos.add(temp);
            }      
        }
        return excluidos; 
    }
    
    public List<Partida> loadFromDataBase() {

       List<Partida> aux = new ArrayList<>();
        aux = this.findAll();
        List<Partida> incluidos = new ArrayList<>();
        for(Partida temp : aux)
        {
            if(temp.isLixo() == false)
            {
                incluidos.add(temp);
            }      
        }
        return incluidos; 
    }

    public void restoreFromTrash(Partida partidas) {
        partidas.setLixo(false);
        this.saveOrUpdate(partidas);
    }

    public void restoreFromTrash(List<Partida> partidas) {
        for (Partida aux : partidas) {
            aux.setLixo(false);
            this.saveOrUpdate(aux); 
        }
    }
    public void moveToTrash(Long partidaId) {
        Partida partidaParaMover = this.findById(partidaId);
        if (partidaParaMover != null) {
            partidaParaMover.setLixo(true);
            this.saveOrUpdate(partidaParaMover);
        } else {
            throw new IllegalArgumentException("Partida com ID " + partidaId + " não encontrada.");
        }
    }
    
    public void restoreFromTrash(Long partidaId) {
        Partida partidaParaRestaurar = this.findById(partidaId);
        if (partidaParaRestaurar != null) {
            partidaParaRestaurar.setLixo(false);
            this.saveOrUpdate(partidaParaRestaurar);
        } else {
            throw new IllegalArgumentException("Partida com ID " + partidaId + " não encontrada.");
        }
    }
    
}
