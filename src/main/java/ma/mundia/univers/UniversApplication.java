package ma.mundia.univers;

import ma.mundia.univers.entities.Product;
import ma.mundia.univers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository  productRepository;

    public static void main(String[] args) {

        SpringApplication.run(UniversApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null , "Hp" , 4500 , 10));
        productRepository.save(new Product(null , "Dell" , 5000 , 10));
        productRepository.save(new Product(null , "Lenovo" , 3900 , 10));
        productRepository.save(new Product(null , "Toshiba" , 4100 , 10));

    }
}
