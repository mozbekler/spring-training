package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //Find all courses by category
    List<Course> findByCategory(String category);

    //Find all courses by category and order entities by name

    List<Course> findByCategoryOrderByName(String category);

    //Checks if a course supplied name exists. Return true if exists

    boolean existsByName(String name);

    //Returns the count of courses for the given category

    Integer countByCategory(String category);

    //Find all the courses that start with the given name

    List<Course> findByNameStartsWith(String name);

    //Find all courses by category and returns a stream

    Stream<Course> streamAllByCategory(String category);

    @Query("SELECT c from Course c WHERE c.category=:category AND c.rating >:rating")
    List<Course>  retrieveAllByCategoryAndRatingGreaterThan(@Param("category")String category, @Param("rating")int rating);




}
