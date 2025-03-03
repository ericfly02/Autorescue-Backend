/**
 * Project: AUTORESCUE

 */
package autorescue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import autorescue.model.FormData;

@Repository
public interface FormDataRepository extends JpaRepository<FormData, Long> {

}
