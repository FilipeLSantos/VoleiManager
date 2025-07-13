/*
 * Copyright (C) 2025 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
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
package io.github.guisso.javasepersistencewithhibernateorm.beta;

import io.github.guisso.javasepersistencewithhibernateorm.beta.EventoEsportivo.EventoEsportivoRepository;
import io.github.guisso.javasepersistencewithhibernateorm.beta.aluno.Aluno;
import io.github.guisso.javasepersistencewithhibernateorm.beta.aluno.AlunoRepository;
<<<<<<< HEAD
import io.github.guisso.javasepersistencewithhibernateorm.beta.equipe.Equipe;
import io.github.guisso.javasepersistencewithhibernateorm.beta.equipe.EquipeRepository;
//import io.github.guisso.javasepersistencewithhibernateorm.beta.credencial.Credencial;
//import io.github.guisso.javasepersistencewithhibernateorm.beta.credencial.CredencialRepository;
//import io.github.guisso.javasepersistencewithhibernateorm.beta.usuario.Usuario;
//import io.github.guisso.javasepersistencewithhibernateorm.beta.usuario.UsuarioRepository;
=======
>>>>>>> feb3b51550e35555ea14935a1d3aba8cba88d21c
import java.time.LocalDate;
import java.util.Set;

/**
 * Runs tests of the "Beta" version
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @since 0.1, Jul 1, 2025
 */
public class Program {

    public static void betaTests() {
        
        
        AlunoRepository alunoRepository = new AlunoRepository();
        Long id;
        
        Aluno a1 = new Aluno();
        a1.setNome("Ana Zaira");
        a1.setMatricula(123456789);
        a1.setNascimento(LocalDate.of(1999, 7, 1));
        
        alunoRepository.saveOrUpdate(a1);
        System.out.println("> " + a1);
        
        a1.setNome("Beariz Yana");
        
        id = alunoRepository.saveOrUpdate(a1);
        System.out.println("> " + a1);
        
        Aluno a2 = alunoRepository.findById(id);
        System.out.println("> " + a2);
        
        a2.setId(null);
        a2.setNome("Cecília Xerxes");
        
        alunoRepository.saveOrUpdate(a2);
        System.out.println("> " + a2);
        
        EquipeRepository equipeRepository = new EquipeRepository(); 
        
        Equipe e1 = new Equipe();
        e1.setNome("Angicos");
        e1.setPago(true);
        
        /*Equipe e2 = new Equipe();
        e1.setNome("Retiro");
        e1.setPago(false);*/
        
        equipeRepository.saveOrUpdate(e1);
        System.out.println("> " + e1);
         
        a2.setId(null);
        a2.setNome("Cecília Xerxes");
        
        alunoRepository.saveOrUpdate(a2);
        System.out.println("> " + a2);
        
        //boolean excluded = alunoRepository.delete(id);
        //boolean excluded = alunoRepository.delete(a2);

       // System.out.println("> " + (excluded ? "Excluded" : "Exclusion fails..."));
        
        EventoEsportivoRepository eventoEsportivoRepository = new EventoRepository();
        


    }
}
