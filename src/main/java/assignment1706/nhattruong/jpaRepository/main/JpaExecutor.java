package assignment1706.nhattruong.jpaRepository.main;

import java.util.List;

public interface JpaExecutor<T> {
    List<T> findAll();
    void add(T entity);

}
