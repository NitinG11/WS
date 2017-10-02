package repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DO.RoleDO;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<RoleDO, Integer>{

	RoleDO findByName(String name);
}
