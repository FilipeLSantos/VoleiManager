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
package io.github.guisso.javasepersistencewithhibernateorm.beta.equipe;

import io.github.guisso.javasepersistencewithhibernateorm.beta.atleta.Atleta;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import io.github.guisso.javasepersistencewithhibernateorm.beta.tecnico.Tecnico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author robert
 */
@Entity
public class Equipe
        extends ProjectEntity
        implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false, length = 50)
    private String nome;
    
    @Column(nullable = true)
    private boolean pago;
    
    @Column(nullable = false)
    private boolean lixo;
    
    private Tecnico tecnico;
    private ArrayList<Atleta> atletas;
    
    public Equipe()
    {
        ArrayList<Atleta> atleta = new ArrayList<>();
    }
    
    public void adicionarAtleta(Atleta atleta)
    {
        atletas.add(atleta);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean isPago() {
        return pago;
    }
    
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isLixo() {
        return lixo;
    }

    public void setLixo(boolean lixo) {
        this.lixo = lixo;
        
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HashCodes/Equals/ToString">
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + (this.pago ? 1 : 0);
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
        final Equipe other = (Equipe) obj;
        if (this.pago != other.pago) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }
    @Override
    public String toString() {
        return "Equipe{" + "nome=" + nome + ", pago=" + pago + '}';
    }
//</editor-fold>
    
}
