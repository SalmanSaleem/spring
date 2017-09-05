package org.salman.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.salman.spring.jpa.todo.Todo;
import org.salman.spring.jpa.todo.TodoRepository;
import org.salman.spring.model.TodoDto;
import org.salman.spring.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	TodoService todoService;

	@Autowired
	TodoRepository todoRepository;

	AtomicLong todoId = new AtomicLong();

	@RequestMapping(value = "/get-todos", method = RequestMethod.POST)
	public List<TodoDto> getTodos(@RequestBody TodoDto requestTodo) {
		List<TodoDto> todos = new ArrayList<TodoDto>();
		try {
			List<Todo> result = todoRepository.findByTitleLikeIgnoreCase("%" + requestTodo.getTitle() + "%");
			if (result != null) {
				for (Todo todoEntity : result) {
					LOGGER.info(todoEntity.toString());
					todos.add(todoService.setTodoDto(todoEntity));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todos;
	}

	@RequestMapping(value = "/save-todo", method = RequestMethod.POST)
	public void saveTodo(@RequestBody TodoDto todo) {
		try {
			Todo todoEntity = new Todo();
			todoEntity.setCreationTime(new java.sql.Date(new java.util.Date().getTime()));
			todoEntity.setModificationTime(new java.sql.Date(new java.util.Date().getTime()));
			todoEntity.setDescription(todo.getDescription());
			todoEntity.setTitle(todo.getTitle());
			todoEntity.setVersion(todoId.incrementAndGet());
			todoRepository.save(todoEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}