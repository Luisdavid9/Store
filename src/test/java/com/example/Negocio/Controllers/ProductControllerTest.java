package com.example.Negocio.Controllers;

import com.example.Negocio.Domain.Producto.*;
import com.example.Negocio.Services.ProductsService;
import com.example.Negocio.exceptions.ProductDoesNotExist;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    ProductsService service;

    private ProductOperation productOperation;

    private List<ProductOperationRequest> array;

    @Test
    void insertOne() throws Exception {

        ProductOperationRequest product = ProductOperationRequest.of(
                Name.of("Andres"),
                Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed..."),
                BasePrice.of(new BigDecimal("553.26")),
                TaxRate.of(new BigDecimal("0.25")),
                ProductStatus.valueOf("PUBLICADO"),
                InventoryQuantity.of(88)
        );

        String productJson = this.gson.toJson(product);

        when(service.insertOne(any(), any(), any(), any(), any(), any()))
                .thenReturn(ProductOperationSuccess.of(product));

        //act
        this.mockMvc.perform(post("/api/v1/times")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(productJson));

    }

    @Test
    void insertOneEmpty() throws Exception {
        when(service.insertOne(any(), any(), any(), any(), any(), any()))
                .thenReturn(null);

        //act
        this.mockMvc.perform(post("/api/v1/times"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    void findById() throws Exception {

        ProductOperationRequest product = ProductOperationRequest.of(
                Name.of("Andres"),
                Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed..."),
                BasePrice.of(new BigDecimal("553.26")),
                TaxRate.of(new BigDecimal("0.25")),
                ProductStatus.valueOf("PUBLICADO"),
                InventoryQuantity.of(88)
        );

        when(service.findById(anyLong()))
                .thenReturn(ProductOperationSuccess.of(product));
        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times/1");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findByIdEmpty() throws Exception {
        when(service.findById(anyLong()))
                .thenReturn(ProductOperationFailture.of(ProductDoesNotExist.of(anyLong())));
        //        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times/1");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        when(service.findAll())
                .thenReturn(array);
        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times/list");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findAllEmpty() throws Exception {
        when(service.findAll())
                .thenReturn(array);
        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times/list");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void updateOne() throws Exception {
        ProductOperationRequest product = ProductOperationRequest.of(
                Name.of("Andres"),
                Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed..."),
                BasePrice.of(new BigDecimal("553.26")),
                TaxRate.of(new BigDecimal("0.25")),
                ProductStatus.valueOf("PUBLICADO"),
                InventoryQuantity.of(88)
        );

        String productJson = this.gson.toJson(product);

        when(service.updateOne(any(),any(), any(), any(), any(), any(), any()))
                .thenReturn(ProductOperationSuccess.of(product));

        //act
        this.mockMvc.perform(put("/api/v1/times/1")
                .param("id","1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    void updateOneEmpty() throws Exception {
        when(service.insertOne(any(), any(), any(), any(), any(), any()))
                .thenReturn(null);

        //act
        this.mockMvc.perform(put("/api/v1/times/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    void deleteOne() throws Exception {
        ProductOperationRequest product = ProductOperationRequest.of(
                Name.of("Andres"),
                Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed..."),
                BasePrice.of(new BigDecimal("553.26")),
                TaxRate.of(new BigDecimal("0.25")),
                ProductStatus.valueOf("PUBLICADO"),
                InventoryQuantity.of(88)
        );
        when(service.deleteOne(anyLong()))
                .thenReturn(ProductOperationSuccess.of(product));
        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times/1");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteOneEmpty() throws Exception {
        when(service.deleteOne(anyLong()))
                .thenReturn(ProductOperationFailture.of(ProductDoesNotExist.of(anyLong())));
        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times/1");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }
}