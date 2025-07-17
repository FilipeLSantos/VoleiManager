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
package io.github.guisso.javasepersistencewithhibernateorm.partida;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author robert
 */
@Entity
public class PartidaRepository 
        extends Repository<Partida>
        implements Serializable {

    private static final long serialVersionUID = 1L;
   
     @Override
    public String getJpqlFindAll() {
        return "SELECT part FROM Partida";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT part FROM Equipe part part.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Partida part WHERE part.id = :id";
    }
}
