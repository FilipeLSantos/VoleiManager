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

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Samuel Paranhos
 */

@MappedSuperclass
public class Pessoa{
    
    @Column (nullable = false, length = 50)
    private String nome;
    @Column (nullable = false, unique = true, length = 11)
    private Long cpf;
    @Column (nullable = false)
    private LocalDate date;


    @Transient
    public Integer getIdade(){
           return Period.between(this.date, LocalDate.now()).getYears();
    };

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
//</editor-fold>
    
    
}
