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

import io.github.guisso.javasepersistencewithhibernateorm.beta.equipe.Equipe;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.io.Serializable;

/**
 *
 * @author Filipe
 */

@Entity
public class SetVolei 
        extends ProjectEntity
        implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = true)
    private int pontuacao1;
    
    @Column(nullable = true)
    private int pontuacao2;

    @Column(nullable = false)
    private int numeroSet;
    
    private int vencedor;
    private Equipe equipe1;
    private Equipe equipe2;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public int getPontuacao1() {
        return pontuacao1;
    }

    public void setPontuacao1(int pontuacao1) {
        this.pontuacao1 = pontuacao1;
    }

    public int getPontuacao2() {
        return pontuacao2;
    }

    public void setPontuacao2(int pontuacao2) {
        this.pontuacao2 = pontuacao2;
    }

    public int getNumeroSet() {
        return numeroSet;
    }

    public void setNumeroSet(int numeroSet) {
        this.numeroSet = numeroSet;
    }

    public int getVencedor() {
        return vencedor;
    }

    public void setVencedor(int vencedor) {
        this.vencedor = vencedor;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        if(equipe1 != null){
            this.equipe1 = equipe1;
            return;
        }
        System.out.println("A equipe nao pode ser nula");
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
    if(equipe2 != null){
            this.equipe2 = equipe2;
            return;
        }
        System.out.println("A equipe nao pode ser nula");
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HashCode/Equals/toString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.pontuacao1;
        hash = 29 * hash + this.pontuacao2;
        hash = 29 * hash + this.numeroSet;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return hashCode() == obj.hashCode();
    }
    //</editor-fold>
}
