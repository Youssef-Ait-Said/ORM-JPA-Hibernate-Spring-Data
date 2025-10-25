package ma.mundia.univers.repository;

import ma.mundia.univers.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
//methode 1 : methode de jpa :
    List<Product> findByNameContains(String mc); // 1ere methode : Spring sait automatiquement ce que nous voulons seulement du nom du methode et parametre

    List<Product> findByPriceGreaterThan(double price);

    // mwthode 2 : methode classique par querry sql :
    @Query("select p from Product p where p.name like :x") // 2eme methode
    List<Product> serach(@Param("x") String mc);

    @Query("select p from Product p where p.price> :x")
    List<Product> serachByPrice(@Param("x") double price);
}
