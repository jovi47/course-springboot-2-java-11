package com.joaozin.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joaozin.course.entities.User;
import com.joaozin.course.repositories.UserRepository;
import com.joaozin.course.services.exceptions.DatabaseException;
import com.joaozin.course.services.exceptions.ResourceNotFoundException;

@Service // @Component tb serve, porem mais generico
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setEmail((obj.getEmail() == null) ? entity.getEmail() : obj.getEmail());
		entity.setName((obj.getName() == null) ? entity.getName() : obj.getName());
		entity.setPhone((obj.getPhone() == null) ? entity.getPhone() : obj.getPhone());
		entity.setPassword((obj.getPassword() == null) ? entity.getPassword() : obj.getPassword());
	}
}
