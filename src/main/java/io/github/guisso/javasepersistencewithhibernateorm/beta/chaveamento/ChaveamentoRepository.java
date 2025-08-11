/*
 * Copyright (C) 2025 SamuelParanhos
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
package io.github.guisso.javasepersistencewithhibernateorm.beta.chaveamento;


import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import jakarta.persistence.Entity;
import io.github.guisso.javasepersistencewithhibernateorm.beta.chaveamento.Chaveamento;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SamuelParanhos
 */

public class ChaveamentoRepository 
        extends Repository<Chaveamento>{

    @Override
    public String getJpqlFindAll() {
        return "SELECT a FROM Chaveamento a";
        //WHERE a.lixo = false
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT a FROM Chaveamento a a.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Chaveamento a WHERE e.id = :id";
    }
     
    public void moveToTrash(Chaveamento chaveamento)
    {
        chaveamento.setLixo(true);
        this.saveOrUpdate(chaveamento);
    }
    public void moveToTrash(List<Chaveamento> atleta)
    {
        for(Chaveamento aux : atleta)
        {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }
    public List<Chaveamento> loadFromTrash()
    {
        List<Chaveamento> aux = new ArrayList<>();
        aux = this.findAll();
        List<Chaveamento> excluidos = new ArrayList<>();
        for(Chaveamento temp : aux)
        {
            if(temp.isLixo() == true)
            {
                excluidos.add(temp);
            }      
        }
        return excluidos; 
    }
    
    public List<Chaveamento> loadFromDataBase()
    {
        List<Chaveamento> aux = new ArrayList<>();
        aux = this.findAll();
        List<Chaveamento> incluidos = new ArrayList<>();
        for(Chaveamento temp : aux)
        {
            if(temp.isLixo() == false)
            {
                incluidos.add(temp);
            }      
        }
        return incluidos; 
    }
    public void restoreFromTrash(Chaveamento chaveamento) {
        chaveamento.setLixo(false);
        this.saveOrUpdate(chaveamento);
    }

    public void restoreFromTrash(List<Chaveamento> chaveamento) {
        for (Chaveamento aux : chaveamento) {
            aux.setLixo(false);
            this.saveOrUpdate(aux); 
        }
    }
    
    
}
