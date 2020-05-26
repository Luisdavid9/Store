package com.example.Negocio.Controllers;

import com.example.Negocio.Domain.Producto.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerSystemTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;


    @Test
    void createFindProduct() throws Exception {
        //Armar los string para comparar los post con los get
        ProductOperationRequest product = ProductOperationRequest.of(
                Name.of("Andres"),
                Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed..."),
                BasePrice.of(new BigDecimal("553.26")),
                TaxRate.of(new BigDecimal("0.25")),
                ProductStatus.valueOf("PUBLICADO"),
                InventoryQuantity.of(88)
        );
        String jsonExpectedPost = "{\"name\":\"Andres\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...\",\"basePrice\":553.26,\"taxRate\":0.25,\"productStatus\":\"PUBLICADO\",\"inventoryQuantity\":88}";
        String jsonProduct = this.gson.toJson(product);
        mockMvc.perform(post("/api/v1/times")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProduct))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonExpectedPost));

        String jsonExpectedGet = "{\"product\":{\"name\":\"Andres\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...\",\"basePrice\":553.26,\"taxRate\":0.25,\"productStatus\":\"PUBLICADO\",\"inventoryQuantity\":88}}";
        mockMvc.perform(get("/api/v1/times/9"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonExpectedGet));
    }

    @Test
    void productInAllProducts() throws Exception {

        ProductOperationRequest product = ProductOperationRequest.of(
                Name.of("Laura"),
                Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed..."),
                BasePrice.of(new BigDecimal("553.26")),
                TaxRate.of(new BigDecimal("0.25")),
                ProductStatus.valueOf("PUBLICADO"),
                InventoryQuantity.of(88)
        );
        String jsonExpectedPost = "{\"name\":\"Laura\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...\",\"basePrice\":553.26,\"taxRate\":0.25,\"productStatus\":\"PUBLICADO\",\"inventoryQuantity\":88}";
        String jsonProduct = this.gson.toJson(product);
        mockMvc.perform(post("/api/v1/times")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProduct))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonExpectedPost));

        mockMvc.perform(get("/api/v1/times/list"))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> {
                    MockHttpServletResponse servletResponse = mvcResult.getResponse();
                    String responseList = servletResponse.getContentAsString();
                    String[] stringSplit = responseList.split("},");
                    String newProduct = jsonExpectedPost.replace("{", "").replace("}", "");
                    List<String> stringResponses = new ArrayList<String>();
                    stringResponses = Arrays.asList(stringSplit);
                    List<String> listClean = stringResponses.stream()
                            .map(s -> s.replace("{", ""))
                            .map(s -> s.replace("[", ""))
                            .map(s -> s.replace("}]", ""))
                            .filter(s -> s.equals(newProduct))
                            .collect(Collectors.toList());
                    assertNotEquals(listClean, "");
                });
    }

    @Test
    void deleteisNotInAllProducts() throws Exception {
        ProductOperationRequest product = ProductOperationRequest.of(
                Name.of("Andres"),
                Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed..."),
                BasePrice.of(new BigDecimal("553.26")),
                TaxRate.of(new BigDecimal("0.25")),
                ProductStatus.valueOf("PUBLICADO"),
                InventoryQuantity.of(88)
        );
        String jsonExpectedPost = "{\"name\":\"Andres\",\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...\",\"basePrice\":553.26,\"taxRate\":0.25,\"productStatus\":\"PUBLICADO\",\"inventoryQuantity\":88}";
        String jsonProduct = this.gson.toJson(product);
        String uri = "/api/v1/times/44";
       mockMvc.perform(delete(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProduct))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/times/list"))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> {
                    MockHttpServletResponse servletResponse = mvcResult.getResponse();
                    String responseList = servletResponse.getContentAsString();
                    String[] stringSplit = responseList.split("},");
                    String newProduct = jsonExpectedPost.replace("{", "").replace("}", "");
                    List<String> stringResponses = new ArrayList<String>();
                    stringResponses = Arrays.asList(stringSplit);
                    List<String> listClean = stringResponses.stream()
                            .map(s -> s.replace("{", ""))
                            .map(s -> s.replace("[", ""))
                            .map(s -> s.replace("}]", ""))
                            .filter(s -> s.equals(newProduct))
                            .collect(Collectors.toList());
                    assertEquals(listClean.isEmpty(), true );
                });
    }




}