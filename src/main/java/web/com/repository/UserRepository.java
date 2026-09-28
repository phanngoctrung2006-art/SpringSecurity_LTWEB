package web.com.repository;

import web.com.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
    Page<User> findByEmailContainingIgnoreCaseOrFullNameContainingIgnoreCase(
        String email, String fullName, Pageable pageable);

    @Query("""
        SELECT u
        FROM User u
        JOIN FETCH u.role
        WHERE u.email = :email
    """)
    Optional<User> findByEmailWithRole(@Param("email") String email);
}