/*
 * Copyright (C) 2025 SamuelParanhos
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
package io.github.guisso.javasepersistencewithhibernateorm.beta.chaveamento;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author SamuelParanhos
 */
@Entity
public class Chaveamento extends ProjectEntity implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Column(nullable = false)
    private String evento;
    
    @Column(nullable = false)
    private boolean lixo;
    
    @Column(nullable = false)
    private String campeao;

    public String getEvento() {
        return evento;
    }

    public void setEvento(String Evento) {
        this.evento = Evento;
    }

    public boolean isLixo() {
        return lixo;
    }

    public void setLixo(boolean lixo) {
        this.lixo = lixo;
    }

    public String getCampeao() {
        return campeao;
    }

    public void setCampeao(String campeao) {
        this.campeao = campeao;
    }
    
    

    @Override
    public String toString() {
        return "Chaveamento do Evento: "  + evento + " Campeão: " + campeao;
    }
}
