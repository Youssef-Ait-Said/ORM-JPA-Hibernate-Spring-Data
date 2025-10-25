package ma.mundia.univers;

import ma.mundia.univers.entities.Product;
import ma.mundia.univers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository  productRepository;

    public static void main(String[] args) {

        SpringApplication.run(UniversApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        productRepository.save(new Product(null , "Hp" , 4500 , 10));
//        productRepository.save(new Product(null , "Dell" , 5000 , 10));
//        productRepository.save(new Product(null , "Lenovo" , 3900 , 10));
//        productRepository.save(new Product(null , "Toshiba" , 4100 , 10));

        List<Product> all = productRepository.findAll();

        all.forEach(p -> System.out.println(p.toString()));
        Product product =   productRepository.findById(Long.valueOf(1)).get();
        System.out.println("************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("************");

        List<Product> productList = productRepository.findByNameContains("l");
        productList.forEach(p ->{
            System.out.println(p);
        });

        System.out.println("---------------");

        List<Product> productList2 = productRepository.serach("%L%");
        productList2.forEach(p ->{
            System.out.println(p);
        });

        System.out.println("---------------");

        List<Product> productList3 = productRepository.findByPriceGreaterThan(4000.0);
        productList3.forEach(p ->{
            System.out.println(p);
        });

        System.out.println("---------------");

        List<Product> productList4 = productRepository.serachByPrice(4000.0);
        productList4.forEach(p ->{
            System.out.println(p);
        });


    }
}
