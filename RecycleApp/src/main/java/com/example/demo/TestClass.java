package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.*;
import com.example.demo.payload.request.SignUpRequest;
import com.example.demo.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
public class TestClass implements CommandLineRunner {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserController userController;
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    RecyclingServiceImpl recyclingCenterService;
    @Autowired
    AppointmentServiceImpl appointmentService;
    @Autowired
    RoleServiceImpl roleService;
    //  @Autowired
//    RecyclingCenterRepository recyclingCenterRepository;

    @Override
    public void run(String... args) throws Exception {

    // --ROLES--
        Role adminRole = new Role();
        adminRole.setName(RoleName.ADMIN);
        roleService.addRole(adminRole);
        Role userRole = new Role();
        userRole.setName(RoleName.USER);
        roleService.addRole(userRole);

    // --USER--
        SignUpRequest user = new SignUpRequest();
        user.setCnp("5010814220260");
        user.setFirstName("joana");
        user.setEmail("ioanavijoli@yahoo.com");
        user.setUsername("joana");
        user.setLastName("vijolie");
        user.setConfirmPassword("joana");
        user.setPassword("joana");
<<<<<<< HEAD
        userService.register(user);
<<<<<<< HEAD
        //  userService.logIn("joana","oana");
=======
        user.setRoles("USER");
        userController.registerUser(user);
>>>>>>> ea165b7 (Admin + tokens)

    //--CATEGORY
        CategoryDto category = new CategoryDto();
        category.setName("plastic");
        category.setDescription("numai plastic reciclabil reciclam");
        category.setImageType("imagine cu plastic");
        categoryService.addCategory(category);

        CategoryDto category1 = new CategoryDto();
        category1.setName("carton");
        category1.setDescription("numai carton reciclabil reciclam");
        category1.setImageType("imagine cu carton");
        categoryService.addCategory(category1);

        CategoryDto category2 = new CategoryDto();
        category2.setName("sticla");
        category2.setDescription("numai sticla reciclam");
        category2.setImageType("imagine cu sticla");
        categoryService.addCategory(category2);

        CategoryDto category3 = new CategoryDto();
        category3.setName("menajer");
        category3.setDescription("deseu menajer reciclam");
        category3.setImageType("imagine cu menajer");
        categoryService.addCategory(category3);

    //--PRODUCT--
        ProductDto product = new ProductDto();
        product.setName("sticla coca-cola plastic");
        product.setDescription("o simpla sticla");
        product.setCategory(categoryService.getCategoryByName("plastic"));
        productService.addProduct(product);

        ProductDto product1 = new ProductDto();
        product1.setName("sticla coca-cola ");
        product1.setDescription("o simpla sticla");
        product1.setCategory(categoryService.getCategoryByName("plastic"));
        productService.addProduct(product1);

        ProductDto product2 = new ProductDto();
        product2.setName("sticla de sticla coca-cola ");
        product2.setDescription("sticla de sticla");
        product2.setCategory(categoryService.getCategoryByName("sticla"));
        productService.addProduct(product2);

         //productService.findProducts("coca-cola");

    //--RECYCLINGCENTER--
        RecyclingCenter recyclingCenter=new RecyclingCenter();
        recyclingCenter.setName("centru1");
        recyclingCenter.setDescription("primul centru de reciclare");
        recyclingCenter.setCountry("Romania");
        recyclingCenter.setCity("Cluj");
        recyclingCenter.setStreet("Caleea Dorobantilor");
        recyclingCenter.setStreetNumber("98");
        recyclingCenter.setPostalCode(700400);
        recyclingCenter.setTelephone("07434535234");
        recyclingCenter.setStartWorkTime("08:00");
        recyclingCenter.setEndWorkTime("16:00");
        recyclingCenter.setCategories(Arrays.asList(categoryService.getCategoryByName("sticla"),categoryService.getCategoryByName("menajer")));
        recyclingCenterService.addCenter(recyclingCenter);

<<<<<<< HEAD
<<<<<<< HEAD
=======
*/
        userService.logIn("joana","joana");
        userService.logIn("joana","joana");
>>>>>>> 3bef93c (joana)
=======
=======
        RecyclingCenter recyclingCenter1=new RecyclingCenter();
        recyclingCenter1.setName("centru la suceava");
        recyclingCenter1.setDescription("centru fain");
        recyclingCenter1.setCountry("Romania");
        recyclingCenter1.setCity("Suceava");
        recyclingCenter1.setStreet("Bosanci");
        recyclingCenter1.setStreetNumber("98");
        recyclingCenter1.setPostalCode(700400);
        recyclingCenter1.setTelephone("07434535234");
        recyclingCenter1.setStartWorkTime("08:00");
        recyclingCenter1.setEndWorkTime("16:00");
        recyclingCenter1.setCategories(Arrays.asList(categoryService.getCategoryByName("sticla")));
        recyclingCenterService.addCenter(recyclingCenter1);

        RecyclingCenter recyclingCenter2=new RecyclingCenter();
        recyclingCenter2.setName("Bistrita Center");
        recyclingCenter2.setDescription("centru lu' maia");
        recyclingCenter2.setCountry("Romania");
        recyclingCenter2.setCity("Bistrita");
        recyclingCenter2.setStreet("Bosanci");
        recyclingCenter2.setStreetNumber("98");
        recyclingCenter2.setPostalCode(700400);
        recyclingCenter2.setTelephone("07434535234");
        recyclingCenter2.setStartWorkTime("08:00");
        recyclingCenter2.setEndWorkTime("16:00");
        recyclingCenter2.setCategories(Arrays.asList(categoryService.getCategoryByName("sticla"),categoryService.getCategoryByName("sticla")));
        recyclingCenterService.addCenter(recyclingCenter2);

        RecyclingCenter recyclingCenter3=new RecyclingCenter();
        recyclingCenter3.setName("Las Fagaras");
        recyclingCenter3.setDescription("centru la munte");
        recyclingCenter3.setCountry("Romania");
        recyclingCenter3.setCity("Fagaras");
        recyclingCenter3.setStreet("Bosanci");
        recyclingCenter3.setStreetNumber("98");
        recyclingCenter3.setPostalCode(700400);
        recyclingCenter3.setTelephone("07434535234");
        recyclingCenter3.setStartWorkTime("08:00");
        recyclingCenter3.setEndWorkTime("16:00");
        recyclingCenter3.setCategories(Arrays.asList(categoryService.getCategoryByName("sticla"),categoryService.getCategoryByName("menajer"),categoryService.getCategoryByName("carton")));
        recyclingCenterService.addCenter(recyclingCenter3);
>>>>>>> 75481ac (insert uri)

        //Appointment

        Product product12 = new Product();
        product12.setId(2L);
        product12.setName("sticla coca-cola ");
        product12.setDescription("o simpla sticla");
        product12.setCategory(categoryService.getCategoryByName("plastic"));


        Product product13 = new Product();
        product13.setId(3L);
        product13.setName("sticla de sticla coca-cola ");
        product13.setDescription("sticla de sticla");
        product13.setCategory(categoryService.getCategoryByName("sticla"));
        Appointment appointment=new Appointment();
        appointment.setOrderDate(new Date());
        appointment.setUser(userService.getUserByUsername("joana"));
        appointment.setRecyclingCenter(recyclingCenter);
        appointment.setProductList(Arrays.asList(product12,product13));
        appointmentService.addAppointment(appointment);


>>>>>>> 12eb138 (appointment table)
    }

}
