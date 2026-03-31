package com.example.EDLB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSecurity {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void http_request_should_not_pass() {

    try {

      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());
      
      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());
      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());
      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());
      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());
      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());
      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());
      this.mockMvc.perform(post("/api/publications/")).andExpect(status().isForbidden());



    } catch (Exception e) {
      fail();
    }
    // Test endpoint "publicaitons"

    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());
    // this.mockMvc.perform(get("/")).andExpect(status().isForbidden());

  }
}
