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

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Filipe
 */

@Entity
public class EventoEsportivo 
        extends ProjectEntity
        implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false, length = 60)
    private String nome;
    
    @Column(nullable = false)
    private LocalDate data;
    
    @Column(nullable = false)
    private String local;
    
    @Column(nullable = true)
    private double ingressoTime;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getIngressoTime() {
        return ingressoTime;
    }

    public void setIngressoTime(double ingressoTime) {
        this.ingressoTime = ingressoTime;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HashCode/Equals/toString">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.data);
        hash = 71 * hash + Objects.hashCode(this.local);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.ingressoTime) ^ (Double.doubleToLongBits(this.ingressoTime) >>> 32));
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
    
    @Override
    public String toString(){
        return "Evento esportivo {"
                + "Nome: " + nome
                + "Data: " + data
                + "Local: " + local
                + "Ingresso time: " + ingressoTime
                + '}';
    }
    //</editor-fold>
    
}

