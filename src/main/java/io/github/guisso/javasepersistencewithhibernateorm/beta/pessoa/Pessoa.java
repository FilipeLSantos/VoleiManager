/*
 * Copyright (C) 2025 rdpp
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
package io.github.guisso.javasepersistencewithhibernateorm.beta.pessoa;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author rdpp
 */
@Entity
public class Pessoa extends ProjectEntity
        implements Serializable {
    
      private static final long serialVersionUID = 1L;
      
     @Column(nullable = false)
     private String nome;
     
     @Column(nullable = false, length = 50)
     private Long cpf;
     
     @Column (nullable = false)
     private LocalDate data;
     
     @Transient
     private Integer idade;
     
     //<editor-fold defaultstate="collapsed" desc="Getters">
     
    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getIdade() {
        return idade;
    }
//</editor-fold>
   
 
    
    }
    

