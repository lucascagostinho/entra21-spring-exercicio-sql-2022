package br.com.entra21.spring.exercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.spring.exercicios.model.Exercicio;

public interface IExercicioRepository extends JpaRepository<Exercicio, Integer> {

	public List<Exercicio> findByAge(Integer age);
	
	public List<Exercicio> findByFirstnameAndAge(String firstName, Integer age);
	
	public List<Exercicio> findByAgeLessThanEqual(Integer age);
	
	public List<Exercicio> findByLastnameStartingWith(String prefixo);
	
	// public List<Profile> findByEmailAndPassword(String email, String password); <- Fazer isso no projeto principal 
	
	//Fazer os exercícios que faltam(findBy) da aula10 no fim de semana
	
}
