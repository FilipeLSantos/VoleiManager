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
package io.github.guisso.javasepersistencewithhibernateorm.beta.partida;

import io.github.guisso.javasepersistencewithhibernateorm.beta.equipe.Equipe;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import io.github.guisso.javasepersistencewithhibernateorm.beta.setvolei.SetVolei;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
/*
/**
 *
 * @author robert
 */
@Entity
public class Partida 
        extends ProjectEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Column (nullable = false)
    private int quantidadeSets;
    
    @Column(nullable = false)
    private boolean lixo;
    
    private Equipe equipe1;
    private Equipe equipe2;
    
    private String vencedor;
    private ArrayList<SetVolei> sets;
    
    public Partida()
    {
        ArrayList<SetVolei> sets = new ArrayList<>();
    }
    
    public void adicionarSet(SetVolei set)
    {
        sets.add(set);
    }
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public int getQuantidadeSets() {
        return quantidadeSets;
    }

    public void setQuantidadeSets(int quantidadeSets) {
        this.quantidadeSets = quantidadeSets;
    }
    
    public void setLixo(boolean lixo) {
        this.lixo = lixo;
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
    
    //<editor-fold defaultstate="collapsed" desc="HashCode/Equals">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.quantidadeSets;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partida other = (Partida) obj;
        return this.quantidadeSets == other.quantidadeSets;
    }
    
    public boolean isLixo() {
        return lixo;
    }
    //</editor-fold>
       
    
}
