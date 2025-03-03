/**
 * Project: AUTORESCUE

 */
package cat.gencat.autorescue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.gencat.autorescue.model.Autorescue;

@Repository
public interface AutorescueRepository extends JpaRepository<Autorescue, Long> {

}
