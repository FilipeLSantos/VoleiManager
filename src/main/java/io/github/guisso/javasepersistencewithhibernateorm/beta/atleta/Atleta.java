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
package io.github.guisso.javasepersistencewithhibernateorm.beta.atleta;

import io.github.guisso.javasepersistencewithhibernateorm.beta.equipe.Equipe;
import io.github.guisso.javasepersistencewithhibernateorm.beta.pessoa.Pessoa;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author robert
 */
@Entity
public class Atleta 
        extends Pessoa
        implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false)
    private int numeroCamisa;
    @Column(nullable = false)
    private boolean lixo;
    private Equipe equipe;
    
    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    
    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public boolean isLixo() {
        return lixo;
    }

    public void setLixo(boolean lixo) {
        this.lixo = lixo;
    }
    
    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    
//</editor-fold>
}
