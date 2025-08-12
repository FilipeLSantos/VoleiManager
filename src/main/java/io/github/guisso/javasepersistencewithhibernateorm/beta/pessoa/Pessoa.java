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
package io.github.guisso.javasepersistencewithhibernateorm.beta.pessoa;

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author SamuelParanhos
 */
@MappedSuperclass
public class Pessoa
        extends ProjectEntity {

    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(nullable = false)
    private LocalDate date;

    private int idade;

    @Transient
    public Integer getIdade() {
        return Period.between(this.date, LocalDate.now()).getYears();
    }

    ;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//</editor-fold>
    
    
    public boolean validacao(String cpf) {
        char digD, digV;
        int soma, peso, num, resto;

        if (cpf == null) {
            return false;
        }

        String cpfClean = cpf.replaceAll("[^0-9]", "");

        if (cpfClean.length() != 11 || !cpfClean.matches("\\d{11}")) {
            return false;
        }

        // Primeiro digito verificador
        peso = 10;
        soma = 0;

        for (int i = 0; i <= 8; i++) {
            num = Character.getNumericValue(cpfClean.charAt(i));
            soma += num * peso;
            peso--;
        }

        resto = 11 - (soma % 11);

        if (resto == 10 || resto == 11) {
            digD = '0';
        } else {
            digD = (char) (resto + '0');
        }

        // Segundo  digito verificador
        soma = 0;
        peso = 11;

        for (int i = 0; i <= 9; i++) {
            num = Character.getNumericValue(cpfClean.charAt(i));

            soma += num * peso;
            peso--;
        }

        resto = 11 - (soma % 11);

        if (resto == 10 || resto == 11) {
            digV = '0';
        } else {
            digV = (char) (resto + '0');
        }

        return ((digD == cpfClean.charAt(9)) && (digV == cpfClean.charAt(10)));
    }
}
