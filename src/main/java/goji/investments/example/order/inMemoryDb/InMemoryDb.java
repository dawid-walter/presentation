package goji.investments.example.order.inMemoryDb;

import goji.investments.example.order.db.OrderJpaRepository;
import goji.investments.example.order.model.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Function;

@Repository
class InMemoryDb implements OrderJpaRepository {

    private final Map<UUID, Order> repository = new HashMap<>();

    @Override
    public List<Order> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public List<Order> findAllSorted(Sort sort) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Order> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Order getOne(UUID uuid) {
        return null;
    }

    @Override
    public Order getById(UUID uuid) {
        return null;
    }

    @Override
    public Order getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Order> S save(S entity) {
        UUID id = UUID.randomUUID();
        repository.put(id, entity);
        entity.setId(id);
        return entity;
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Order> findById(UUID uuid) {
        return Optional.of(repository.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        return repository.values().stream().toList();
    }

    @Override
    public List<Order> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }
}
