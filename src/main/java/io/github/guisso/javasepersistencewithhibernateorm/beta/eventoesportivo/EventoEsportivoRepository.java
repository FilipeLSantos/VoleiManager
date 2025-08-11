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
package io.github.guisso.javasepersistencewithhibernateorm.beta.eventoesportivo;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class EventoEsportivoRepository 
        extends Repository<EventoEsportivo>{
    
    private static final long serialVersionUID = 1L;

    @Override
    public String getJpqlFindAll() {
        return "SELECT ee FROM EventoEsportivo ee";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT ee FROM EventoEsportivo ee WHERE ee.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM EventoEsportivo ee WHERE ee.id = :id";
    }
         
    public void moveToTrash(EventoEsportivo eventoEsportivo)
    {
        eventoEsportivo.setLixo(true);
        this.saveOrUpdate(eventoEsportivo);
    }
    public void moveToTrash(List<EventoEsportivo> eventoEsportivo)
    {
        for(EventoEsportivo aux : eventoEsportivo)
        {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }
    public List<EventoEsportivo> loadFromTrash()
    {
        List<EventoEsportivo> aux = new ArrayList<>();
        aux = this.findAll();
        List<EventoEsportivo> excluidos = new ArrayList<>();
        for(EventoEsportivo temp : aux)
        {
            if(temp.isLixo() == true)
            {
                excluidos.add(temp);
            }      
        }
        return excluidos; 
    }
    
    public List<EventoEsportivo> loadFromDataBase()
    {
        List<EventoEsportivo> aux = new ArrayList<>();
        aux = this.findAll();
        List<EventoEsportivo> incluidos = new ArrayList<>();
        for(EventoEsportivo temp : aux)
        {
            if(temp.isLixo() == false)
            {
                incluidos.add(temp);
            }      
        }
        return incluidos; 
    }
    public void restoreFromTrash(EventoEsportivo eventoEsportivo) {
        eventoEsportivo.setLixo(false);
        this.saveOrUpdate(eventoEsportivo);
    }

    public void restoreFromTrash(List<EventoEsportivo> eventoEsportivo) {
        for (EventoEsportivo aux : eventoEsportivo) {
            aux.setLixo(false);
            this.saveOrUpdate(aux); 
        }
    }
    public void moveToTrash(Long partidaId) {
        EventoEsportivo eventoParaMover = this.findById(partidaId);
        if (eventoParaMover != null) {
            eventoParaMover.setLixo(true);
            this.saveOrUpdate(eventoParaMover);
        } else {
            throw new IllegalArgumentException("Partida com ID " + partidaId + " não encontrada.");
        }
    }
    
    public void restoreFromTrash(Long partidaId) {
        EventoEsportivo eventoParaRestaurar = this.findById(partidaId);
        if (eventoParaRestaurar != null) {
            eventoParaRestaurar.setLixo(false);
            this.saveOrUpdate(eventoParaRestaurar);
        } else {
            throw new IllegalArgumentException("Partida com ID " + partidaId + " não encontrada.");
        }
    }
}
