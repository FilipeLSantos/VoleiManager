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
import java.io.Serializable;

/**
 *
 * @author Filipe
 */
public class SetVoleiRepository 
        extends Repository<SetVolei>
        implements Serializable{

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
    
}
