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
package io.github.guisso.javasepersistencewithhibernateorm.rodada;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import io.github.guisso.javasepersistencewithhibernateorm.rodada.Rodada;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author robert
 */
public class RodadaRepository 
        extends Repository<Rodada>{
     private static final long serialVersionUID = 1L;

    @Override
    public String getJpqlFindAll() {
        return "SELECT r FROM Rodada r";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT r FROM Rodada r r.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Rodada r WHERE r.id = :id";
    }
         
    public void moveToTrash(Rodada rodada)
    {
        rodada.setLixo(true);
        this.saveOrUpdate(rodada);
    }
    public void moveToTrash(List<Rodada> eventoEsportivo)
    {
        for(Rodada aux : eventoEsportivo)
        {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }
    public List<Rodada> loadFromTrash()
    {
        List<Rodada> aux = new ArrayList<>();
        aux = this.findAll();
        List<Rodada> excluidos = new ArrayList<>();
        for(Rodada temp : aux)
        {
            if(temp.isLixo() == true)
            {
                excluidos.add(temp);
            }      
        }
        return excluidos; 
    }
    
    public List<Rodada> loadFromDataBase()
    {
        List<Rodada> aux = new ArrayList<>();
        aux = this.findAll();
        List<Rodada> incluidos = new ArrayList<>();
        for(Rodada temp : aux)
        {
            if(temp.isLixo() == false)
            {
                incluidos.add(temp);
            }      
        }
        return incluidos; 
    }
    public void restoreFromTrash(Rodada rodadas) {
        rodadas.setLixo(false);
        this.saveOrUpdate(rodadas);
    }

    public void restoreFromTrash(List<Rodada> rodadas) {
        for (Rodada aux : rodadas) {
            aux.setLixo(false);
            this.saveOrUpdate(aux); 
        } 
    }   
      public void moveToTrash(Long rodadaId) {
        Rodada rodadaParaMover = this.findById(rodadaId);
        if (rodadaParaMover != null) {
            rodadaParaMover.setLixo(true);
            this.saveOrUpdate(rodadaParaMover);
        } else {
            throw new IllegalArgumentException("Partida com ID " + rodadaId + " não encontrada.");
        }
    }
    
    public void restoreFromTrash(Long rodadaId) {
        Rodada rodadaParaRestaurar = this.findById(rodadaId);
        if (rodadaParaRestaurar != null) {
            rodadaParaRestaurar.setLixo(false);
            this.saveOrUpdate(rodadaParaRestaurar);
        } else {
            throw new IllegalArgumentException("Partida com ID " + rodadaId + " não encontrada.");
        }
    }
}
