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
package io.github.guisso.javasepersistencewithhibernateorm.beta.tecnico;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robert
 */
public class TecnicoRepository 
        extends Repository<Tecnico>{

  @Override
    public String getJpqlFindAll() {
        return "SELECT t FROM Tecnico t";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT t FROM Tecnico t t.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Tecnico t WHERE t.id = :id";
    }
        public void moveToTrash(Tecnico tecnico) {
        tecnico.setLixo(true);
        this.saveOrUpdate(tecnico);
    }

    public void moveToTrash(List<Tecnico> tecnico) {
        for (Tecnico aux : tecnico) {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }

    public List<Tecnico> loadFromTrash() {

       List<Tecnico> aux = new ArrayList<>();
        aux = this.findAll();
        List<Tecnico> excluidos = new ArrayList<>();
        for(Tecnico temp : aux)
        {
            if(temp.isLixo() == true)
            {
                excluidos.add(temp);
            }      
        }
        return excluidos; 
    }
    
    public List<Tecnico> loadFromDataBase() {

       List<Tecnico> aux = new ArrayList<>();
        aux = this.findAll();
        List<Tecnico> incluidos = new ArrayList<>();
        for(Tecnico temp : aux)
        {
            if(temp.isLixo() == false)
            {
                incluidos.add(temp);
            }      
        }
        return incluidos; 
    }

    public void restoreFromTrash(Tecnico tecnico) {
        tecnico.setLixo(false);
        this.saveOrUpdate(tecnico);
    }

    public void restoreFromTrash(List<Tecnico> tecnico) {
        for (Tecnico aux : tecnico) {
            aux.setLixo(false);
            this.saveOrUpdate(aux); 
        }
    }
       public void moveToTrash(Long partidaId) {
        Tecnico partidaParaMover = this.findById(partidaId);
        if (partidaParaMover != null) {
            partidaParaMover.setLixo(true);
            this.saveOrUpdate(partidaParaMover);
        } else {
            throw new IllegalArgumentException("Partida com ID " + partidaId + " não encontrada.");
        }
    }
    
    public void restoreFromTrash(Long partidaId) {
        Tecnico partidaParaRestaurar = this.findById(partidaId);
        if (partidaParaRestaurar != null) {
            partidaParaRestaurar.setLixo(false);
            this.saveOrUpdate(partidaParaRestaurar);
        } else {
            throw new IllegalArgumentException("Partida com ID " + partidaId + " não encontrada.");
        }
    }
    
}
