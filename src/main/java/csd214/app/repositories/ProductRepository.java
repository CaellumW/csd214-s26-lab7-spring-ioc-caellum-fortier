package csd214.app.repositories;

import csd214.app.entities.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

//    final EntityManagerFactory emf;
//    final EntityManager em;


    List<ProductEntity> findByPriceLessThan(double price);
    List<ProductEntity> findByTitleContainingIgnoreCase(String title);
    ProductEntity findByProductId(String productId);
    void delete(Long id);
    void close();




//    public ProductRepository() {
//        this.emf = Persistence.createEntityManagerFactory("bookstore-pu");
//        this.em = emf.createEntityManager();
//    }
//
//    @Override
//    public ProductEntity save(ProductEntity entity) {
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            if (entity.getId() == null) {
//                em.persist(entity); // INSERT
//            } else {
//                entity = em.merge(entity); // UPDATE (Dirty Checking)
//            }
//            tx.commit();
//            return entity;
//        } catch (Exception e) {
//            if (tx.isActive()) tx.rollback();
//            throw e;
//        }
//    }
//
//
//
//    @Override
//    public default ProductEntity findById(Long id) {
//        return em.find(ProductEntity.class, id);
//    }
//
//    @Override
//    public List<ProductEntity> findAll() {
//        return em.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class).getResultList();
//    }
//
//    @Override
//    public void delete(Long id) {
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            ProductEntity entity = em.find(ProductEntity.class, id);
//            if (entity != null) {
//                em.remove(entity);
//            }
//            tx.commit();
//        } catch (Exception e) {
//            if (tx.isActive()) tx.rollback();
//            throw e;
//        }
//    }
//
//    @Override
//    public long count() {
//        return em.createQuery("SELECT COUNT(p) FROM ProductEntity p", Long.class)
//                .getSingleResult();
//    }
//
//    @Override
//    public int deleteAll() {
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            int deletedCount = em.createQuery("DELETE FROM ProductEntity").executeUpdate();
//            tx.commit();
//            return deletedCount;
//        } catch (Exception e) {
//            if (tx.isActive()) tx.rollback();
//            throw e;
//        }
//    }
//
//    @Override
//    public String getDataSourceType() {
//        return "";
//    }
//
//
//    @Override
//    public void close() {
//        if (em != null && em.isOpen()) em.close();
//        if (emf != null && emf.isOpen()) emf.close();
//    }
//
//    @Override
//    public ProductEntity findByProductId(String productId) {
//        try {
//            return em.createQuery(
//                            "SELECT p FROM ProductEntity p WHERE p.productId = :prodId",
//                            ProductEntity.class)
//                    .setParameter("prodId", productId) // Binds parameter safely
//                    .getSingleResult(); // Returns the single matching record
//        } catch (jakarta.persistence.NoResultException e) {
//            return null; // Return null safely if UUID is not found
//        }
//    }

}
