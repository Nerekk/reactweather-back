package org.example.reactweatherback.ApiRepos;

import org.example.reactweatherback.ApiEntities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("SELECT l FROM Location l WHERE l.user.id = :userId")
    List<Location> getAllForUserId(@Param("userId") Integer userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Location l WHERE l.user.id = :userId")
    void deleteAllForUserId(@Param("userId") Integer userId);
}
