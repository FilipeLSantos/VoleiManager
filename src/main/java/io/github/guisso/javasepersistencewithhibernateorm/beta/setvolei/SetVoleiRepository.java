/*
 * Copyright (C) 2025 Filipe
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
package io.github.guisso.javasepersistencewithhibernateorm.beta.setvolei;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class SetVoleiRepository 
        extends Repository<SetVolei>{

    @Override
    public String getJpqlFindAll() {
        return "SELECT sv FROM SetVolei sv";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT sv FROM SetVolei sv sv.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM SetVolei sv WHERE sv.id = :id";
    }
    
    public void moveToTrash(SetVolei setVolei) {
        setVolei.setLixo(true);
        this.saveOrUpdate(setVolei);
    }
    public void moveToTrash(List<SetVolei> setVolei) {
        for (SetVolei aux : setVolei) {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }

    public List<SetVolei> loadFromTrash() {

       List<SetVolei> aux = new ArrayList<>();
        aux = this.findAll();
        List<SetVolei> excluidos = new ArrayList<>();
        for(SetVolei temp : aux)
        {
            if(temp.isLixo() == true)
            {
                excluidos.add(temp);
            }      
        }
        return excluidos; 
    }
    
    public List<SetVolei> loadFromDataBase() {

       List<SetVolei> aux = new ArrayList<>();
        aux = this.findAll();
        List<SetVolei> incluidos = new ArrayList<>();
        for(SetVolei temp : aux)
        {
            if(temp.isLixo() == false)
            {
                incluidos.add(temp);
            }      
        }
        return incluidos; 
    }

    public void restoreFromTrash(SetVolei setVolei) {
        setVolei.setLixo(false);
        this.saveOrUpdate(setVolei);
    }

    public void restoreFromTrash(List<SetVolei> setVolei) {
        for (SetVolei aux : setVolei) {
            aux.setLixo(false);
            this.saveOrUpdate(aux); 
        }
    }
     public void moveToTrash(Long setVoleiId) {
        SetVolei setVoleiParaMover = this.findById(setVoleiId);
        if (setVoleiParaMover != null) {
            setVoleiParaMover.setLixo(true);
            this.saveOrUpdate(setVoleiParaMover);
        } else {
            throw new IllegalArgumentException("Partida com ID " + setVoleiId + " não encontrada.");
        }
    }
    
    public void restoreFromTrash(Long setVoleiId) {
        SetVolei setVoleiParaRestaurar = this.findById(setVoleiId);
        if (setVoleiParaRestaurar != null) {
            setVoleiParaRestaurar.setLixo(false);
            this.saveOrUpdate(setVoleiParaRestaurar);
        } else {
            throw new IllegalArgumentException("Partida com ID " + setVoleiId + " não encontrada.");
        }
    }
}
