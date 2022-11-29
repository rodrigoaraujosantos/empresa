package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TesteService {
    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;




    @PostConstruct
    public void testarEntidades() {
        Empregado empregado1 = new Empregado(null, "José Carlos", "jc@gmail.com", 7000.0);
        Empregado empregado2 = new Empregado(null, "José Antonio", "ja@gmail.com", 8500.0);
        Empregado empregado3 = new Empregado(null, "Cláudio José", "cj@gmail.com", 8500.0);

        Endereco endereco1 = new Endereco(null, "Ubajara", "CE");
        Endereco endereco2 = new Endereco(null, "São Paulo", "SP");
        Endereco endereco3 = new Endereco(null, "São Paulo", "SP");
        // associacao 1:1
        empregado1.setEndereco(endereco1);
        empregado2.setEndereco(endereco2);
        empregado3.setEndereco(endereco3);

        this.enderecoRepository.saveAll(List.of(endereco1, endereco2, endereco3));
        this.empregadoRepository.saveAll(List.of(empregado1, empregado2, empregado3));


        // associacao 1:n

        Dependente dependente1 = new Dependente(null, "Maria Antonieta", 13);
        Dependente dependente2 = new Dependente(null, "Carlos José", 11);
        Dependente dependente3 = new Dependente(null, "Pedro Alves", 9);

        dependente1.setResponsavel(empregado1);
        dependente2.setResponsavel(empregado2);
        dependente3.setResponsavel(empregado1);

        this.dependenteRepository.saveAll(List.of(dependente1, dependente2, dependente3));

        // igualdade de objetos

//        Projeto projeto1 = new Projeto(1, "Campanha I", 2500.0, "Descricao top");
//        Projeto projeto2 = new Projeto(1, "Campanha I", 2500.0, "Descricao top");
//
//        if(projeto1.equals(projeto2)) {
//            System.out.println("São iguais!");
//        } else {
//            System.out.println("Não são iguais");
//        }
//
//        System.out.println(projeto1.hashCode());
//        System.out.println(projeto2.hashCode());
//
//        List<Projeto> projetos = new ArrayList<>();
//        projetos.add(projeto1);
//        projetos.add(projeto2);
//        System.out.println(projetos);

//        Projeto projeto3 = new Projeto(1, "Campanha I", 2660.0, "Descricao top");
//
//        projetos.remove(projeto3);
//
//        System.out.println(projetos);

        //associação n:n

        Projeto projeto1 = new Projeto(null, "Campanha de marketing I", 5000.0, "Campanha 1º semestre");
        Projeto projeto2 = new Projeto(null, "Campanha de marketing II", 8500.0, "Campanha 2º semestre");

        this.projetoRepository.saveAll(List.of(projeto1, projeto2));

        empregado1.getProjetos().add(projeto1);
        empregado1.getProjetos().add(projeto2);
        empregado2.getProjetos().add(projeto2);

        this.empregadoRepository.save(empregado1);
        this.empregadoRepository.save(empregado2);

        //remover projeto do empregado

        Empregado preguicoso = this.empregadoRepository.findById(2).orElseThrow();
        System.out.println(preguicoso.getProjetos());
        preguicoso.getProjetos().remove(projeto2);

        this.empregadoRepository.save(preguicoso);


    }
}
