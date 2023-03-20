package goji.investments.example.order.db;

import goji.investments.example.order.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID> {
    @Query("""
            select o
            from Order o
            """)
    List<Order> findAllPaged(Pageable pageable);

    @Query("""
            select o
            from Order o
            """)
    List<Order> findAllSorted(Sort sort);
}
