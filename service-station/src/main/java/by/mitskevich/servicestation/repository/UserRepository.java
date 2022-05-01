package by.mitskevich.servicestation.repository;

import by.mitskevich.servicestation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long id);

    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);


}
