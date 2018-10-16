package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.twitter.Entity.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    @Query("select a.role from Role a, User b where b.userName=?1 and a.userid=b.userId")
//    public List<String> findRoleByUserName(String username);
}
