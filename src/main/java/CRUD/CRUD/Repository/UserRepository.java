package CRUD.CRUD.Repository;

import CRUD.CRUD.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    @Query(value = "SELECT u FROM User u where u.id = :idUser", nativeQuery = false)
    User getById(@Param("idUser") Long id);

    /*@Query(value = "DELETE FROM User u WHERE u.id = :idUser", nativeQuery = false)
     void deleteUser(@Param("idUser") Long id);*/
    void deleteById(Long title);
    @Query(value = "SELECT u FROM User u where u.id = :idUser", nativeQuery = false)
    Boolean dataExist(@Param("idUser") Long id);

    List<User> findAll();
    @Transactional
    @Modifying
    @Query(value = "UPDATE User SET name = :nameNew where id = :id", nativeQuery = false)
    void update(@Param("nameNew")String name, @Param("id")Long idUser );

    @Query(value = "SELECT u.name FROM User u where u.name like :letterLooked%", nativeQuery = false)
    Page<User> findUserBeginWithLetter(@Param("letterLooked") String letter, Pageable pageable);
}