package org.salman.spring.service;

import org.salman.spring.jpa.todo.Todo;
import org.salman.spring.model.TodoDto;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	public TodoDto setTodoDto(Todo todoEntity) {
		TodoDto todoDto = new TodoDto();
		todoDto.setCreationTime(todoEntity.getCreationTime());
		todoDto.setDescription(todoEntity.getDescription());
		todoDto.setId(todoEntity.getId());
		todoDto.setModificationTime(todoEntity.getModificationTime());
		todoDto.setTitle(todoEntity.getTitle());
		todoDto.setVersion(todoEntity.getVersion());
		return todoDto;
	}
}
