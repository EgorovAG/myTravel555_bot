package com.example.myTravel555_bot.repository;

import com.example.myTravel555_bot.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RepositoryRestResource()
public interface TravelJpaRepository extends JpaRepository<Travel, Long> {

    Optional<Travel> findByCity(@Param("city") String city);

    void deleteByCity(@Param("city") String city);

    @Modifying
    @Transactional
    @Query(value = "update Travel set description = :description where city = :city ")
    void update(@Param("description") String description,
                @Param("city") String city);
}
