/**
 * Project: AUTORESCUE

 */
package autorescue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import autorescue.model.Autorescue;

@Repository
public interface AutorescueRepository extends JpaRepository<Autorescue, Long> {

}
