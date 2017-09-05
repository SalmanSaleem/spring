package org.salman.spring.jpa.todo;

import java.util.List;
import java.util.Optional;

import org.salman.spring.jpa.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends BaseRepository<Todo, Long> {

	void delete(Todo deleted);

	List<Todo> findAll();

	Optional<Todo> findOne(Long id);

	Todo save(Todo persisted);

	/* queries params */
	@Query("SELECT t.title FROM Todo t where t.id = :id")
	String findTitleById(@Param("id") Long id);

	/* Query params */
	@Query("SELECT t FROM Todo t WHERE " + "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR "
			+ "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
	List<Todo> findBySearchTerm(@Param("searchTerm") String searchTerm);

	/* query by method names */
	Todo findById(Long id);

	List<Todo> findByTitle(String title);

	public Todo findByTitleAndDescription(String title, String description);

	public Todo findByTitleOrDescription(String title, String description);

	public long countByTitle(String title);

	public List<Todo> findDistinctByTitle(String title);
	
	List<Todo> findByTitleLikeIgnoreCase(String title);

	/**
	 * Returns the first three todo entries whose title is given as a method
	 * parameter. If no todo entries is found, this method returns an empty
	 * list.
	 */
	public List<Todo> findFirst3ByTitleOrderByTitleAsc(String title);

	/**
	 * Returns the first three todo entries whose title is given as a method
	 * parameter. If no todo entries is found, this method returns an empty
	 * list.
	 */
	public List<Todo> findTop3ByTitleOrderByTitleAsc(String title);

	List<Todo> findByDescriptionContainsOrTitleContainsAllIgnoreCase(String descriptionPart, String titlePart);

//	List<Todo> findBySearchTermNamed(@Param("searchTerm") String searchTerm);
//
//	@Query(nativeQuery = true)
//	List<Todo> findBySearchTermNamedNative(@Param("searchTerm") String searchTerm);
}