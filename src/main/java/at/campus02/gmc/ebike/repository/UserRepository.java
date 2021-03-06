package at.campus02.gmc.ebike.repository;

import at.campus02.gmc.ebike.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u " +
            "WHERE u.email = :email")
    User queryBy(@Param("email") String email);

    User queryByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}