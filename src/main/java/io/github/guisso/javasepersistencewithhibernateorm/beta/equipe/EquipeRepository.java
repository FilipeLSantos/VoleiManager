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
package io.github.guisso.javasepersistencewithhibernateorm.beta.equipe;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.DataSourceFactory;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author robert
 */
@Entity
public class EquipeRepository
        extends Repository<Equipe> {

    @Override
    public String getJpqlFindAll() {
        return "SELECT e FROM Equipe e ";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT e FROM Equipe e e.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Equipe e WHERE e.id = :id";
    }

    public void moveToTrash(Equipe equipe) {
        equipe.setLixo(true);
        this.saveOrUpdate(equipe);
    }

    public void moveToTrash(List<Equipe> atleta) {
        for (Equipe aux : atleta) {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }

    public List<Equipe> loadFromTrash() {

       List<Equipe> aux = new ArrayList<>();
        aux = this.findAll();
        List<Equipe> excluidos = new ArrayList<>();
        for(Equipe temp : aux)
        {
            if(temp.isLixo() == true)
            {
                excluidos.add(temp);
            }      
        }
        return excluidos; 
    }
    
    public List<Equipe> loadFromDataBase() {

       List<Equipe> aux = new ArrayList<>();
        aux = this.findAll();
        List<Equipe> incluidos = new ArrayList<>();
        for(Equipe temp : aux)
        {
            if(temp.isLixo() == false)
            {
                incluidos.add(temp);
            }      
        }
        return incluidos; 
    }

    public void restoreFromTrash(Equipe equipe) {
        equipe.setLixo(false);
        this.saveOrUpdate(equipe);
    }

    public void restoreFromTrash(List<Equipe> equipes) {
        for (Equipe aux : equipes) {
            aux.setLixo(false);
            this.saveOrUpdate(aux); 
        }
    }
    public void moveToTrash(Long equipeId) {
        Equipe equipeParaMover = this.findById(equipeId);
        if (equipeParaMover != null) {
            equipeParaMover.setLixo(true);
            this.saveOrUpdate(equipeParaMover);
        } else {
            throw new IllegalArgumentException("Partida com ID " + equipeId + " não encontrada.");
        }
    }
    
    public void restoreFromTrash(Long equipeId) {
        Equipe equipeParaRestaurar = this.findById(equipeId);
        if (equipeParaRestaurar != null) {
            equipeParaRestaurar.setLixo(false);
            this.saveOrUpdate(equipeParaRestaurar);
        } else {
            throw new IllegalArgumentException("Partida com ID " + equipeId + " não encontrada.");
        }
    }
}
