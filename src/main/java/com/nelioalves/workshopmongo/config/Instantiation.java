package com.nelioalves.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.workshopmongo.domain.Comment;
import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.AuthorDTO;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!","Vou viajar para São Paulo. abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hoje!", new AuthorDTO(maria));

		//add comments
		Comment comm1 = new Comment(null,"Boa viagem mano!",sdf.parse("21/03/2018"),new AuthorDTO(alex));
		Comment comm2 = new Comment(null,"Aproveite",sdf.parse("22/03/2018"),new AuthorDTO(bob));
		Comment comm3 = new Comment(null,"Tenha um ótimo dia!",sdf.parse("23/03/2018"),new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(comm1,comm2));
		post2.getComments().addAll(Arrays.asList(comm3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));

		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}

}
