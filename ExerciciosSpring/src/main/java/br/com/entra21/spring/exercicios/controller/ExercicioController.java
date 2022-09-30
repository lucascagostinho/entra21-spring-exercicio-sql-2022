package br.com.entra21.spring.exercicios.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import br.com.entra21.spring.exercicios.model.Exercicio;
import br.com.entra21.spring.exercicios.model.ItemNivel3;
import br.com.entra21.spring.exercicios.repository.IExercicioRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exercicios")

public class ExercicioController {

	@Autowired
	private IExercicioRepository exercicioRepository;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Exercicio> listar() {
		return exercicioRepository.findAll();
	}
	
	@GetMapping("/byage/{age}")
	public List<Exercicio> getByAge(@PathVariable("age")Integer age){
		return exercicioRepository.findByAge(age);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Exercicio> buscar(@PathVariable("id") int param) {
		List<Exercicio> response = exercicioRepository.findById(param).stream().toList();
		return response;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Exercicio adicionar(@RequestBody Exercicio novoUsuario) {
		return exercicioRepository.save(novoUsuario);
	}
	
	@GetMapping("/nomeeidade/{nome}/{idade}")
	public List<Exercicio> getByNameAge(@PathVariable ("nome") String nome, @PathVariable("idade")Integer idade ){
		return exercicioRepository.findByFirstnameAndAge(nome, idade);
	}
	
	@GetMapping("/buscaridademenorque/{age}")
	public List<Exercicio> getByAgeLessThanEqual(@PathVariable("age") Integer age){
		return exercicioRepository.findByAgeLessThanEqual(age);
	}
	
	@GetMapping("/comecacom/{prefixo}")
	public List<Exercicio> getByNameStartWith(@PathVariable("prefixo") String prefixo){
		return exercicioRepository.findByLastnameStartingWith(prefixo);
	}



	private void setMaturidadeNivel3(Exercicio exercicio) {

		final String PATH = "localhost:8080/exericicios";

		exercicio.setLinks(new ArrayList<>());

		exercicio.getLinks().add(new ItemNivel3("GET", PATH));

		exercicio.getLinks().add(new ItemNivel3("GET", PATH + "/" + exercicio.getId()));

		exercicio.getLinks().add(new ItemNivel3("POST", PATH));

		exercicio.getLinks().add(new ItemNivel3("PUT", PATH + "/" + exercicio.getId()));
		
		exercicio.getLinks().add(new ItemNivel3("DELETE", PATH + "/" + exercicio.getId()));

	}
}
