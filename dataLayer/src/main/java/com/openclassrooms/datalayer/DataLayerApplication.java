package com.openclassrooms.datalayer;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.service.CategoryService;
import com.openclassrooms.datalayer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.datalayer.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(DataLayerApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {





        Optional<Comment> optionalComment = commentService.getCommentById(1);
        System.out.println(optionalComment.get().getContent());
        Comment commentId = optionalComment.get();
        System.out.println(commentId.getProduct().getName());
        commentId.getProduct().getComments().forEach(comment -> System.out.println(comment.getContent()));

        Category newCategory = new Category();
        newCategory.setName("Promotion");
        categoryService.addCategory(newCategory);
        categoryService.getCategories().forEach(category -> System.out.println(category.getName()));

        Product newProduct = new Product();
        newProduct.setName("Produit 1");
        newProduct.setDescription("Description du produit 1");
        newProduct.setCost(10);
        newCategory.addProduct(newProduct);
        productService.addProduct(newProduct);
        productService.getProducts().forEach(product -> System.out.println(product.getName()));
        newProduct.getCategories().forEach(category -> System.out.println(category.getName()));




    }

}
