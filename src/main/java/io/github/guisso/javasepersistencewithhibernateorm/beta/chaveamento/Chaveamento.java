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

import java.util.Objects;

/**
 *
 * @author rdpp
 */
public class Chaveamento {

    private String evento;
    private boolean lixo;
    private boolean campeao;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public boolean isLixo() {
        return lixo;
    }

    public void setLixo(boolean lixo) {
        this.lixo = lixo;
    }

    public boolean isCampeao() {
        return campeao;
    }

    public void setCampeao(boolean campeao) {
        this.campeao = campeao;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Hash">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.evento);
        hash = 37 * hash + (this.lixo ? 1 : 0);
        hash = 37 * hash + (this.campeao ? 1 : 0);
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
        final Chaveamento other = (Chaveamento) obj;
        if (this.lixo != other.lixo) {
            return false;
        }
        if (this.campeao != other.campeao) {
            return false;
        }
        return Objects.equals(this.evento, other.evento);
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Chaveamento{" + "evento=" + evento + ", lixo=" + lixo + ", campeao=" + campeao + '}';
    }

}
