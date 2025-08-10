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

import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.DataSourceFactory;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.Repository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author robert
 */
@Entity
public class EquipeRepository
        extends Repository<Equipe> {

    @Override
    public String getJpqlFindAll() {
        return "SELECT e FROM Equipe e WHERE e.lixo = false";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT e FROM Equipe e e.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Equipe e WHERE e.id = :id";
    }

    public void moveToTrash(Equipe equipe) {
        equipe.setLixo(true);
        this.saveOrUpdate(equipe);
    }

    public void moveToTrash(List<Equipe> atleta) {
        for (Equipe aux : atleta) {
            aux.setLixo(true);
            this.saveOrUpdate(aux);
        }
    }

    public List<Equipe> loadFromTrash() {

        try (EntityManager em = DataSourceFactory.getEntityManager()) {

            // 1. A consulta JPQL para buscar apenas itens da lixeira
            String jpql = "FROM Equipe e WHERE e.lixo = true";

            // 2. Cria uma TypedQuery para executar a consulta
            TypedQuery<Equipe> query = em.createQuery(jpql, Equipe.class);

            // 3. Executa a consulta e retorna a lista de resultados
            return query.getResultList();

        } catch (Exception e) {
            // É uma boa prática logar o erro caso algo dê errado
            System.out.println("ERRO ao carregar da lixeira: " + e.getMessage());

            // Retorna uma lista vazia em caso de erro para não quebrar a aplicação.
            return new ArrayList<>();
        }

    }

    public void restoreFromTrash(Equipe equipe) {
        equipe.setLixo(false);
        this.saveOrUpdate(equipe);
    }

    public void restoreFromTrash(List<Equipe> equipes) {
        for (Equipe aux : equipes) {
            aux.setLixo(false);
            this.saveOrUpdate(aux);
        }
    }

}
