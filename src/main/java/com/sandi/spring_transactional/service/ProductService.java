package com.sandi.spring_transactional.service;

import com.sandi.spring_transactional.dto.Product;
import com.sandi.spring_transactional.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    @Transactional
    public void saveProduct(){

        for(int i = 0; i < 10;i++) {
            Product product = new Product(i, "product_" + i);
            repo.saveProduct(product);

            try {
                if (i == 7) {
                    throw new RuntimeException("7 number is arrived");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("Product is saved : " + i);
        }
    }

}
